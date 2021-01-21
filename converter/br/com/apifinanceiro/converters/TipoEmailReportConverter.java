package br.com.apifinanceiro.converters;


import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import br.com.apidigitalfinanceiro.enums.TipoEmailReportEnum;

@Converter
public class TipoEmailReportConverter implements
AttributeConverter<String, Integer>{

	@Override
	public Integer convertToDatabaseColumn(String attribute) { 
		return TipoEmailReportEnum.findById(attribute);
	}

	@Override
	public String convertToEntityAttribute(Integer dbData) { 
		return  TipoEmailReportEnum.getById(dbData);
	}

	 
}
