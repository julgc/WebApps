<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Profile Details</title>
</head>
<body>

	<table>
		<tr>
			<th style="text-align:center;"><img
				src='<s:property value="userProfile.picture" />' /></th><td><s:property value="userProfile.name" /></td>
		</tr>
		<tr>
			<th>ID:</th>
			<td><s:property value="userProfile.id" /></td>
		</tr>
		<tr>
			<th>Profile:</th>
			<td><s:property value="userProfile.profile" /></td>
		</tr>
		<tr>
			<th>Email:</th>
			<td><s:property value="userProfile.email" /></td>
		</tr>
		<tr>
			<th>Phone:</th>
			<td><s:property value="userProfile.phone" /></td>
		</tr>
		<tr>
			<th>Address:</th>
			<td><s:property value="userProfile.address" /></td>
		</tr>
		<tr>
			<th>Age:</th>
			<td><s:property value="userProfile.age" /></td>
		</tr>
		<tr>
			<th>Date Registered:</th>
			<td><s:date name="userProfile.dateRegistered" format="MMMM dd, yyyy" /></td>
		</tr>
		<tr>
			<th>Balance:</th>
			<td><s:property value="userProfile.balance" /></td>
		</tr>
	</table>

	<input type="button" value="back" id="backBtn" />

</body>
<script type="text/javascript">
$(document).ready(function(){
	$("#backBtn").click(function(){
		$("#profiles").show();
		$("#details").hide();
	});
});
</script>
</html>