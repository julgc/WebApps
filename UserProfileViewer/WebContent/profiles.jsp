<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Profile Listing</title>
</head>
<body>
	<table>
		<tr>
			<th>Profile Listing</th>
		</tr>

		<s:iterator value="profiles" var="profile">
			<tr>
				<s:if test="#profile[1].length()>100">
					<td title='<s:property value="#profile[1]" />'><s:property
							value='#profile[1].substring(1,100)+". . ."' />
						<form>
							<input type="hidden" value='<s:property value="#profile[0]" />' />
						</form></td>
				</s:if>
				<s:else>
					<td><s:property value='<s:property value="#profile[0]" />' />
						<form>
							<input type="hidden" value="#profile[0]" />
						</form></td>
				</s:else>
			</tr>
		</s:iterator>
	</table>

</body>
</html>