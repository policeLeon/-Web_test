<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <title>添加修改课程</title>
</head>
<body>
  <form id="course" >
    <% String id = request.getParameter("id");%>
              <input type="hidden" name="id" value="<%=id%>" /><br>
    课程:  &nbsp; &nbsp; <input type="text" name="name"><br>
    课时:  &nbsp; &nbsp; <input type="text" name="hours"><br>
    学院:  &nbsp; &nbsp; <input type="text" name="sid"><br>

  <input type="submit" value="添加" formaction="${pageContext.request.contextPath}/addCourse" formmethod="post">
  <input type="submit" value="修改" formaction="${pageContext.request.contextPath}/updateCourse" formmethod="post">
  <input type="submit" value="删除" formaction="${pageContext.request.contextPath}/deleteCourse" formmethod="post">
  <input type="button" value="返回" onclick="window.location.href='courseList'">
  </form>
  <form action="/file/C:/Users/LJC/Desktop/cover" method="post" enctype="multipart/form-data">
      选择文件：<input type="file" name="upload"/><br/>
      <input type="submit" value="上传文件"/>
  </form>

</body>
</html>

