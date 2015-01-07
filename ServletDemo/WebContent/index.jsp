<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%-- <%@ page  %> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background-color: gray;">
<FORM name="servlet" action="headers" method="GET" enctype="multipart/form-data">
<TABLE cellpadding="0" cellspacing="0" border="0" width="100%" align="center">
<TR style="height: 5px">
	<TD colspan="3">&nbsp;</TD>
</TR>
<TR>
	<TD width="25%">&nbsp;</TD>
	<TD align="center" width="50%">
		<TABLE cellpadding="0" cellspacing="0" border="0" width="100%" align="center">
		<TR>
			<TD width="1%">&nbsp;</TD>
			<TD width="47%" align="right">NOMBRE:&nbsp;</TD>
			<TD width="1%">&nbsp;</TD>
			<TD width="50%" align="left"> <INPUT name="param1" type="text"  /> </TD>
			<TD width="1%">&nbsp;</TD>
		</TR>
		<TR>
			<TD width="1%">&nbsp;</TD>
			<TD align="right">OTRO:&nbsp;</TD>
			<TD width="1%">&nbsp;</TD>
			<TD align="left"> <INPUT name="param2" type="text"  /> </TD>
			<TD width="1%">&nbsp;</TD>
		</TR>
		<TR>
			<TD width="1%">&nbsp;</TD>
			<TD align="right">file :&nbsp;</TD>
			<TD width="1%">&nbsp;</TD>
			<TD align="left"> <INPUT name="file" type="file" id="file"  /> </TD>
			<TD width="1%">&nbsp;</TD>
		</TR>
		<TR>
			<TD colspan="5">&nbsp;</TD>
		</TR>				
		<TR>
			<TD colspan="5">&nbsp;</TD>
		</TR>					
		<TR>
			<TD colspan="5" align="right">
				<INPUT name="submit" type="submit" value="Submit" style="width: 150px"/>
			</TD>
		</TR>
		</TABLE>
	</TD>
	<TD width="25%">&nbsp;</TD>	
</TR>
<TR style="height: 5px">
	<TD colspan="3">&nbsp;</TD>
</TR>
</TABLE>	
</FORM>
</body>
</html>