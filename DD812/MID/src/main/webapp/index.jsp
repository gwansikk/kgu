<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="tblItemOB" class="webdb.jdbc.TBLItem"/>
<jsp:setProperty name="tblItemOB" property="id" value="111"/>
<% tblItemOB.readDB(); %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<p>회원정보</p>

<table>
  <thead>
  <tr>
    <th>ID</th>
    <th>PASSWD</th>
    <th>NAME</th>
    <th>NUM1</th>
    <th>NUM2</th>
    <th>EMAIL</th>
    <th>PHONE</th>
    <th>ZIPCODE/ADDRESS</th>
    <th>JOB</th>
  </thead>
  <tbody>
  <tr>
    <td>
      ${tblItemOB.id}
    </td>
    <td>
      ${tblItemOB.passwd}
    </td>
    <td>
      ${tblItemOB.name}
    </td>
    <td>
      ${tblItemOB.num1}
    </td>
    <td>
      ${tblItemOB.num2}
    </td>
    <td>
      ${tblItemOB.email}
    </td>
    <td>
      ${tblItemOB.phone}
    </td>
    <td>
      ${tblItemOB.zipcode}/${tblItemOB.address}
    </td>
    <td>
      ${tblItemOB.job}
    </td>
  </tr>
  <jsp:setProperty name="tblItemOB" property="id" value="222"/>
  <% tblItemOB.readDB(); %>
  <tr>
    <td>
      ${tblItemOB.id}
    </td>
    <td>
      ${tblItemOB.passwd}
    </td>
    <td>
      ${tblItemOB.name}
    </td>
    <td>
      ${tblItemOB.num1}
    </td>
    <td>
      ${tblItemOB.num2}
    </td>
    <td>
      ${tblItemOB.email}
    </td>
    <td>
      ${tblItemOB.phone}
    </td>
    <td>
      ${tblItemOB.zipcode}/${tblItemOB.address}
    </td>
    <td>
      ${tblItemOB.job}
    </td>
  </tr>
  </tbody>
</table>

<p>total records : ${tblItemOB.count}</p>

</body>
</html>
