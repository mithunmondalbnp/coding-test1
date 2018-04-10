package com.monsanto.form;

import java.util.List;

public class ShipmenForm {

	private String shipmentId;
	
	private String shipmentName;

	private List<String> widgets;
	
	private String successOrErrorMessage;
	
	private String messageType;

	/**
	 * @return the shipmentId
	 */
	public String getShipmentId() {
		return shipmentId;
	}

	/**
	 * @param shipmentId the shipmentId to set
	 */
	public void setShipmentId(String shipmentId) {
		this.shipmentId = shipmentId;
	}
	
	/**
	 * @return the shipmentName
	 */
	public String getShipmentName() {
		return shipmentName;
	}

	/**
	 * @param shipmentName the shipmentName to set
	 */
	public void setShipmentName(String shipmentName) {
		this.shipmentName = shipmentName;
	}

	/**
	 * @return the widgets
	 */
	public List<String> getWidgets() {
		return widgets;
	}

	/**
	 * @param widgets the widgets to set
	 */
	public void setWidgets(List<String> widgets) {
		this.widgets = widgets;
	}

	/**
	 * @return the successOrErrorMessage
	 */
	public String getSuccessOrErrorMessage() {
		return successOrErrorMessage;
	}

	/**
	 * @param successOrErrorMessage the successOrErrorMessage to set
	 */
	public void setSuccessOrErrorMessage(String successOrErrorMessage) {
		this.successOrErrorMessage = successOrErrorMessage;
	}

	/**
	 * @return the messageType
	 */
	public String getMessageType() {
		return messageType;
	}

	/**
	 * @param messageType the messageType to set
	 */
	public void setMessageType(String messageType) {
		this.messageType = messageType;
	}
	
}
