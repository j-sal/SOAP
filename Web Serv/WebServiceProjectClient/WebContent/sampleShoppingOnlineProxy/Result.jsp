<%@page contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<HTML>
<HEAD>
<TITLE>Result</TITLE>
</HEAD>
<BODY>

<jsp:useBean id="sampleShoppingOnlineProxyid" scope="session" class="main.ShoppingOnlineProxy" />
<%
if (request.getParameter("endpoint") != null && request.getParameter("endpoint").length() > 0)
sampleShoppingOnlineProxyid.setEndpoint(request.getParameter("endpoint"));
%>

<%
String method = request.getParameter("method");
int methodID = 0;
if (method == null) methodID = -1;

if(methodID != -1) methodID = Integer.parseInt(method);
boolean gotMethod = false;

try {
switch (methodID){ 
case 2:
        gotMethod = true;
        java.lang.String getEndpoint2mtemp = sampleShoppingOnlineProxyid.getEndpoint();
if(getEndpoint2mtemp == null){
%>
<%=getEndpoint2mtemp %>
<%
}else{
        String tempResultreturnp3 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getEndpoint2mtemp));
        %>
        <%= tempResultreturnp3 %>
        <%
}
break;
case 5:
        gotMethod = true;
        String endpoint_0id=  request.getParameter("endpoint8");
            java.lang.String endpoint_0idTemp = null;
        if(!endpoint_0id.equals("")){
         endpoint_0idTemp  = endpoint_0id;
        }
        sampleShoppingOnlineProxyid.setEndpoint(endpoint_0idTemp);
break;
case 10:
        gotMethod = true;
        main.ShoppingOnline getShoppingOnline10mtemp = sampleShoppingOnlineProxyid.getShoppingOnline();
if(getShoppingOnline10mtemp == null){
%>
<%=getShoppingOnline10mtemp %>
<%
}else{
        if(getShoppingOnline10mtemp!= null){
        String tempreturnp11 = getShoppingOnline10mtemp.toString();
        %>
        <%=tempreturnp11%>
        <%
        }}
break;
case 13:
        gotMethod = true;
        String productName_1id=  request.getParameter("productName16");
            java.lang.String productName_1idTemp = null;
        if(!productName_1id.equals("")){
         productName_1idTemp  = productName_1id;
        }
        java.lang.String searchProduct13mtemp = sampleShoppingOnlineProxyid.searchProduct(productName_1idTemp);
if(searchProduct13mtemp == null){
%>
<%=searchProduct13mtemp %>
<%
}else{
        String tempResultreturnp14 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(searchProduct13mtemp));
        if (tempResultreturnp14.equals("")){%>
        	<font color="red">对不起，没有找到该商品的信息，请重新输入正确商品名</font>
        <%}else{ %>
       		 <%= tempResultreturnp14 %>
        <%} %>
        <%
}
break;
case 18:
        gotMethod = true;
        java.lang.String showProductList18mtemp = sampleShoppingOnlineProxyid.showProductList();
if(showProductList18mtemp == null){
%>
<%=showProductList18mtemp %>
<%
}else{
        String tempResultreturnp19 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(showProductList18mtemp));
        if(tempResultreturnp19.equals("")){%>
        	对不起，当前还有没有任何商品信息	
      <%}
        String[] products = tempResultreturnp19.split("-");
        for (int i=0; i<products.length; i++){%>
            <%= products[i] %> </br>
      <%}
       
}
break;
case 21:
        gotMethod = true;
        String productName_2id=  request.getParameter("productName24");
            java.lang.String productName_2idTemp = null;
        if(!productName_2id.equals("")){
         productName_2idTemp  = productName_2id;
        }
        boolean addProductToCart21mtemp = sampleShoppingOnlineProxyid.addProductToCart(productName_2idTemp);
        if (addProductToCart21mtemp){%>
        	添加商品到购物车成功！
        <%}else{ %>
        	<font color="red">添加商品到购物车失败，没有此商品</font>
        <%}
        
break;
case 26:
        gotMethod = true;
        java.lang.String showCartList26mtemp = sampleShoppingOnlineProxyid.showCartList();
if(showCartList26mtemp == null){
%>
<%=showCartList26mtemp %>
<%
}else{
        String tempResultreturnp27 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(showCartList26mtemp));
        if (tempResultreturnp27.equals("")){%>
        	对不起，您当前的购物车暂时没有商品
       <%}
        String[] carts = tempResultreturnp27.split("-");
        for (int i=0; i<carts.length; i++){%>
            <%= carts[i] %> </br>
      <%}
}
break;
case 29:
        gotMethod = true;
        java.lang.String showOrderList29mtemp = sampleShoppingOnlineProxyid.showOrderList();
if(showOrderList29mtemp == null){
%>
<%=showOrderList29mtemp %>
<%
}else{
        String tempResultreturnp30 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(showOrderList29mtemp));
        if (tempResultreturnp30.equals("")){%>
        	对不起，您当前还没有订单
      <% }
        String[] orders = tempResultreturnp30.split("-");
        for (int i=0; i<orders.length; i++){ %>
            <%= orders[i] %> </br>
      <%}
       
        
}
break;
case 32:
        gotMethod = true;
        String address_3id=  request.getParameter("address35");
            java.lang.String address_3idTemp = null;
        if(!address_3id.equals("")){
         address_3idTemp  = address_3id;
        }
        String ifBuy_4id=  request.getParameter("ifBuy37");
            java.lang.String ifBuy_4idTemp = null;
        if(!ifBuy_4id.equals("")){
         ifBuy_4idTemp  = ifBuy_4id;
        }
        boolean clearCart32mtemp = sampleShoppingOnlineProxyid.clearCart(address_3idTemp,ifBuy_4idTemp);
        if (clearCart32mtemp){%>
        	您已成功清空购物车！
     <% }else {%>
     		<font color="red">对不起，您的购物车里没有商品，请在购物车里添加商品后再清空购物车</font>
     <%}
       
break;
}
} catch (Exception e) { 
%>
Exception: <%= org.eclipse.jst.ws.util.JspUtils.markup(e.toString()) %>
Message: <%= org.eclipse.jst.ws.util.JspUtils.markup(e.getMessage()) %>
<%
return;
}
if(!gotMethod){
%>
欢迎进入在线购物系统
<%
}
%>
</BODY>
</HTML>