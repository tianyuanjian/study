<%-- 
    Document   : list
    Created on : 2014-8-13, 18:16:58
    Author     : Administrator
--%>
<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>

<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>更新用户</title>
    </head>
    <body>
        <form:form action="/user/update.xhtml" commandName="user">
            <table>
                <tr>
                    <td>First Name:</td>
                    <td><form:input path="firstName"/></td>
                </tr>
                <tr>
                    <td>Last Name:</td>
                    <td><form:input path="lastName"/></td>
                </tr>
                <tr>
                    <td>Sex:</td>
                    <td>Male:<form:radiobutton path="sex" value="M"/><br/>
                    <td>Female:<form:radiobutton path="sex" value="F"/></td>
                </tr>
                <tr>
                    <td>Last Name:</td>
                    <td><form:input path="age"/></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" value="保 存"/>
                    </td>
                </tr>
            </table>
        </form:form>
    </body>
</html>
