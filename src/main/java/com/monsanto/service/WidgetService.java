package com.monsanto.service;

import java.util.List;

import com.monsanto.dto.WidgetDTO;
import com.monsanto.exception.NoRecordsFoundException;
import com.monsanto.form.WidgetForm;
import com.monsanto.model.Widget;

public interface WidgetService extends GenericService<Widget, String>{

	public void addWidget(WidgetForm widgetForm);
	
	public WidgetForm getWidget(WidgetForm widgetForm) throws NoRecordsFoundException;
	
	public List<Widget> getWidgets(WidgetForm widgetForm);
	
	public void updateWidget(WidgetForm widgetForm) throws NoRecordsFoundException;
	
	public void deleteWidget(WidgetForm widgetForm) throws NoRecordsFoundException;
	
	public void deleteAllWidget(WidgetForm widgetForm) throws NoRecordsFoundException;
	
	public List<WidgetDTO> getWidgetDTOs(WidgetForm widgetForm);
}
