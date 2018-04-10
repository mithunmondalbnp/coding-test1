package com.monsanto.dao;

import java.util.List;

import com.monsanto.form.WidgetForm;
import com.monsanto.model.Widget;

public interface WidgetDAO extends GenericDAO<Widget, String>{

	public List<Widget> getWidgets(WidgetForm widgetForm);
}
