package com.victorian.produccion.converter;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import com.victorian.produccion.domain.Operario;
import com.victorian.produccion.services.OperarioServices;

@FacesConverter("operarioConverter")
public class OperarioConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
		if (value != null && value.trim().length() > 0) {
			try {
				OperarioServices service = new OperarioServices();
				Operario operario = service.findById(Integer.parseInt(value));
				return operario;
			} catch (Exception e) {
				throw new ConverterException(
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Operario no valido."));
			}
		} else {
			return null;
		}
	}

	@Override
	public String getAsString(FacesContext fc, UIComponent uic, Object object) {
		if (object != null) {
			 return String.valueOf(((Operario) object).getIdoperario());
		} else {
			return null;
		}
	}

}
