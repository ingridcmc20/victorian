package com.victorian.produccion.converter;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import com.victorian.produccion.domain.Usuario;
import com.victorian.produccion.services.UsuarioServices;

@FacesConverter("usuarioConverter")
public class UsuarioConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
		if (value != null && value.trim().length() > 0) {
			try {
				UsuarioServices service = (UsuarioServices) fc.getExternalContext().getApplicationMap()
						.get("usuarioServices");
				return service.getUsuario_byIdUsuario(Integer.parseInt(value));
			} catch (NumberFormatException e) {
				throw new ConverterException(
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid theme."));
			}
		} else {
			return null;
		}
	}

	@Override
	public String getAsString(FacesContext fc, UIComponent uic, Object object) {
		if (object != null) {
			 return String.valueOf(((Usuario) object).getId_usuario());
		} else {
			return null;
		}
	}

}
