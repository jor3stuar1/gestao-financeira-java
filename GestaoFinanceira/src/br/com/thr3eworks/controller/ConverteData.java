package br.com.thr3eworks.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.component.EditableValueHolder;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
  
@FacesConverter("converteData")  
public class ConverteData implements Converter {  
  
    SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");  
      
    @Override  
    public Object getAsObject(FacesContext facesContext, UIComponent component, String arg2) {  
    	    df.setLenient(false);  
        try {  
              
            return df.parse(arg2);              
              
        } catch (Exception e) {  
        	cleanSubmittedValues(component);
        	e.printStackTrace();
            throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao converter a DATA", "Data Inválida!"));   
        }  
    }  
  
    @Override  
    public String getAsString(FacesContext facesContext, UIComponent component, Object arg2) {  
        try {  
        	
        	df.setLenient(false);  
            String d = df.format((Date) arg2);  
         
            return d;  
        } catch (Exception e) { 
        	cleanSubmittedValues(component);
        	e.printStackTrace();
       		return "";
        	  
        }  
  
    }  

	public void cleanSubmittedValues(UIComponent component) {
		if (component instanceof EditableValueHolder) {
			EditableValueHolder evh = (EditableValueHolder) component;
			evh.setSubmittedValue(null);
			evh.setValue(null);
			evh.setLocalValueSet(false);
			evh.setValid(true);
		}
		if (component.getChildCount() > 0) {
			for (UIComponent child : component.getChildren()) {
				cleanSubmittedValues(child);
			}
		}
	}


}  