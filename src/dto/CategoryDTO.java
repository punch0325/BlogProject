package dto;

public class CategoryDTO {
	
	private int cnumber;
	private String cwriter;
	private String cname;
	
	
	public CategoryDTO() {
		super();
	}
	public CategoryDTO(int cnumber, String cwriter, String cname) {
		super();
		this.cnumber = cnumber;
		this.cwriter = cwriter;
		this.cname = cname;
	}
	
	
	public int getCnumber() {
		return cnumber;
	}
	public String getCwriter() {
		return cwriter;
	}
	public String getCname() {
		return cname;
	}
	public void setCnumber(int cnumber) {
		this.cnumber = cnumber;
	}
	public void setCwriter(String cwriter) {
		this.cwriter = cwriter;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	
	
	@Override
	public String toString() {
		return "CategoryDTO [cnumber=" + cnumber + ", cwriter=" + cwriter + ", cname=" + cname + "]";
	}
	
	
}
