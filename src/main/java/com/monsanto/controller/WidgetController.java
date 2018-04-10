package com.monsanto.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.monsanto.dto.DatatableJsonResponse;
import com.monsanto.dto.WidgetDTO;
import com.monsanto.form.WidgetForm;
import com.monsanto.service.WidgetService;
import com.monsanto.util.Format;

@Controller
public class WidgetController {

	@Autowired
	private WidgetService widgetService;
	
	/**
	 * @param model
	 * @return the index/home page for the Monsanto Front end Web Application
	 */
	@RequestMapping(value = { "/", "/home", "/index" })
	public String indexPage(Model model) {
		return "index";
	}
	
	/**
	 * This method will get the list of widgets.
	 * @return DatatableJsonResponse
	 */
	@RequestMapping("/getWidgetList")
	public @ResponseBody DatatableJsonResponse getWidgetList(WidgetForm widgetForm) {
		DatatableJsonResponse datatableJsonResponse = new DatatableJsonResponse();
		List<WidgetDTO> widgetDTOs = widgetService.getWidgetDTOs(widgetForm);
		if(!Format.isCollectionNotEmtyAndNotNull(widgetDTOs)) {
			widgetDTOs = new ArrayList<>();
		}
		datatableJsonResponse.setData(widgetDTOs);
		//this count is required for DataTable  to check  pagination (what is the total no of records selected  and how many  records to display in a page ) 
		datatableJsonResponse.setRecordsFiltered(widgetDTOs.size());
		datatableJsonResponse.setRecordsTotal(widgetDTOs.size());
		return datatableJsonResponse;
	}
}
