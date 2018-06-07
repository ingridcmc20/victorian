package com.victorian.produccion.converter;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import com.victorian.produccion.domain.Maquinaria;
import com.victorian.produccion.services.MaquinariaServices;

@FacesConverter("maquinariaConverter")
public class MaquinariaConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
		if (value != null && value.trim().length() > 0) {
			try {
				MaquinariaServices service = (MaquinariaServices) fc.getExternalContext().getApplicationMap()
						.get("maquinariaServices");
				return service.findById(Integer.parseInt(value));
			} catch (Exception e) {
				throw new ConverterException(
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Maquinaria no valida."));
			}
		} else {
			return null;
		}
	}

	@Override
	public String getAsString(FacesContext fc, UIComponent uic, Object object) {
		if (object != null) {
			 return String.valueOf(((Maquinaria) object).getIdmaquinaria());
		} else {
			return null;
		}
	}

}
