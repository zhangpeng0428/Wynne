<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% String path = request.getContextPath(); %>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
    <title>铭创管理系统</title>
    <meta name="description" content="铭创管理系统" />
	<meta name="keywords" content="铭创管理系统" />
    <link rel="stylesheet" href="<%=path %>/css/pintuer.css">
    <link rel="stylesheet" href="<%=path %>/css/admin.css">
    <script src="<%=path %>/js/jquery.js"></script>
    <script src="<%=path %>/js/pintuer.js"></script>
    <script src="<%=path %>/js/respond.js"></script>
    <link type="image/x-icon" href="<%=path %>/favicon.ico" rel="shortcut icon" />
    <link href="<%=path %>/favicon.ico" rel="bookmark icon" />
</head>
<body>
<div class="container">
    <div class="line">
        <div class="xs6 xm4 xs3-move xm4-move">
            <br /><br />
            <div class="media media-y">
                <h1>铭创管理系统</h1>
            </div>
            <br /><br />
            <form name="login" action="<%=path %>/system/checklogin" method="post">
            <div class="panel">
                <div class="panel-head"><strong>用户登陆</strong></div>
                <div class="panel-body" style="padding:30px;">
                    <div class="form-group">
                        <div class="field field-icon-right">
                            <input type="text" class="input" name="user.name" placeholder="登录账号" data-validate="required:请填写账号,length#>=4:账号长度不符合要求" />
                            <span class="icon icon-user"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="field field-icon-right">
                            <input type="password" class="input" name="user.pwd" placeholder="登录密码" data-validate="required:请填写密码,length#>=4:密码长度不符合要求" />
                            <span class="icon icon-key"></span>
                        </div>
                    </div>
                    <!-- 验证码  
                    <div class="form-group">
                        <div class="field">
                            <input type="text" class="input" name="passcode" placeholder="填写右侧的验证码" data-validate="required:请填写右侧的验证码" />
                            <img src="<%=path %>/images/passcode.jpg" width="80" height="32" class="passcode" />
                        </div>
                    </div>
                    -->
                </div>
                <div class="panel-foot text-center"><button class="button button-block bg-main text-big">登  录</button></div>
            </div>
            </form><span><font color="red">${errorMsg}</font></span>
            <div class="text-right text-small text-gray padding-top"><a class="text-gray" target="_blank" href="http://www.mxtt.cc">日积月累，每天进步一点点！</a></div>
        </div>
    </div>
</div>
</body>
</html>