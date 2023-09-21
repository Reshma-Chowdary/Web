<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/MyTagLib.tld" prefix="mytag"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>

<body style="background-color: skyblue;">

<center><br>
	<h1><u>TrainTicket Booking</u></h1><br> 
	
	<label><b>From </b></label>
	
	<mytag:index columnName="trn_start" tableName="MadhuStations" driver="org.postgresql.Driver" dbUrl="jdbc:postgresql://LocalHost:5432/LocalHost?user=postgres&password=PostGres@1"/>	
	<label><b>To</b> </label>
	<mytag:index columnName="trn_end" tableName="MadhuStations" driver="org.postgresql.Driver" dbUrl="jdbc:postgresql://LocalHost:5432/LocalHost?user=postgres&password=PostGres@1"/>	
				
	<button onclick="Search()">Search</button><br> <br> 
	
	<label><b>Trains</b></label>
	<mytag:index columnName="trn_name" tableName="MadhuStations" driver="org.postgresql.Driver" dbUrl="jdbc:postgresql://LocalHost:5432/LocalHost?user=postgres&password=PostGres@1"/>	
	
	<div>
        <label for="trains">Trains</label>
        <select id="trains">
            <tag:drop table="MadhuStations" trainno="trn_no" column="trn_name" dbUrl="jdbc:postgresql://LocalHost:5432/LocalHost?user=postgres&password=PostGres@1"  driver="org.postgresql.Driver"/>
        </select>
    </div>
	
	</label><br> <br> <label><b>class</b> <select id="class">
				<option disabled selected>select</option>
				<option>Ac</option>
				<option>Sleeper</option>
				<option>general</option>
				<option>Top</option>
		</select></label> <label> <b> Date :</b> <input type=date></input></label><br>
		<h4>Passenger Details :</h4>
		Sno : <input type="text" id=no><br> Name : <input
			type="text" id=nam><br> Age : <input type="text" id=age><br>
		Gender : <select id=gen>
			<option value="male">Male</option>
			<option value="female">Female</option>
			<option value="other">Other</option>
			<option selected disabled>select</option>
		</select><br> <br>
		<button onclick="add()">Add</button>
		<br> <br>
		<table border=1 style='border-collapse: collapse'>
			<tr>
				<th>Sno</th>
				<th>Name</th>
				<th>Age</th>
				<th>Gender</th>
				<th></th>
			</tr>
			<tbody id="bd">

			</tbody>
		</table>
		<br>

		<button onclick="book()">Book</button>
		<button onclick="clear()">Clear</button>
</center>
	<script>
		var mad = new XMLHttpRequest();
		mad.open('GET', 'TicketServlet', true);
		mad.onreadystatechange = function() {
			if (mad.status === 200 && mad.readyState === 4) {
				const data = JSON.parse(mad.responseText);
				//Process(data);
			}
		}
		/*		function Process(data) {
		 const from = document.getElementById('from');
		 data.forEach(function(item) {
		 const sel = document.createElement('option');
		 sel.textContent = item.from;
		 from.appendChild(sel);
		 })

		 const to = document.getElementById('to');
		 data.forEach(function(item) {
		 const sel = document.createElement('option');
		 sel.textContent = item.to;
		 to.appendChild(sel);
		 })
		 }*/
		function Search() {
			var from = document.getElementById("from").value;
			var to = document.getElementById("to").value;
			var mad = new XMLHttpRequest();
			mad.open('GET', 'TrainServlet?from=' + from + '&to=' + to, true);
			mad.onreadystatechange = function() {
				if (mad.status === 200 && mad.readyState === 4) {
					const data = JSON.parse(mad.responseText);
					console.log(data);
					train(data);
				}
			}
			mad.send();
		}
		function train(data) {
			const from = document.getElementById('Trains');
			data.forEach(function(item) {
				const sel = document.createElement('option');
				sel.textContent = item.train;
				from.appendChild(sel);
			})
		}
		function add() {
			var no = document.getElementById("no").value;
			var nam = document.getElementById("nam").value;
			var age = document.getElementById("age").value;
			var gen = document.getElementById("gen").value;
			var mad = new XMLHttpRequest();
			mad.open('POST', 'PassengerServlet', true);
			mad.onreadystatechange = function() {
				if (mad.status === 200 && mad.readyState === 4) {
					console.log("Added");

				}
			};
			mad.send('no=' + no + '&name=' + nam + '&age=' + age + '&gen='
					+ gen);
			var db = document.getElementById("bd");
			var tr = document.createElement("tr");
			var td1 = document.createElement("td");
			var td2 = document.createElement("td");
			var td3 = document.createElement("td");
			var td4 = document.createElement("td");
			var td5 = document.createElement("td");
			td1.textContent = no;
			td2.textContent = nam;
			td3.textContent = age;
			td4.textContent = gen;
			var deleteButton = document.createElement("button");
			deleteButton.textContent = "Delete";
			deleteButton.onclick = function() {
				db.removeChild(tr);
			};
			td5.appendChild(deleteButton);
			tr.appendChild(td1);
			tr.appendChild(td2);
			tr.appendChild(td3);
			tr.appendChild(td4);
			tr.appendChild(td5);
			db.appendChild(tr);
			clear();
		}
		function clear() {
			document.getElementById("no").value = '';
			document.getElementById("nam").value = '';
			document.getElementById("age").value = '';
			document.getElementById("gen").value = '';
		}
		mad.send();
	</script>
</body>

</html>