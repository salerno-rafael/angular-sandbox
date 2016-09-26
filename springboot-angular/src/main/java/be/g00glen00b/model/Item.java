package be.g00glen00b.model;

public class Item {
	private Integer id;
	private boolean checked;
	private String description;

	public Item(){
		
	}
	
	public Item(Integer id, boolean checked, String description) {
		this.id = id;
		this.checked = checked;
		this.description = description;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
