/**
 * ShoppingOnline.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package main;

public interface ShoppingOnline extends java.rmi.Remote {
    public java.lang.String searchProduct(java.lang.String productName) throws java.rmi.RemoteException;
    public java.lang.String showProductList() throws java.rmi.RemoteException;
    public boolean addProductToCart(java.lang.String productName) throws java.rmi.RemoteException;
    public boolean clearCart(java.lang.String address, java.lang.String ifBuy) throws java.rmi.RemoteException;
    public java.lang.String showCartList() throws java.rmi.RemoteException;
    public java.lang.String showOrderList() throws java.rmi.RemoteException;
}
