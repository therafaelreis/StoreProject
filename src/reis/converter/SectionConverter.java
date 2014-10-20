package reis.converter;

import java.io.Serializable;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import reis.beans.Section;
import reis.jpa.EntityManagerUtil;

@FacesConverter(value="sectionConverter", forClass=Section.class)
public class SectionConverter implements Converter, Serializable {

	@Override
    public Object getAsObject(FacesContext context, UIComponent component,
            String str) {
		if(str == null || str.equals("Select a Section")){
			return null;
		}
		return EntityManagerUtil.getEntityManager().find(Section.class, Long.parseLong(str));
    }
 
    @Override
    public String getAsString(FacesContext context, UIComponent component,
            Object obj) {
    	if(obj == null){
			return null;
		}
		Section o = (Section) obj;
		return o.getId().toString();
    }
}
