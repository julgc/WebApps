<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Profile Viewer</title>
<script type="text/javascript"
	src="/UserProfileViewer/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="/UserProfileViewer/js/ajaxHelper.js"></script>
<script type="text/javascript"
	src="/UserProfileViewer/js/jquery.tablesorter.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="/UserProfileViewer/css/main.css">
</head>
<body>
	<div id="searchPanel">
		<form>
			Name:&nbsp;<input type="text" name="name" />&nbsp;&nbsp;<input
				type="submit" value="search" id="searchBtn" />
		</form>
	</div>
	<div id="result"></div>
</body>
<script type="text/javascript">
	$(document).ready(
			function() {
				$("#searchBtn").click(
						function() {
							execAjaxCall("/UserProfileViewer/profilesByName",
									$(this.form), "POST", $("#result"), null);
							return false;
						});

				execAjaxCall("/UserProfileViewer/profiles", null, "GET",
						$("#result"), null);
			});
</script>

</html>