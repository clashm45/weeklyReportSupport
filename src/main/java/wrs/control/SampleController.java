package wrs.control;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ValueChangeEvent;

import wrs.model.Sample;

@ViewScoped
@ManagedBean
public class SampleController {

	private boolean bool;
	private String str;
	private String next;
	private String console;
	
	private List<Sample> temples = new ArrayList<>();
	
	@PostConstruct
	public void init() {
		this.temples.add(new Sample("one"));
		this.temples.add(new Sample("two"));
		this.temples.add(new Sample("three"));
	}
	
	public void changeBool() {
		System.out.println("bool = "+bool);
		System.out.println("str  = "+str);
	}
	
	public void submit() {
		System.out.println("bool = "+bool);
		System.out.println("str  = "+str);
	}
	
//	public void oneMenu(ValueChangeEvent event) {
//		System.out.println(event.getOldValue() + " to " + event.getNewValue());
//	}

	public void oneMenu() {
		this.temples.stream()
		.filter(tmp -> tmp.getConsole() != null)
		.filter(tmp -> !tmp.getConsole().equals(tmp.getOldName()))
		.forEach(tmp ->{
			System.out.println("onChange!! value="+tmp.getConsole());
			String c = tmp.getConsole().split(",")[0];
			String r = tmp.getConsole().split(",")[1];
			tmp.setOldName(tmp.getName());//old
			tmp.setName(c+" is "+r);
		});
	}
	
	public boolean isBool() {
		return bool;
	}

	public void setBool(boolean bool) {
		this.bool = bool;
	}

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}

	public String getNext() {
		return next;
	}

	public void setNext(String next) {
		this.next = next;
	}

	public String getConsole() {
		return console;
	}

	public void setConsole(String console) {
		this.console = console;
	}

	public List<Sample> getTemples() {
		return temples;
	}

	public void setTemples(List<Sample> temples) {
		this.temples = temples;
	}

	
	
}
