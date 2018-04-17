/**
 * ShoppingOnlineServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package main;

public class ShoppingOnlineServiceLocator extends org.apache.axis.client.Service implements main.ShoppingOnlineService {

    public ShoppingOnlineServiceLocator() {
    }


    public ShoppingOnlineServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ShoppingOnlineServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for shoppingOnline
    private java.lang.String shoppingOnline_address = "http://localhost:8080/WebServiceProject/services/shoppingOnline";

    public java.lang.String getshoppingOnlineAddress() {
        return shoppingOnline_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String shoppingOnlineWSDDServiceName = "shoppingOnline";

    public java.lang.String getshoppingOnlineWSDDServiceName() {
        return shoppingOnlineWSDDServiceName;
    }

    public void setshoppingOnlineWSDDServiceName(java.lang.String name) {
        shoppingOnlineWSDDServiceName = name;
    }

    public main.ShoppingOnline getshoppingOnline() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(shoppingOnline_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getshoppingOnline(endpoint);
    }

    public main.ShoppingOnline getshoppingOnline(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            main.ShoppingOnlineSoapBindingStub _stub = new main.ShoppingOnlineSoapBindingStub(portAddress, this);
            _stub.setPortName(getshoppingOnlineWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setshoppingOnlineEndpointAddress(java.lang.String address) {
        shoppingOnline_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (main.ShoppingOnline.class.isAssignableFrom(serviceEndpointInterface)) {
                main.ShoppingOnlineSoapBindingStub _stub = new main.ShoppingOnlineSoapBindingStub(new java.net.URL(shoppingOnline_address), this);
                _stub.setPortName(getshoppingOnlineWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("shoppingOnline".equals(inputPortName)) {
            return getshoppingOnline();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://main", "shoppingOnlineService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://main", "shoppingOnline"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("shoppingOnline".equals(portName)) {
            setshoppingOnlineEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
