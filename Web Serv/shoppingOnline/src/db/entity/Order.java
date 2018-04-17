package db.entity;

import java.io.Serializable;
import java.sql.Date;

@SuppressWarnings("serial")
public class Order implements Serializable {
	int id;
	String name;
	String items;
	Date ordered;
	Date shipped;
	String ship_to;
	int status;
	int total;
	
	@Override
	public String toString() {
		String result = "订单号："+id+"  客户姓名："+name+
				"  购买商品："+items+"  下订单日期："+ordered.getYear()+"年"+
				ordered.getMonth()+"月"+ordered.getDay()+"日"+
				"  送货日期："+shipped.getYear()+"年"+shipped.getMonth()+"月"
				+shipped.getDay()+"日"+"  送货地址："+ship_to;
		if (status == 0)
			result += "  订单状态：已取消";
		else if (status == 1)
			result += "  订单状态：已支付";
		result += ("  应付："+total);
		return result;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getItems() {
		return items;
	}
	public void setItems(String items) {
		this.items = items;
	}
	public Date getOrdered() {
		return ordered;
	}
	public void setOrdered(Date ordered) {
		this.ordered = ordered;
	}
	public Date getShipped() {
		return shipped;
	}
	public void setShipped(Date shipped) {
		this.shipped = shipped;
	}
	public String getShip_to() {
		return ship_to;
	}
	public void setShip_to(String ship_to) {
		this.ship_to = ship_to;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	
}
