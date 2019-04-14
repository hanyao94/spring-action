<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>

<html>
<body>
<h2>Hello World!</h2>
<br/>

<form action="<%=path %>/fileupload" enctype="multipart/form-data" method="POST">

    selectimage: <input type="file" name="file"/><br>
    <input type="submit" value="upload"/>
</form>

</body>
</html>
