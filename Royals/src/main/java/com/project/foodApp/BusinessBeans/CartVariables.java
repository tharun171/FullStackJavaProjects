package com.project.foodApp.BusinessBeans;

public class CartVariables {

	
	private final double deliveryfee = 10.00;
	private  double deliverytip = 0.00;
	private final double platformfee = 2.00;
	private final double gst = 8.75;
	/**
	 * @return the deliveryfee
	 */
	public double getDeliveryfee() {
		return deliveryfee;
	}
	/**
	 * @return the deliverytip
	 */
	public double getDeliverytip() {
		return deliverytip;
	}
	/**
	 * @return the platfromfee
	 */
	public double getPlatformfee() {
		return platformfee;
	}
	/**
	 * @return the gst
	 */
	public double getGst() {
		return gst;
	}
	@Override
	public String toString() {
		return "CartVariables [deliveryfee=" + deliveryfee + ", deliverytip=" + deliverytip + ", platformfee="
				+ platformfee + ", gst=" + gst + "]";
	}
	
	
	
	
}
