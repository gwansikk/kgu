package webdb.jdbc;

import jakarta.servlet.ServletException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TBLItem {
    private String id;
    private String passwd;
    private String name;
    private String num1;
    private String num2;
    private String email;
    private String phone;
    private String zipcode;
    private String address;
    private String job;

    private int count;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPasswd() {
        return passwd;
    }

    public String getName() {
        return name;
    }

    public String getNum1() {
        return num1;
    }

    public String getNum2() {
        return num2;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getZipcode() {
        return zipcode;
    }

    public String getAddress() {
        return address;
    }

    public String getJob() {
        return job;
    }

    public int getCount() {
        return count;
    }

    public void readDB() throws ServletException {
        Connection conn = null;
        Statement stmt = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/webdb", "root", "801506");

            if (conn == null) throw new Exception("데이터베이스에 연결할 수 없습니다.");
            stmt = (Statement) conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from tblRegister where id = '" + id + "';");

            if (rs.next()) {
                this.id = rs.getString("id");
                this.passwd = rs.getString("passwd");
                this.name = rs.getString("name");
                this.num1 = rs.getString("num1");
                this.num2 = rs.getString("num2");
                this.email = rs.getString("email");
                this.phone = rs.getString("phone");
                this.zipcode = rs.getString("zipcode");
                this.address = rs.getString("address");
                this.job = rs.getString("job");
            }

            ResultSet cnt = stmt.executeQuery("select count(*) from tblRegister;");

            if (cnt.next()) {
                this.count = cnt.getInt(1);
            }
        } catch (Exception e) {
            throw new ServletException(e);
        } finally {
            try {
                stmt.close();
            } catch (Exception ignored) {
            }
            try {
                conn.close();
            } catch (Exception ignored) {
            }
        }
    }
}
