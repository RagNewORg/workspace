<%@ include file="/init.jsp" %>

<%  
    String nextUser = (String)request.getAttribute("nextUser");
    out.println("Hello " + nextUser + ","); 
    out.println("<BR>how can I");
    out.println("<BR>help you?");
%>