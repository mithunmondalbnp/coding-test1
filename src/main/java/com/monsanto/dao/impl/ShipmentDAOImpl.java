package com.monsanto.dao.impl;

import java.util.List;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.monsanto.dao.ShipmentDAO;
import com.monsanto.form.ShipmenForm;
import com.monsanto.model.Shipment;
import com.monsanto.util.Format;

@Repository(ShipmentDAOImpl.DAO_NAME)
public class ShipmentDAOImpl extends GenericDAOImpl<Shipment, String> implements ShipmentDAO {

	/**
	 * Declared DAO_NAME.
	 */
	public static final String DAO_NAME = "shipmentDAO";
	
	public ShipmentDAOImpl() {
		super(Shipment.class);
	}
	
	@Override
	public List<Shipment> getShipments(ShipmenForm shipmenForm){
		Query query = new Query();
		if(Format.isStringNotEmptyAndNotNull(shipmenForm.getShipmentId())){
			query.addCriteria(Criteria.where("shipmentId").is(shipmenForm.getShipmentId()));
		}
		return mongoTemplate.find(query, getPersistentClass());
	}
}
