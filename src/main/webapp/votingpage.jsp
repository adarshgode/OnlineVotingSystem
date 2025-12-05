<%@page import="java.util.List"%>
<%@page import="entity.Candidate"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css">
<title>Voting Page</title>

<style>
    body {
        margin: 0;
        padding: 0;
        background: #eef1f6; /* softer clean tone */
        font-family: "Segoe UI", sans-serif;
    }

    .vote-box {
        background: #ffffff;
        border-radius: 12px;
        padding: 30px;
        width: 75%;
        margin: 40px auto;
        box-shadow: 0 4px 18px rgba(0, 0, 0, 0.12);
        transition: 0.3s ease-in-out;
    }

    /* Title Banner */
    .vote-header {
        background: #007bff;
        padding: 18px;
        color: white;
        font-weight: 600;
        letter-spacing: 1px;
        text-align: center;
        font-size: 28px;
    }

    .candidate-row {
        background: #fff;
        border-radius: 10px;
        padding: 14px 20px;
        margin-top: 12px;
        border-left: 6px solid #007bff;
        transition: 0.3s ease;
    }

    /* Hover highlight */
    .candidate-row:hover {
        background: #f7fbff;
        border-left-color: #0056b3;
        transform: translateX(3px);
    }

    .candidate-grid {
        display: grid;
        grid-template-columns: 50px auto 140px;
        align-items: center;
        text-align: center;
        font-size: 18px;
        font-weight: 500;
    }

    /* Bigger, clickable radio */
    .candidate-grid input[type="radio"] {
        transform: scale(1.4);
        cursor: pointer;
    }

    /* Selected row highlight */
    input[type="radio"]:checked + span,
    input[type="radio"]:checked ~ span {
        font-weight: 700;
        color: #007bff;
        text-shadow: 0 0 2px rgba(0, 0, 0, 0.15);
    }

    /* Submit + logout styling */
    .btn-submit {
        width: 200px;
        font-size: 18px;
        font-weight: 600;
        padding: 10px 0;
    }
</style>


</head>
<body>

<% List<Candidate> list = (List<Candidate>) request.getAttribute("list"); %>

<div class="container-fluid p-0 m-0">
    
    <div class="text-center py-4 w-100" style="background:#007bff; color:white;">
        <h2>A Single Vote Can Define The Future</h2>
    </div>

    <div class="vote-box mt-4">

       <form action="savevote" method="post">
    <% for (Candidate c : list) { %>

    <div class="candidate-row">
        <div class="candidate-grid">

            <input type="radio" name="cid" value="<%= c.getcId() %>" required>

            <span><b><%= c.getcName() %></b></span>

            <span style="color:#606060;"><%= c.getcParty() %></span>

        </div>

        <input type="hidden" name="cname_<%= c.getcId() %>" value="<%= c.getcName() %>">
        <input type="hidden" name="pname_<%= c.getcId() %>" value="<%= c.getcParty() %>">
    </div>

    <% } %>

    <div class="text-center mt-4">
        <button class="btn btn-success px-5 py-2">Submit Vote</button>
    </div>
</form>

<hr>
<div class="text-center">
    <form action="logout">
        <button class="btn btn-danger px-4">Logout</button>
    </form>
</div>


    </div>

</div>

</body>
</html>
