package com.monsanto.form;

import java.util.List;

import com.monsanto.model.Widget;

public class WidgetForm {

	private String widgetId;
	
	private int serialNumber;
	
    private String color;
    
    private String productionDate;
	
	private List<Widget> widgets;
	
	private String successOrErrorMessage;
	
	private String messageType;

	/**
	 * @return the widgetId
	 */
	public String getWidgetId() {
		return widgetId;
	}

	/**
	 * @param widgetId the widgetId to set
	 */
	public void setWidgetId(String widgetId) {
		this.widgetId = widgetId;
	}

	/**
	 * @return the serialNumber
	 */
	public int getSerialNumber() {
		return serialNumber;
	}

	/**
	 * @param serialNumber the serialNumber to set
	 */
	public void setSerialNumber(int serialNumber) {
		this.serialNumber = serialNumber;
	}

	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
	}

	/**
	 * @param color the color to set
	 */
	public void setColor(String color) {
		this.color = color;
	}

	/**
	 * @return the productionDate
	 */
	public String getProductionDate() {
		return productionDate;
	}

	/**
	 * @param productionDate the productionDate to set
	 */
	public void setProductionDate(String productionDate) {
		this.productionDate = productionDate;
	}

	/**
	 * @return the widgets
	 */
	public List<Widget> getWidgets() {
		return widgets;
	}

	/**
	 * @param widgets the widgets to set
	 */
	public void setWidgets(List<Widget> widgets) {
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
