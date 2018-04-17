package main;



import java.util.ArrayList;

import db.entity.*;
import db.DBHelper;

public class shoppingOnline {
	
	/**
	 * 展示所有商品的信息
	 * @return
	 */
	public String showProductList(){
		String result = "";
		ArrayList<Product> productList = DBHelper.getProductList();
		if (productList == null)
			return "";
		for (int i = 0; i < productList.size(); i++){
			result += ( productList.get(i).toString() + "-");
		}
		return result;
	}
	
	
	/**
	 * 展示所有购物车里的商品的信息
	 * @return
	 */
	public String showCartList(){
		String result="";
		ArrayList<CartItem> cartList = DBHelper.getCartList();
		if (cartList==null)
			return "";
		for (int i=0; i<cartList.size(); i++){
			result += (cartList.get(i).toString() + "-");
		}
		return result;
	}
	
	/**
	 * 展示所有购物订单的信息
	 * @return
	 */
	public String showOrderList(){
		String result="";
		ArrayList<Order> orderList = DBHelper.getOrderList();
		if (orderList==null)
			return "";
		for (int i=0; i<orderList.size(); i++){
			result += (orderList.get(i).toString() + "-");
		}
		return result;
	}
	
	
	public String searchProduct(String productName){
		Product product = DBHelper.searchProduct(productName);
		String result = "";
		if (product == null)
			return "";
		result = product.toString();
		return result;
	}
	
	
	/**
	 * 把商品添加到购物车里
	 * @param productName 商品的名字
	 * @return 是否添加成功（是否有此类商品）
	 */
	public boolean addProductToCart(String productName){
		return DBHelper.addProductToCart(productName);
	}
	
	
	/**
	 * 清空购物车，下一次订单，
	 * 订单里包括所有购物车的商品，
	 * 用户可以选择是否购买
	 * @param address 送货地址
	 * @param ifBuy 是否购买
	 * @return 是否下订单成功（购物车里有无商品）
	 */
	public boolean clearCart(String address,String ifBuy){
		boolean flag = false;
		if (ifBuy.equals("y"))
			flag = true;
		return DBHelper.addProductIntoOrderList(address,flag);
	}
	
}