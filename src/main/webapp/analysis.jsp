<%@page import="java.util.List"%>
<%@page import="entity.Candidate"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Result Analysis</title>
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>

<style>
    body {
        background: #f5f7fa;
        font-family: Arial, sans-serif;
    }
    .box {
        width: 80%;
        margin: auto;
        margin-top: 30px;
        background: white;
        padding: 20px 30px;
        border-radius: 10px;
        box-shadow: 0px 4px 10px rgba(0,0,0,0.1);
    }
    .winner {
        background: #d4edda;
        padding: 15px;
        border-left: 5px solid #28a745;
        border-radius: 5px;
        font-size: 18px;
        margin-bottom: 15px;
    }
</style>
</head>

<body>

<%
List<Candidate> list = (List<Candidate>) request.getAttribute("list");
int totalVotes = (Integer) request.getAttribute("totalVotes");
int totalVoters = (Integer) request.getAttribute("totalVoters");
int turnout = (Integer) request.getAttribute("turnout");

Candidate winner = null;
int maxVotes = -1;

// manually find winner (no lambda)
for(Candidate c : list) {
    if(c.getVoteCount() > maxVotes) {
        maxVotes = c.getVoteCount();
        winner = c;
    }
}
%>

<div class="box">
    <h2 class="text-center">Election Insights</h2>
    <hr>

    <div class="winner">
        <b>Winner: <%= winner.getcName() %></b> | Party: <%= winner.getcParty() %> <br>
        Total Votes: <%= winner.getVoteCount() %>
    </div>

    <p><b>Total Votes Polled:</b> <%= totalVotes %></p>
    <p><b>Total Registered Voters:</b> <%= totalVoters %></p>
    <p><b>Voter Turnout:</b> <%= (turnout * 100 / totalVoters) %>%</p>

    <hr>

    <h3 class="text-center mt-4">Vote Comparison Chart</h3>
    <canvas id="voteChart"></canvas>
</div>

<script>
var ctx = document.getElementById('voteChart').getContext('2d');

var voteChart = new Chart(ctx, {
    type: 'bar',
    data: {
        labels: [
            <% for(Candidate c : list){ %> "<%= c.getcName() %>", <% } %>
        ],
        datasets: [{
            label: 'Votes',
            data: [
                <% for(Candidate c : list){ %> <%= c.getVoteCount() %>, <% } %>
            ],
            borderWidth: 2
        }]
    }
});
</script>

</body>
</html>
