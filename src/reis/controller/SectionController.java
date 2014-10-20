package reis.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import reis.beans.Section;
import reis.model.SectionDAO;

@ManagedBean(name="sectionController")
@SessionScoped
public class SectionController implements Serializable{
	
	private SectionDAO dao;
	private List<Section> sections;
	private Section section;
	
	public SectionController(){
		dao = new SectionDAO();
		section = new Section();
	}
	
	public String list(){
		return "/admin/section/list?faces-redirect=true";
	}

	public void listAll(){
		this.sections = dao.listAll();
	}
	
	public void gravar(){
		this.dao.gravar(this.section);
		section = new Section();
	}

	public List<Section> getSections() {
		return sections;
	}

	public void setSections(List<Section> sections) {
		this.sections = sections;
	}

	public SectionDAO getDao() {
		return dao;
	}

	public void setDao(SectionDAO dao) {
		this.dao = dao;
	}

	public Section getSection() {
		return section;
	}

	public void setSection(Section section) {
		this.section = section;
	}
	
}
