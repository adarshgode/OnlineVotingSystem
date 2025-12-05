<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css">
<title>Voter Registration</title>

<style>
    body {
        margin: 0;
        padding: 0;
        background: #eef2f6;
        font-family: "Segoe UI", sans-serif;
    }

    .register-box {
        width: 50%;
        margin: 70px auto;
        background: white;
        border-radius: 12px;
        padding: 45px 40px;
        box-shadow: 0 4px 18px rgba(0,0,0,0.15);
        animation: fadeIn 0.9s ease-in-out;
    }

    .header-title {
        text-align: center;
        font-size: 34px;
        font-weight: 650;
        color: #007bff;
        margin-bottom: 22px;
    }

    label {
        font-weight: 600;
        font-size: 18px;
    }

    .btn-custom {
        width: 230px;
        font-size: 17px;
        font-weight: 550;
        padding: 10px;
    }

    .button-area {
        display: flex;
        justify-content: center;
        gap: 20px;
        margin-top: 20px;
    }

    @keyframes fadeIn {
        from { opacity: 0; transform: translateY(-20px); }
        to   { opacity: 1; transform: translateY(0); }
    }
</style>
</head>

<body>

    <div class="register-box">

        <div class="header-title">Voter Registration</div>

        <form action="voterregister" method="post">

            <!-- Aadhaar Number -->
            <div class="form-group">
                <label>Aadhaar Number</label>
                <input type="text" name="ano" class="form-control" placeholder="Enter Aadhaar number" required>
            </div>

            <!-- Name -->
            <div class="form-group">
                <label>Full Name</label>
                <input type="text" name="vname" class="form-control" placeholder="Enter full name" required>
            </div>

            <!-- Password -->
            <div class="form-group">
                <label>Create Password</label>
                <input type="password" name="vpass" class="form-control" placeholder="Create a secure password" required>
            </div>

            <!-- Age -->
            <div class="form-group">
                <label>Age</label>
                <input type="number" name="age" class="form-control" placeholder="Enter age" required>
            </div>

            <div class="text-center mt-4">
                <button class="btn btn-primary btn-custom" type="submit">Register Voter</button>
            </div>
        </form>

        <hr>

        <div class="button-area">
            <form action="candidateregister">
                <button class="btn btn-info btn-custom" type="submit">Register as Candidate</button>
            </form>

            <form action="login">
                <button class="btn btn-success btn-custom" type="submit">Go to Login</button>
            </form>
        </div>

    </div>

</body>
</html>
