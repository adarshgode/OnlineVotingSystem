<%@page import="java.util.List"%>
<%@page import="entity.Candidate"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css">

<title>Admin Dashboard</title>

<style>
    body {
        background: #eef2f6;
        font-family: "Segoe UI", sans-serif;
        margin: 0;
        padding: 0;
    }

    .header-bar {
        background: linear-gradient(135deg, #007bff, #0056b3);
        padding: 30px;
        text-align: center;
        color: white;
        font-size: 35px;
        font-weight: 700;
        letter-spacing: 1px;
        box-shadow: 0 4px 18px rgba(0, 0, 0, 0.2);
    }

    .result-box {
        width: 85%;
        margin: 30px auto;
        background: white;
        border-radius: 10px;
        padding: 30px;
        box-shadow: 0 4px 18px rgba(0,0,0,0.15);
    }

    .table thead {
        background: #007bff;
        color: white;
        font-size: 18px;
    }

    .table tbody tr {
        font-size: 17px;
        font-weight: 500;
    }

    .leader-row {
        background: #eaf6ff;
        border-left: 6px solid #007bff;
        font-weight: 600;
    }

    .btn-area {
        text-align: center;
        margin-top: 30px;
    }

    .btn-custom {
        font-size: 18px;
        width: 200px;
        padding: 10px;
        border-radius: 25px;
    }
</style>

</head>
<body>

<% List<Candidate> list = (List<Candidate>) request.getAttribute("list"); %>

<div class="header-bar">
    🗳️ Voting Results Dashboard
</div>

<div class="result-box">

    <table class="table table-bordered text-center">
        <thead>
            <tr>
                <th>Candidate Name</th>
                <th>Party Name</th>
                <th>Total Votes</th>
            </tr>
        </thead>

        <tbody>
        <%
            // Find Top Winner Candidate
            int maxVotes = 0;
            for (Candidate temp : list) {
                if (temp.getVoteCount() > maxVotes) {
                    maxVotes = temp.getVoteCount();
                }
            }

            for (Candidate c : list) {
        %>

            <tr class="<%= (c.getVoteCount() == maxVotes) ? "leader-row" : "" %>">
                <td><%= c.getcName() %></td>
                <td><%= c.getcParty() %></td>
                <td>
                    <b><%= c.getVoteCount() %></b>
                    <% if(c.getVoteCount() == maxVotes) { %>
                        👑
                    <% } %>
                </td>
            </tr>

        <% } %>
        </tbody>
    </table>

    <div class="btn-area d-flex justify-content-center mt-4">

    <form action="analyzeresult" class="mr-3">
        <button class="btn btn-primary btn-custom" type="submit">Analyze Result</button>
    </form>

    <form action="logout">
        <button class="btn btn-danger btn-custom" type="submit">Log Out</button>
    </form>

</div>


</div>

</body>
</html>
