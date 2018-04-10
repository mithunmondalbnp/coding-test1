package com.monsanto.service;

import java.util.List;

import com.monsanto.dto.ShipmentDTO;
import com.monsanto.exception.InvalidWidgetCountException;
import com.monsanto.form.ShipmenForm;
import com.monsanto.model.Shipment;

public interface ShipmentService extends GenericService<Shipment, String>{

	public void addShipment(ShipmenForm shipmenForm) throws InvalidWidgetCountException;
	
	public List<ShipmentDTO> getShipmentList(ShipmenForm shipmenForm);
	
}
