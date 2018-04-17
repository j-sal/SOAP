package db.entity;

public class Product {
	int id;
	String name;
	String supplier;
	int price;
	int quantity;
	
	public int getId(){
		return id;
	}
	public void setId(int id){
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSupplier() {
		return supplier;
	}
	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	@Override
	public String toString(){
		return "商品id号："+getId()+"  商品名称："+getName()+"  供应商："+getSupplier()
				+"  价格："+getPrice()+"  数量："+getQuantity();
	}
}
