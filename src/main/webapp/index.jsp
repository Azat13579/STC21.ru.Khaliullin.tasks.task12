<%@ page import="task.UserDirectoryEJB" %>
<%@ page import="javax.naming.InitialContext" %>
<html>
<body>
<h2>Hello World!</h2>
<%
    InitialContext context = new InitialContext();
    UserDirectoryEJB mySourceOfProblemsEJB =
            (UserDirectoryEJB)context.lookup("java:module/UserDirectoryEJB");

%>

<%=mySourceOfProblemsEJB.getString() %>

</body>
</html>
