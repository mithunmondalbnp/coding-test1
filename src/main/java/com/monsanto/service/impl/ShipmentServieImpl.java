package com.monsanto.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.monsanto.dao.ShipmentDAO;
import com.monsanto.dao.WidgetDAO;
import com.monsanto.dto.ShipmentDTO;
import com.monsanto.exception.InvalidWidgetCountException;
import com.monsanto.form.ShipmenForm;
import com.monsanto.model.Shipment;
import com.monsanto.model.Widget;
import com.monsanto.service.ShipmentService;
import com.monsanto.util.Format;

@Service(ShipmentServieImpl.SERVICE_NAME)
public class ShipmentServieImpl extends GenericServiceImpl<Shipment, String> implements ShipmentService {

	/**
	 * Declared Service name.
	 */
	public static final String SERVICE_NAME = "shipmentService";
	
	@Autowired
	private ShipmentDAO shipmentDAO;
	
	@Autowired
	private WidgetDAO widgetDAO;
	
	@Override
	public void addShipment(ShipmenForm shipmenForm) throws InvalidWidgetCountException {
		Shipment shipment = null;
		if(Format.isStringNotEmptyAndNotNull(shipmenForm.getShipmentId())) {
			shipment = shipmentDAO.findOne(shipmenForm.getShipmentId().toString());
		}else {
			shipment = new Shipment();
			shipment.setCreatedOn(new Date());
		}
		if(shipmenForm.getShipmentName()!=null) {
			shipment.setShipmentName(shipmenForm.getShipmentName());
		}
		if(shipmenForm.getWidgets()!=null) {
			if(shipmenForm.getWidgets().size() > 10) {
				throw new InvalidWidgetCountException();
			}
			List<Widget> widgets = new ArrayList<>();
			for(String string:shipmenForm.getWidgets()) {
				Widget widget = widgetDAO.findOne(string);
				if(Format.isObjectNotEmptyAndNotZero(widget)) {
					widgets.add(widget);
				}
			}
			shipment.setWidgets(widgets);
		}
		shipmentDAO.save(shipment);
	}
	
	@Override
	public List<ShipmentDTO> getShipmentList(ShipmenForm shipmenForm){
		List<ShipmentDTO> shipmentDTOs = new ArrayList<>();
		List<Shipment> shipments = shipmentDAO.getShipments(shipmenForm);
		if(Format.isCollectionNotEmtyAndNotNull(shipments)) {
			for(Shipment shipment:shipments) {
				ShipmentDTO shipmentDTO = new ShipmentDTO();
				if(shipment.getShipmentId()!=null) {
					shipmentDTO.setShipmentId(shipment.getShipmentId().toString());
				}
				if(shipment.getShipmentName()!=null) {
					shipmentDTO.setShipmentName(shipment.getShipmentName());
				}
				if(shipment.getWidgets()!=null) {
					shipmentDTO.setWidgets(shipment.getWidgets());
				}
				shipmentDTO.setCreatedOn(Format.parseDateFormatDDMMMYYHHMMA(shipment.getCreatedOn()));
				shipmentDTOs.add(shipmentDTO);
			}
		}
		return shipmentDTOs;
	}
}
