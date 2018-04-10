package com.monsanto.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.monsanto.constants.Constant;
import com.monsanto.dto.DatatableJsonResponse;
import com.monsanto.dto.ShipmentDTO;
import com.monsanto.exception.InvalidWidgetCountException;
import com.monsanto.form.ShipmenForm;
import com.monsanto.service.ShipmentService;
import com.monsanto.util.Format;

@Controller
public class ShipmentController {

	@Autowired
	private ShipmentService shipmentService;
	
	/**
	 * This method will get the list of shipments.
	 * @return DatatableJsonResponse
	 */
	@RequestMapping("/getShipmentList")
	public @ResponseBody DatatableJsonResponse getShipmentList(ShipmenForm shipmenForm) {
		DatatableJsonResponse datatableJsonResponse = new DatatableJsonResponse();
		List<ShipmentDTO> shipmentDTOs = shipmentService.getShipmentList(shipmenForm);
		if(!Format.isCollectionNotEmtyAndNotNull(shipmentDTOs)) {
			shipmentDTOs = new ArrayList<>();
		}
		datatableJsonResponse.setData(shipmentDTOs);
		//this count is required for DataTable  to check  pagination (what is the total no of records selected  and how many  records to display in a page ) 
		datatableJsonResponse.setRecordsFiltered(shipmentDTOs.size());
		datatableJsonResponse.setRecordsTotal(shipmentDTOs.size());
		return datatableJsonResponse;
	}
	
	@RequestMapping(value = "/shipment", method = RequestMethod.POST)
    public @ResponseBody ShipmenForm addShipment(@RequestBody ShipmenForm shipmenForm) {
		try {
    		shipmentService.addShipment(shipmenForm);
    		shipmenForm.setSuccessOrErrorMessage(Constant.SHIPMENT_ADDED_SUCCESSFULLY);
    		shipmenForm.setMessageType(Constant.MESSAGE_TYPE_SUCCESS);
    	}catch (InvalidWidgetCountException e) {
    		shipmenForm.setSuccessOrErrorMessage(Constant.INVALID_WIDGET_COUNT);
    		shipmenForm.setMessageType(Constant.MESSAGE_TYPE_FAILURE);
		}
        return shipmenForm;
    }
}
