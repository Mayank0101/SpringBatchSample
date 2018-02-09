/**
 * 
 */
package com.ms.springbootbatch.model;

/**
 * @author mayankshrivastava
 *
 */
public class Customer {
 private String customerName;
 private String cunstomerLocation;
 private String dcNum;
/**
 * @return the cdNum
 */
public String getDcNum() {
	return dcNum;
}
/**
 * @param cdNum the cdNum to set
 */
public void setDcNum(String dcNum) {
	this.dcNum = dcNum;
}
/**
 * @return the customerName
 */
public String getCustomerName() {
	return customerName;
}
/**
 * @param customerName the customerName to set
 */
public void setCustomerName(String customerName) {
	this.customerName = customerName;
}
/**
 * @return the cunstomerLocation
 */
public String getCunstomerLocation() {
	return cunstomerLocation;
}
/**
 * @param cunstomerLocation the cunstomerLocation to set
 */
public void setCunstomerLocation(String cunstomerLocation) {
	this.cunstomerLocation = cunstomerLocation;
}

@Override
public String toString() {
    return customerName + " is active in " + cunstomerLocation+ " location.";
}
}
