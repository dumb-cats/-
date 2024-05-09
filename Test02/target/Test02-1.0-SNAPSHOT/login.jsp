<%--
  Created by IntelliJ IDEA.
  User: 狗蛋
  Date: 2023/12/14
  Time: 20:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
        body {
            background: url('https://cdn.pixabay.com/photo/2018/08/14/13/23/ocean-3605547_1280.jpg') no-repeat;
            background-size: 100% 130%;
        }

        #login_box {
            width: 20%;
            height: 400px;
            background-color: #00000060;
            margin: auto;
            margin-top: 10%;
            text-align: center;
            border-radius: 10px;
            padding: 50px 50px;
        }

        h2 {
            color: #ffffff90;
            margin-top: 5%;
        }


        span {
            color: #fff;
        }

        input {
            border: 0;
            width: 60%;
            font-size: 15px;
            color: #fff;
            background: transparent;
            border-bottom: 2px solid #fff;
            padding: 5px 10px;
            outline: none;
            margin-top: 10px;
        }

        #denglu {
            margin-top: 50px;
            width: 60%;
            height: 30px;
            border-radius: 10px;
            border: 0;
            color: #fff;
            text-align: center;
            line-height: 30px;
            font-size: 15px;
            background-image: linear-gradient(to right, #30cfd0, #330867);
        }
        .msg {
            text-align: center;
            line-height: 88px;
        }

        a {
            text-decoration-line: none;
            color: #abc1ee;
        }
    </style>
</head>

<body>
<div id="login_box">
    <h2>LOGIN</h2>
    <p><h6 style="color:lightcoral">${login_msg}</h6></p>
    <form action="/Test02/login" method="get">
        <label>
            <input type="text" name="username" placeholder="请输入账号" value=${username_re}>
        </label>
        <label>
            <input type="password" name="password" placeholder="请输入密码" value=${password_re}>
        </label>
        <input type="submit" value="登录" id="denglu">
    </form>
    <div class="msg">
        Don't have account?
        <a href="regist.jsp">Sign up</a>
    </div>
</div>
</body>
</html>
