<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
	java.util.Scanner sc = new java.util.Scanner(System.in);
	System.out.println("행 열 입력 : ");
	int row = sc.nextInt();
	int col = sc.nextInt();
	System.out.printf("행 : %d 열 : %d\n", row,col);

%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<!-- 단수 입력 받아서 구구단 찍기 테이블로 -->
	<table>
	<tbody>
	<%
		
		for(int row;){
			%>
			<tr>
				<% for(j=0;j>1 && j<10;i++){
					%>
					<td><%=i+ ":" +j %></td>
					<%	
				}
				%>
				
				</tr>
				<%
		}
		
	%>
	
	</tbody>
	</table>
	

</body>
</html> --%>