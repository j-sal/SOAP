package db.entity;

public class CartItem {
	int id;
	String name;
	String supplier;
	int price;
	
	
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
	@Override
	public String toString(){
		return "��Ʒ���ƣ�"+getName()+"  ��Ӧ�̣�"+getSupplier()+
				"  ��Ʒ�۸�"+getPrice();
	}
	
}
