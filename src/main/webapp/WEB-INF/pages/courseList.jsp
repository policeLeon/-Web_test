<%@ page language="java" import="java.sql.Connection" contentType="text/html;charset=UTF-8" pageEncoding="gb2312" %>
<%@ page import="java.sql.*" %>
<%@ page import="com.mysql.cj.x.protobuf.MysqlxDatatypes" %>
<!DOCTYPE html>
<html>
<head>

    <title>课程列表</title>
</head>
<body>
<table border="1" align="center">
    <tr>
<%--        <th>封面</th>--%>
        <th>课程</th>
        <th>课时</th>
        <th>学院</th>
        <td>
            <input type="button" value="新增课程" onclick="window.location.href='manageCourse'" >
        </td>
    </tr>
    <%
        String driverClass="com.mysql.cj.jdbc.Driver";
        String url="jdbc:mysql://localhost:3306/web_test1?serverTimezone=UTC&characterEncoding=utf8&useUnicode=true&useSSL=false";
        String user="root";
        String password="123456";
        Connection conn;
        try{
            Class.forName(driverClass);
            conn=DriverManager.getConnection(url, user, password);
            Statement stmt=conn.createStatement();
            String sql="select * from c_course";
            ResultSet course =stmt.executeQuery(sql);
            while(course.next()){
//            request.setCharacterEncoding("GB2312");
    %>

    <tr id="course">
    <td><%=course.getString("name") %></td>
    <td><%=course.getString("hours") %></td>
    <td><%=course.getString("sid") %></td>
    <td>
        <%--            onclick="doDelete(${student.id})--%>
        <% String id = course.getString("id"); %>
        <input type="button" value="修改" onclick="window.location.href='manageCourse?id=<%=id%>'">
        <input type="button" value="删除" onclick="window.location.href='manageCourse?id=<%=id%>'" >
<%--        <input type="submit" value="删除" formaction="${pageContext.request.contextPath}/deleteCourse" formmethod="post">--%>
    </td>
    </tr>
    <%
       }
        }catch (Exception ex){
            ex.printStackTrace();
        }
    %>
</table>

<%--<script>--%>
<%--    function Delete(id) {--%>
<%--      var flag =console.log("请确认是否删除！");--%>
<%--      window.location.href("manageCourse.jsp?id=${id}");--%>
<%--    }--%>
<%--</script>--%>

</body>
</html>
