package com.monsanto.model;

import java.util.Date;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="shipment")
public class Shipment {

	@Id
	private ObjectId shipmentId;

	private String shipmentName;
	
	private List<Widget> widgets;
	
	private Date createdOn;

	/**
	 * @return the shipmentId
	 */
	public ObjectId getShipmentId() {
		return shipmentId;
	}

	/**
	 * @param shipmentId the shipmentId to set
	 */
	public void setShipmentId(ObjectId shipmentId) {
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
	public Date getCreatedOn() {
		return createdOn;
	}

	/**
	 * @param createdOn the createdOn to set
	 */
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	
}
