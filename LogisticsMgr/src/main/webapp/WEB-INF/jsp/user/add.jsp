<%-- 
    Document   : add
    Created on : 2014-8-15, 14:12:08
    Author     : Administrator
--%>

<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>添加用户</title>
    </head>
    <body>
        <form method="post"action="create.xhtml">
            <table>
                <tr>
                    <th>First Name:</th>
                    <td><input type="text" name="firstName" value="" onblur="this.value=this.value.trim();"/></td>
                </tr>
                <tr>
                    <td>Last Name:</td>
                    <td><input type="text" name="lastName" value="" onblur="this.value=this.value.trim();"/></td>
                </tr>
                <tr>
                    <th>Sex:</th>
                    <td>
                        Male:<input type="radio" name="sex" value="M" checked="true" />
                        <br/>
                        Female:<input type="radio" name="sex" value="F" />
                    </td>
                </tr>
                <tr>
                    <th>Age:</th>
                    <td><input type="text" name="age" value="" onblur="this.value=this.value.trim();"/></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" value="添 加"/>
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>
