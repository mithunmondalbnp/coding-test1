package com.monsanto.dto;

import java.util.List;

import com.monsanto.model.Widget;

public class ShipmentDTO {

	private String shipmentId;
	
	private String shipmentName;

	private List<Widget> widgets;
	
	private String createdOn;

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
	 * @return the createdOn
	 */
	public String getCreatedOn() {
		return createdOn;
	}

	/**
	 * @param createdOn the createdOn to set
	 */
	public void setCreatedOn(String createdOn) {
		this.createdOn = createdOn;
	}
	
}
