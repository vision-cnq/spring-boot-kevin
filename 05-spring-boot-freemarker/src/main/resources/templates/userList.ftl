<html>
	<head>
		<title>展示用户数据</title>
		<meta charset="utf-9"></meta>
	</head>
	
	<body>
		
		<table border="1" align="center" width="50%">
			
			<tr>
				
				<th>ID</th>
				<th>Name</th>
				<th>Age</th>
			</tr>
			
			<#list list as user >
				<tr>
					<td>${user.userid}</td>
					<td>${user.username}</td>
					<td>${user.userage}</td>
				</tr>
			</#list>	
		</table>
	</body>
</html>