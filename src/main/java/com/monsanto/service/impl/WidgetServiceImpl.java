package com.monsanto.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.monsanto.dao.WidgetDAO;
import com.monsanto.dto.WidgetDTO;
import com.monsanto.exception.NoRecordsFoundException;
import com.monsanto.form.WidgetForm;
import com.monsanto.model.Widget;
import com.monsanto.service.WidgetService;
import com.monsanto.util.Format;

@Service(WidgetServiceImpl.SERVICE_NAME)
public class WidgetServiceImpl extends GenericServiceImpl<Widget, String> implements WidgetService {

	/**
	 * Declared Service name.
	 */
	public static final String SERVICE_NAME = "widgetService";
	
	@Autowired
	private WidgetDAO widgetDAO;
	
	@Override
	public void addWidget(WidgetForm widgetForm){
		Widget widget = null;
		if(Format.isStringNotEmptyAndNotNull(widgetForm.getWidgetId())) {
			widget = widgetDAO.findOne(widgetForm.getWidgetId());
		}else {
			widget = new Widget();
		}
		if(Format.isStringNotEmptyAndNotNull(widgetForm.getColor())) {
			widget.setColor(widgetForm.getColor());
		}
		if(Format.isIntegerNotEmtyAndNotZero(widgetForm.getSerialNumber())) {
			widget.setSerialNumber(widgetForm.getSerialNumber());
		}
		if(Format.isStringNotEmptyAndNotNull(widgetForm.getProductionDate())) {
			widget.setProductionDate(Format.parseDateFormatDDMMMYY(widgetForm.getProductionDate()));
		}
		widgetDAO.save(widget);
	}

	@Override
	public WidgetForm getWidget(WidgetForm widgetForm) throws NoRecordsFoundException {
		Widget widget = widgetDAO.findOne(widgetForm.getWidgetId());
		if(Format.isObjectNotEmptyAndNotZero(widget)) {
			if(Format.isStringNotEmptyAndNotNull(widget.getColor())) {
				widgetForm.setColor(widget.getColor());
			}
			if(Format.isIntegerNotEmtyAndNotZero(widget.getSerialNumber())) {
				widgetForm.setSerialNumber(widget.getSerialNumber());
			}
			if(widget.getProductionDate()!=null) {
				widgetForm.setProductionDate(Format.parseDateFormatDDMMMYY(widget.getProductionDate()));
			}
		}else {
			throw new NoRecordsFoundException();
		}
		return widgetForm;
	}
	
	@Override
	public List<Widget> getWidgets(WidgetForm widgetForm){
		List<Widget> recipes = widgetDAO.findAll();
		if(!Format.isCollectionNotEmtyAndNotNull(recipes)) {
			recipes = new ArrayList<>();
		}
		return recipes;
	}
	
	@Override
	public void updateWidget(WidgetForm widgetForm) throws NoRecordsFoundException	{
		Widget widget = widgetDAO.findOne(widgetForm.getWidgetId());
		if(Format.isObjectNotEmptyAndNotZero(widget)) {
			if(Format.isStringNotEmptyAndNotNull(widgetForm.getColor())) {
				widget.setColor(widgetForm.getColor());
			}
			if(Format.isIntegerNotEmtyAndNotZero(widgetForm.getSerialNumber())) {
				widget.setSerialNumber(widgetForm.getSerialNumber());
			}
			if(Format.isStringNotEmptyAndNotNull(widgetForm.getProductionDate())) {
				widget.setProductionDate(Format.parseDateFormatDDMMMYY(widgetForm.getProductionDate()));
			}
			widgetDAO.save(widget);
		}else {
			throw new NoRecordsFoundException();
		}
	}
	
	@Override
	public void deleteWidget(WidgetForm widgetForm) throws NoRecordsFoundException{
		Widget widget = widgetDAO.findOne(widgetForm.getWidgetId());
		if(Format.isObjectNotEmptyAndNotZero(widget)) {
			widgetDAO.delete(widget);
		}else {
			throw new NoRecordsFoundException();
		}
	}
	
	@Override
	public void deleteAllWidget(WidgetForm widgetForm) throws NoRecordsFoundException{
		List<Widget> widgets = widgetDAO.findAll();
		if(Format.isCollectionNotEmtyAndNotNull(widgets)) {
			for(Widget widget:widgets) {
				widgetDAO.delete(widget);
			}
		}else {
			throw new NoRecordsFoundException();
		}
	}
	
	@Override
	public List<WidgetDTO> getWidgetDTOs(WidgetForm widgetForm){
		List<WidgetDTO> widgetDTOs = new ArrayList<>();
		List<Widget> widgets = widgetDAO.getWidgets(widgetForm);
		if(Format.isCollectionNotEmtyAndNotNull(widgets)) {
			for(Widget widget:widgets) {
				WidgetDTO widgetDTO = new WidgetDTO();
				if(widget.getWidgetId()!=null) {
					widgetDTO.setWidgetId(widget.getWidgetId().toString());
				}
				if(Format.isStringNotEmptyAndNotNull(widget.getColor())) {
					widgetDTO.setColor(widget.getColor());
				}
				if(Format.isIntegerNotEmtyAndNotZero(widget.getSerialNumber())) {
					widgetDTO.setSerialNumber(widget.getSerialNumber());
				}
				if(widget.getProductionDate()!=null) {
					widgetDTO.setProductionDate(Format.parseDateFormatDDMMMYY(widget.getProductionDate()));
				}
				widgetDTOs.add(widgetDTO);
			}
		}
		return widgetDTOs;
	}
}
