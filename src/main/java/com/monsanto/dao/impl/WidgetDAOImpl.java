package com.monsanto.dao.impl;

import java.util.List;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.monsanto.dao.WidgetDAO;
import com.monsanto.form.WidgetForm;
import com.monsanto.model.Widget;
import com.monsanto.util.Format;

@Repository(WidgetDAOImpl.DAO_NAME)
public class WidgetDAOImpl extends GenericDAOImpl<Widget, String> implements WidgetDAO {

	/**
	 * Declared DAO_NAME.
	 */
	public static final String DAO_NAME = "widgetDAO";
	
	public WidgetDAOImpl() {
		super(Widget.class);
	}
	
	@Override
	public List<Widget> getWidgets(WidgetForm widgetForm){
		Query query = new Query();
		if(Format.isStringNotEmptyAndNotNull(widgetForm.getColor())){
			query.addCriteria(Criteria.where("color").is(widgetForm.getColor()));
		}
		if(Format.isIntegerNotEmtyAndNotZero(widgetForm.getSerialNumber())){
			query.addCriteria(Criteria.where("serialNumber").is(widgetForm.getSerialNumber()));
		}
		return mongoTemplate.find(query, getPersistentClass());
	}
}
