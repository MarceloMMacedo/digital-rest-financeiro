package br.com.apifinanceiro.converters;


import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import br.com.apidigitalfinanceiro.enums.TipoMovimentoEnum;

@Converter
public class TipoMovimentoConverter implements
AttributeConverter<String, Integer>{

	@Override
	public Integer convertToDatabaseColumn(String attribute) { 
		return TipoMovimentoEnum.findById(attribute);
	}

	@Override
	public String convertToEntityAttribute(Integer dbData) { 
		return  TipoMovimentoEnum.getById(dbData);
	}

	 
}
