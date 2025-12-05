<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css">
<title>Login</title>

<style>
    body {
        margin: 0;
        padding: 0;
        background: #eef2f6; /* subtle modern grey */
        font-family: "Segoe UI", sans-serif;
    }

    .login-box {
        width: 45%;
        margin: 70px auto;
        background: white;
        border-radius: 12px;
        padding: 45px 40px;
        box-shadow: 0 4px 18px rgba(0,0,0,0.15);
        animation: fadeIn 0.9s ease-in-out;
    }

    .login-header {
        text-align: center;
        font-size: 34px;
        font-weight: 650;
        color: #007bff;
        margin-bottom: 25px;
    }

    label {
        font-weight: 600;
        font-size: 18px;
    }

    .btn-custom {
        width: 180px;
        font-size: 18px;
        font-weight: 550;
        padding: 10px;
    }

    .button-row {
        display: flex;
        justify-content: center;
        gap: 15px;
        margin-top: 15px;
    }

    @keyframes fadeIn {
        from { opacity: 0; transform: translateY(-20px); }
        to   { opacity: 1; transform: translateY(0); }
    }
</style>
</head>

<body>

    <div class="login-box">

        <div class="login-header">Login</div>
        
        <% if(request.getAttribute("error") != null) { %>
            <p class="text-center text-danger font-weight-bold">
                <%= request.getAttribute("error") %>
            </p>
        <% } %>

        <form action="login" method="post">

            <div class="form-group">
                <label>Name</label>
                <input type="text" name="vname" class="form-control" placeholder="Enter name" required>
            </div>

            <div class="form-group">
                <label>Password</label>
                <input type="password" name="vpass" class="form-control" placeholder="Enter password" required>
            </div>

            <div class="text-center mt-4">
                <button class="btn btn-primary btn-custom" type="submit">Login</button>
            </div>
        </form>

        <hr>

        <div class="button-row">
            <form action="voterregister">
                <button class="btn btn-success btn-custom" type="submit">Register Voter</button>
            </form>

            <form action="candidateregister">
                <button class="btn btn-info btn-custom" type="submit">Register Candidate</button>
            </form>
        </div>

    </div>

</body>
</html>
