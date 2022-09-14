package CH10;
class friend {
    String name;
    String phone;
    String address;
    
    public friend(String name, String phone, String address) {
        this.name = name;
        this.phone = phone;
        this.address = address;
    }

    public void showDate(){
        System.out.println(name+":"+phone+","+address);
    }
}

class HighSchoolFriend extends friend {
    String job;
    
    public HighSchoolFriend(String name, String phone, String address, String job){
        super(name, phone, address);
        this.job = job;
    }
    
    public void showData(){
        System.out.println(name+":"+phone+","+address+" (직업="+job+")");
    }
}

class UniversityFriend extends friend {
    String major;
    
    public UniversityFriend(String name, String phone, String address, String major){
        super(name, phone, address);
        this.major = major;
    }
    
    public void showData(){
        System.out.println(name+":"+phone+","+address+" (전공="+major+")");
    }
}

public class CH10TEST2 {
    public static void main(String[] args) {
        HighSchoolFriend p1 = new HighSchoolFriend("홍길동", "010-1111-1212", "부천", "공무원");
        UniversityFriend p2 = new UniversityFriend("김철수", "010-1111-1111", "서울", "컴공");
        UniversityFriend p3 = new UniversityFriend("이영희", "010-2222-1111", "인천", "미콘");
        
        p1.showData();
        p2.showData();
        p3.showData();
    }
    
}
