package db;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import main.shoppingOnline;
import db.entity.CartItem;
import db.entity.Order;
import db.entity.Product;


public class DBHelper {
	static Connection conn = null;
	
	static Connection getConnection(){
		if (conn != null)
			return conn;
		Properties props = new Properties();
		String url,driver,username,password;
		try {
			props.load(shoppingOnline.class.getClassLoader().
					getResourceAsStream("dbinfo.properties"));
			url = props.getProperty("url");
			driver = props.getProperty("driver");
			username = props.getProperty("username");
			password = props.getProperty("password");
			Class.forName(driver);
			conn = DriverManager.getConnection(url, username , password);
		} catch (IOException | ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	
	
	public static ArrayList<Product> getProductList(){
		Connection conn = getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from product";
		ArrayList<Product> productList = new ArrayList<Product>();
		Product temp = null;
		
		try {
			 ps = conn.prepareStatement(sql);
			 rs = ps.executeQuery();
			 while(rs.next()){
				 temp = new Product();
				 temp.setId(rs.getInt(1));
				 temp.setName(rs.getString(2));
				 temp.setSupplier(rs.getString(3));
				 temp.setPrice(rs.getInt(4));
				 temp.setQuantity(rs.getInt(5));
				 productList.add(temp);
			 }
			 ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		return productList;
	}
	
	
	public static Product searchProduct(String productName){
		
		Connection conn = getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from product where name=?";
		Product temp = null;
		
		try {
			 ps = conn.prepareStatement(sql);
			 ps.setString(1, productName);
			 rs = ps.executeQuery();
			 if(rs.next()){
				 temp = new Product();
				 temp.setName(rs.getString(2));
				 temp.setSupplier(rs.getString(3));
				 temp.setPrice(rs.getInt(4));
				 temp.setQuantity(rs.getInt(5));
			 }
			 ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		return temp;
	}
	
	
	/**
	 * 把购物车里的东西清空，放入购买清单里。
	 * 若购物车里没有东西，则返回错误，否则返回成功。
	 * @return
	 */
	public static boolean addProductIntoOrderList(String address,boolean ifBuy){
		
		/*
		 * 获得购物车的所有商品信息
		 * 算出总价格
		 */
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		String sql = "select * from cart";
		ResultSet rs = null;
		String name="";
		int price=0,iRet=0;
		boolean flag = false;
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()){
				name += (rs.getString(2) + ",");
				price += rs.getInt(4);
			}
			pstmt.close();
			if ( name == "" )
				return false;
			name.substring(0,name.length()-1);//去掉最后一个字符串
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		/*
		 * 清空购物车
		 */
		sql = "delete from cart";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		/*
		 * 往订单表中添加一个新的订单
		 */
		sql = "insert into orderlist(name, items, orderd, shipped, "
				+ "ship_to, status, total) Values(?,?,?,?,?,?,?)";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "defaultUser");//默认只有一个用户，为defaultUser
			pstmt.setString(2, name);
			pstmt.setDate(3, new java.sql.Date(System.currentTimeMillis()));
			pstmt.setDate(4, new java.sql.Date(System.currentTimeMillis()));
			pstmt.setString(5, address);
			if (ifBuy)
				pstmt.setInt(6, 1);//已支付该订单
			else
				pstmt.setInt(6, 0);//取消该订单
			pstmt.setInt(7, price);
			iRet = pstmt.executeUpdate();
			pstmt.close();
			if (iRet != 0)
				flag = true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	
	public static boolean addProductToCart(String productName){
		Connection conn = getConnection();
		String sql = "select supplier,price from product where name=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String supplier="";
		int price = 0;
		int flag = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, productName);
			rs = pstmt.executeQuery();
			if (rs.next()){
				supplier = rs.getString(1);
				price = rs.getInt(2);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if (supplier=="")
			return false;
		
		sql = "insert into cart(name, supplier, price) values(?,?,?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, productName);
			pstmt.setString(2, supplier);
			pstmt.setInt(3, price);
			flag = pstmt.executeUpdate();
			if (flag != 0)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
	public static ArrayList<CartItem> getCartList(){
		Connection conn = getConnection();
		String sql = "select * from cart";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<CartItem> cartList = new ArrayList<CartItem>();
		CartItem temp = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				temp = new CartItem();
				temp.setName(rs.getString(2));
				temp.setSupplier(rs.getString(3));
				temp.setPrice(rs.getInt(4));
				cartList.add(temp);
			}
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cartList;
	}
	
	public static ArrayList<Order> getOrderList(){
		Connection conn = getConnection();
		String sql = "select * from orderlist";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<Order> orderList = new ArrayList<Order>();
		Order temp = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				temp = new Order();
				temp.setId(rs.getInt(1));
				temp.setName(rs.getString(2));
				temp.setItems(rs.getString(3));
				temp.setOrdered(rs.getDate(4));
				temp.setShipped(rs.getDate(5));
				temp.setShip_to(rs.getString(6));
				temp.setStatus(rs.getInt(7));
				temp.setTotal(rs.getInt(8));
				orderList.add(temp);
			}
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return orderList;
	}
	
	
}