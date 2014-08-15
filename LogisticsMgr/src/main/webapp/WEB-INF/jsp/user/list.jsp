<%-- 
    Document   : user_list
    Created on : 2014-8-13, 10:28:36
    Author     : Administrator
--%>

<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>用户列表</title>
    </head>
    <body>
        <table>
            <thead>
                <tr>
                    <th><label for=e1>ID</label></th>
                    <th><label for=e2>FirstName</label></th>
                    <th><label for=e2>LastName</label></th>
                    <th><label for=e2>Sex</label></th>
                    <th><label for=e2>Age</label></th>
                </tr>
            </thead>
            
            <tbody>
                <c:forEach items="${userList}" var="user">
                    <tr>
                        <td><a href="queryById/${user.userId}.xhtml">${user.userId}</a></td>
                        <td><label>${user.firstName}</label></td>
                        <td><label>${user.lastName}</label></td>
                        <td><label>${user.sex}</label></td>
                        <td><label>${user.age}</label></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <br/>
        
        <a href="add.xhtml">添加用户</a>
    </body>
</html>
