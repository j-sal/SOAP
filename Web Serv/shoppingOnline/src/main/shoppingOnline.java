package main;



import java.util.ArrayList;

import db.entity.*;
import db.DBHelper;

public class shoppingOnline {
	
	/**
	 * չʾ������Ʒ����Ϣ
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
	 * չʾ���й��ﳵ�����Ʒ����Ϣ
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
	 * չʾ���й��ﶩ������Ϣ
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
	 * ����Ʒ��ӵ����ﳵ��
	 * @param productName ��Ʒ������
	 * @return �Ƿ���ӳɹ����Ƿ��д�����Ʒ��
	 */
	public boolean addProductToCart(String productName){
		return DBHelper.addProductToCart(productName);
	}
	
	
	/**
	 * ��չ��ﳵ����һ�ζ�����
	 * ������������й��ﳵ����Ʒ��
	 * �û�����ѡ���Ƿ���
	 * @param address �ͻ���ַ
	 * @param ifBuy �Ƿ���
	 * @return �Ƿ��¶����ɹ������ﳵ��������Ʒ��
	 */
	public boolean clearCart(String address,String ifBuy){
		boolean flag = false;
		if (ifBuy.equals("y"))
			flag = true;
		return DBHelper.addProductIntoOrderList(address,flag);
	}
	
}