<%@page import="fallas.*" import="java.util.*" import="main.*" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    	               "http://www.w3.org/TR/html4/loose.dtd">
<%
	Criteria criteria = new Criteria();
	ArrayList<Attribute> attributeList = criteria.getAttributeList();	
	int attributeListSize =  attributeList.size();
	
	for(int i=0;i<attributeListSize;i++){
		String parameter = attributeList.get(i).getName();
		String value = request.getParameter(parameter);
		out.println(parameter+" = "+value);
		
	}

%> 