<%-- 
    Document   : login
    Created on : 2014-8-21, 17:16:53
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>用户登录</title>
    </head>
    <body>
        <form method="POST" action="authenticate.xhtml">
            <table>
                <tr>
                    <th>用户名:</th>
                    <td><input type="text" name="user.account" value="" onblur="this.value=this.value.trim();"/></td>
                </tr>
                <tr>
                    <td>密  码:</td>
                    <td><input type="text" name="user.password" value="" onblur="this.value=this.value.trim();"/></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" value="登  录"/>
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>
