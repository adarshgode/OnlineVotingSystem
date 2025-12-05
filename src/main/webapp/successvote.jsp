<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css">
<title>Success</title>

<style>
    body {
        margin: 0;
        padding: 0;
        background: #eef2f6;
        font-family: "Segoe UI", sans-serif;
    }

    .success-box {
        background: white;
        border-radius: 14px;
        width: 50%;
        margin: 80px auto;
        box-shadow: 0 4px 18px rgba(0,0,0,0.12);
        text-align: center;
        padding: 40px 30px;
        animation: fadeIn 0.8s ease-in-out;
    }

    .success-header {
        background: #28a745;
        padding: 15px;
        color: white;
        border-radius: 14px 14px 0 0;
        font-size: 28px;
        font-weight: 600;
        letter-spacing: .5px;
    }

    h3 {
        font-weight: 600;
        margin-top: 25px;
        line-height: 1.5;
    }

    .btn-login {
        width: 180px;
        padding: 10px;
        font-size: 18px;
        font-weight: 600;
    }

    /* smooth animation */
    @keyframes fadeIn {
        from { opacity: 0; transform: translateY(-20px); }
        to   { opacity: 1; transform: translateY(0); }
    }
</style>

</head>
<body>

    <div class="success-box">
        <div class="success-header">
            ✓ Vote Recorded Successfully
        </div>

        <h3>
            <%= request.getAttribute("msg") != null ? request.getAttribute("msg") : "Thank You for Voting!" %>
        </h3>

        <hr style="width:80%;">

        <p style="font-size:18px; font-weight:500;">Go To Login Page</p>

        <form action="login">
            <button class="btn btn-primary btn-login" type="submit">
                Login
            </button>
        </form>
    </div>

</body>
</html>
