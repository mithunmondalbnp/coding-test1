package com.monsanto.dao;

import java.util.List;

import com.monsanto.form.ShipmenForm;
import com.monsanto.model.Shipment;

public interface ShipmentDAO extends GenericDAO<Shipment, String>{

	public List<Shipment> getShipments(ShipmenForm shipmenForm);
}
