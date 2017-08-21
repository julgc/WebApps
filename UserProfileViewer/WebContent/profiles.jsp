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

	<div id="profiles">
		<table id="profileTable">
			<thead><tr>
				<th>Name</th>
				<th>Age</th>
				<th>Active</th>
				<th>Blocked</th>
			</tr></thead>
			<s:set value='"data-type=\'record\'"' var="recordAttr" />
			<s:iterator value="profiles" var="profile">
				<tr <s:property value="recordAttr"/>>
					<td style="cursor: pointer;"><form>
							<s:property value="#profile[1]" />
							<input type="hidden" value='<s:property value="#profile[0]"/>'
								name="id" />
						</form></td>
						
				<td><s:property value="#profile[2]"/></td>
				<td>
					<s:if test='#profile[3].equals("checked")'><p>1</p></s:if><s:else><p>0</p></s:else>
					<input type="checkbox" <s:property value="#profile[3]"/> disabled>
				</td>
				<td>
					<s:if test='#profile[4].equals("checked")'><p>1</p></s:if><s:else><p>0</p></s:else>
					<input type="checkbox" <s:property value="#profile[4]"/> disabled>
				</td>
						
				</tr>
			</s:iterator>
		</table>
	</div>

	<div id="details"></div>

</body>
<script type="text/javascript">
	$(document).ready(
			function() {
				$("#profileTable").tablesorter();
				$("[data-type='record']").click(
						function() {
							var switchDisplay = function() {
								$("#profiles").hide();
								$("#details").show();
							};
							execAjaxCall("/UserProfileViewer/profileDetail", $(
									this).find("form"), "GET", $("#details"),
									switchDisplay);
						});
			});
</script>

</html>