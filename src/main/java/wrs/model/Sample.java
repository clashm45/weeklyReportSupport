package wrs.model;

public class Sample {

	private String name;
	private String oldName;
	private String console;
	
	
	public Sample(String name) {
		super();
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public String getOldName() {
		return oldName;
	}
	public void setOldName(String oldName) {
		this.oldName = oldName;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getConsole() {
		return console;
	}
	public void setConsole(String console) {
		this.console = console;
	}
	
	
}
