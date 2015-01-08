<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Insert title here</title>
</head>

<body>
<FORM name="frmPrincipal" action="dispatcher/page1" method="post">
	<INPUT type="hidden" value="parametro1" name="param1" />
	<INPUT type="hidden" value="parametro2" name="param2" />	
</FORM>

<SCRIPT language="javascript" type="text/javascript">
	alert("accediendo a otra pagina..");
	document.frmPrincipal.submit();
</SCRIPT>

</body>
</html>