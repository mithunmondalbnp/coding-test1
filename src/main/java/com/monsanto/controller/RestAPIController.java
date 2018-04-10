package com.monsanto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.monsanto.constants.Constant;
import com.monsanto.exception.NoRecordsFoundException;
import com.monsanto.form.WidgetForm;
import com.monsanto.model.Widget;
import com.monsanto.service.WidgetService;
import com.monsanto.util.Format;

@Controller
public class RestAPIController {

	@Autowired
	private WidgetService widgetService;
	
	//-------------------Create a Widget--------------------------------------------------------
	@RequestMapping(value = "/widget", method = RequestMethod.POST)
    public @ResponseBody WidgetForm addWidget(@RequestBody WidgetForm widgetForm) {
		widgetService.addWidget(widgetForm);
		widgetForm.setSuccessOrErrorMessage(Constant.WIDGET_ADDED_SUCCESSFULLY);
    	widgetForm.setMessageType(Constant.MESSAGE_TYPE_SUCCESS);
        return widgetForm;
    }
	
	//-------------------Retrieve Single Widget--------------------------------------------------------
    @RequestMapping(value = "/widget/{id}", method = RequestMethod.GET)
    public @ResponseBody WidgetForm getWidget(@PathVariable("id") String id) {
    	WidgetForm widgetForm = new WidgetForm();
        if(Format.isStringNotEmptyAndNotNull(id)) {
        	widgetForm.setWidgetId(id);
        	try {
        		widgetService.getWidget(widgetForm);
        		widgetForm.setMessageType(Constant.MESSAGE_TYPE_SUCCESS);
        	}catch (NoRecordsFoundException e) {
        		widgetForm.setSuccessOrErrorMessage(Constant.NO_RECORD_FOUND);
        		widgetForm.setMessageType(Constant.MESSAGE_TYPE_FAILURE);
			}
        }
        return widgetForm;
    }
    
   //-------------------Retrieve All Widgets--------------------------------------------------------
    @RequestMapping(value = "/widget", method = RequestMethod.GET)
    public @ResponseBody WidgetForm listAllWidgets() {
       WidgetForm widgetForm = new WidgetForm();
       List<Widget> widgets = widgetService.getWidgets(widgetForm);
       widgetForm.setMessageType(Constant.MESSAGE_TYPE_SUCCESS);
	   widgetForm.setWidgets(widgets);
       return widgetForm;
    }
    
    //------------------- Update a Widget --------------------------------------------------------
    @RequestMapping(value = "/widget/{id}", method = RequestMethod.PUT)
    public @ResponseBody WidgetForm updateWidget(@PathVariable("id") String id, @RequestBody WidgetForm widgetForm) {
    	widgetForm.setWidgetId(id);
        try {
        	widgetService.updateWidget(widgetForm);
        	widgetForm.setSuccessOrErrorMessage(Constant.WIDGET_UPDATED_SUCCESSFULLY);
        	widgetForm.setMessageType(Constant.MESSAGE_TYPE_SUCCESS);
        }catch (NoRecordsFoundException e) {
        	widgetForm.setSuccessOrErrorMessage(Constant.NO_RECORD_FOUND);
        	widgetForm.setMessageType(Constant.MESSAGE_TYPE_FAILURE);
        }
        return widgetForm;
    }
 
    //------------------- Delete a Widget --------------------------------------------------------
    @RequestMapping(value = "/widget/{id}", method = RequestMethod.DELETE)
    public @ResponseBody WidgetForm deleteWidget(@PathVariable("id") String id) {
    	WidgetForm widgetForm = new WidgetForm();
    	widgetForm.setWidgetId(id);
        try {
        	widgetService.deleteWidget(widgetForm);
        	widgetForm.setSuccessOrErrorMessage(Constant.WIDGET_DELETED_SUCCESSFULLY);
        	widgetForm.setMessageType(Constant.MESSAGE_TYPE_SUCCESS);
        }catch (NoRecordsFoundException e) {
        	widgetForm.setSuccessOrErrorMessage(Constant.NO_RECORD_FOUND);
        	widgetForm.setMessageType(Constant.MESSAGE_TYPE_FAILURE);
        }
        return widgetForm;
    }
    
    //------------------- Delete All Widgets --------------------------------------------------------
    @RequestMapping(value = "/widget", method = RequestMethod.DELETE)
    public @ResponseBody WidgetForm deleteAllWidgets() {
    	WidgetForm widgetForm = new WidgetForm();
        try {
           widgetService.deleteAllWidget(widgetForm);
           widgetForm.setSuccessOrErrorMessage(Constant.WIDGET_DELETED_ALL_SUCCESSFULLY);
     	   widgetForm.setMessageType(Constant.MESSAGE_TYPE_SUCCESS);
        }catch (NoRecordsFoundException e) {
        	widgetForm.setSuccessOrErrorMessage(Constant.NO_RECORD_FOUND);
        	widgetForm.setMessageType(Constant.MESSAGE_TYPE_FAILURE);
        }
        return widgetForm;
    }
}
