<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<script type="application/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.3.js"></script>
<script type="application/javascript" src="${pageContext.request.contextPath}/js/jquery.validate.js"></script>
<script type="application/javascript" src="${pageContext.request.contextPath}/js/messages_zh.js"></script>

<body>
<form id="myForm">
    用户信息查询：<input type="text" name="id" id="id"/>
    <input type="button" value="查询" onclick="checkUser()"/>
    <div id="result" style="visibility: hidden ">
        <table>
            <tr>
                <td>用户名：</td>
                <td><input type="text" readonly="readonly" id="username"/></td>
            </tr>
            <tr>
                <td>性别：</td>
                <td><input type="text" readonly="readonly" id="gender"/></td>
            </tr>
            <tr>
                <td>手机：</td>
                <td><input type="text" readonly="readonly" id="phone"/></td>
            </tr>
            <tr>
                <td>地址：</td>
                <td><input type="text" readonly="readonly" id="address"/></td>
            </tr>
        </table>
    </div>
</form>
</body>
<script>
    function checkUser() {
        $.ajax({
            url:"${pageContext.request.contextPath}/user/" + $("#id").val(),
            type:"GET",
            dataType:"JSON",
            success:function (data) {
                if(data != null){
                    $("#result").css("visibility","visible");
                    $("#username").val(data.username);
                    $("#gender").val(data.gender);
                    $("#phone").val(data.phone);
                    $("#address").val(data.address);
                }
            },
            error:function (XMLHttpRequest, textStatus, errorThrown) {
                alert("发生异常")
                //alert("错误信息："+textStatus)
            }
        });
    }
</script>
</html>
