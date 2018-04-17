package main;

public class ShoppingOnlineProxy implements main.ShoppingOnline {
  private String _endpoint = null;
  private main.ShoppingOnline shoppingOnline = null;
  
  public ShoppingOnlineProxy() {
    _initShoppingOnlineProxy();
  }
  
  public ShoppingOnlineProxy(String endpoint) {
    _endpoint = endpoint;
    _initShoppingOnlineProxy();
  }
  
  private void _initShoppingOnlineProxy() {
    try {
      shoppingOnline = (new main.ShoppingOnlineServiceLocator()).getshoppingOnline();
      if (shoppingOnline != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)shoppingOnline)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)shoppingOnline)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (shoppingOnline != null)
      ((javax.xml.rpc.Stub)shoppingOnline)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public main.ShoppingOnline getShoppingOnline() {
    if (shoppingOnline == null)
      _initShoppingOnlineProxy();
    return shoppingOnline;
  }
  
  public java.lang.String searchProduct(java.lang.String productName) throws java.rmi.RemoteException{
    if (shoppingOnline == null)
      _initShoppingOnlineProxy();
    return shoppingOnline.searchProduct(productName);
  }
  
  public java.lang.String showProductList() throws java.rmi.RemoteException{
    if (shoppingOnline == null)
      _initShoppingOnlineProxy();
    return shoppingOnline.showProductList();
  }
  
  public boolean addProductToCart(java.lang.String productName) throws java.rmi.RemoteException{
    if (shoppingOnline == null)
      _initShoppingOnlineProxy();
    return shoppingOnline.addProductToCart(productName);
  }
  
  public java.lang.String showCartList() throws java.rmi.RemoteException{
    if (shoppingOnline == null)
      _initShoppingOnlineProxy();
    return shoppingOnline.showCartList();
  }
  
  public java.lang.String showOrderList() throws java.rmi.RemoteException{
    if (shoppingOnline == null)
      _initShoppingOnlineProxy();
    return shoppingOnline.showOrderList();
  }
  
  public boolean clearCart(java.lang.String address, java.lang.String ifBuy) throws java.rmi.RemoteException{
    if (shoppingOnline == null)
      _initShoppingOnlineProxy();
    return shoppingOnline.clearCart(address, ifBuy);
  }
  
  
}