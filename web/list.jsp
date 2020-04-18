<%@ page contentType="text/html;charset=utf-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!-- 网页使用的语言 -->
<html lang="zh-CN">
<head>
    <!-- 指定字符集 -->
    <meta charset="utf-8">
    <!-- 使用Edge最新的浏览器的渲染方式 -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- viewport视口：网页可以根据设置的宽度自动进行适配，在浏览器的内部虚拟一个容器，容器的宽度与设备的宽度相同。
    width: 默认宽度与设备的宽度相同
    initial-scale: 初始的缩放比，为1:1 -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>用户信息管理系统</title>

    <!-- 1. 导入CSS的全局样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>
    <style type="text/css">
        td, th {
            text-align: center;
        }
    </style>
</head>
<body>
<div class="container">
    <h3 style="text-align: center">用户信息列表</h3>
    <div style="float: right;margin:5px ">
        <a class="btn btn-default btn-primary" href="./add.jsp">添加用户</a>
        <a class="btn btn-default btn-primary" href="./update.jsp">删除选中用户</a>

    </div>
    <div style="float: left;margin: 5px">
        <form class="form-inline">
            <div class="form-group">
                <label for="exampleInputName2">Name</label>
                <input type="text" class="form-control" name="name" id="exampleInputName2" placeholder="姓名">
            </div>
            <div class="form-group">
                <label for="exampleInputEmail2">Email</label>
                <input type="email" name="email" class="form-control" id="exampleInputEmail2" placeholder="电子邮箱">
            </div>
            <div class="form-group">
                <label for="Inputqq">Email</label>
                <input type="qq" name="qq" class="form-control" id="Inputqq" placeholder="QQ">
            </div>
            <button type="submit" class="btn btn-default">查询</button>
        </form>
    </div>

    <table border="1" class="table table-bordered table-hover">
        <tr class="success">
            <th>编号</th>
            <th>姓名</th>
            <th>性别</th>
            <th>年龄</th>
            <th>籍贯</th>
            <th>QQ</th>
            <th>邮箱</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${requestScope.users}" var="user" varStatus="s">
            <tr>
                <td>${s.count}</td>
                <td>${user.name}</td>
                <td>${user.gender}</td>
                <td>${user.age}</td>
                <td>${user.address}</td>
                <td>${user.qq}</td>
                <td>${user.email}</td>
                <td><a class="btn btn-default btn-sm" href="./update?id=${user.id}">修改</a>&nbsp;<a
                        class="btn btn-default btn-sm"
                        href="#" onclick="deleteUser(${user.id})">删除</a></td>
            </tr>
        </c:forEach>


        <tr>
            <td colspan="8" align="center"><a class="btn btn-primary" href="./add.jsp">添加联系人</a></td>
        </tr>
    </table>
    <div>
        <nav aria-label="Page navigation">
            <ul class="pagination">
                <li>
                    <a href="#" aria-label="Previous">
                        <span aria-hidden="true">&laquo;</span>
                    </a>
                </li>
                <li><a href="#">1</a></li>
                <li><a href="#">2</a></li>
                <li><a href="#">3</a></li>
                <li><a href="#">4</a></li>
                <li><a href="#">5</a></li>
                <li>
                    <a href="#" aria-label="Next">
                        <span aria-hidden="true">&raquo;</span>
                    </a>
                </li>
                <span style="font-size: 20px;margin: 5px">
                共${user_count}条记录,${user_count/20+((user_count%20 >0)?1:0)}页面
            </span>
            </ul>

        </nav>

    </div>
</div>
<%--删除用户提示--%>
<script>
    function deleteUser(id) {
        if (confirm("是否确定删除用户？")) {
            location.href = "./userdelete?id=" + id;
        }
    }
</script>
<c:if test="${not empty requestScope.error_info}">
    <script>
        alert(${requestScope.error_info});
    </script>
</c:if>
<c:if test="${not empty requestScope.info}">
    <script>
        alert(${requestScope.error_info});
    </script>
</c:if>

</body>
</html>
