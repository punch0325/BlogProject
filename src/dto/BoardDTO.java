package dto;

import java.sql.Date;

public class BoardDTO {
	private int bnumber;
	private String bwriter;
	private String btitle;
	private String bcontents;
	private Date bdate;
	private int bhits;
	private String bfile;
	private String bcategory;
	
	
	public BoardDTO() {
		super();
	}
	public BoardDTO(int bnumber, String bwriter, String btitle, String bcontents, Date bdate, int bhits, String bfile,
			String bcategory) {
		super();
		this.bnumber = bnumber;
		this.bwriter = bwriter;
		this.btitle = btitle;
		this.bcontents = bcontents;
		this.bdate = bdate;
		this.bhits = bhits;
		this.bfile = bfile;
		this.bcategory = bcategory;
	}
	
	
	public int getBnumber() {
		return bnumber;
	}
	public String getBwriter() {
		return bwriter;
	}
	public String getBtitle() {
		return btitle;
	}
	public String getBcontents() {
		return bcontents;
	}
	public Date getBdate() {
		return bdate;
	}
	public int getBhits() {
		return bhits;
	}
	public String getBfile() {
		return bfile;
	}
	public String getBcategory() {
		return bcategory;
	}
	public void setBnumber(int bnumber) {
		this.bnumber = bnumber;
	}
	public void setBwriter(String bwriter) {
		this.bwriter = bwriter;
	}
	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}
	public void setBcontents(String bcontents) {
		this.bcontents = bcontents;
	}
	public void setBdate(Date bdate) {
		this.bdate = bdate;
	}
	public void setBhits(int bhits) {
		this.bhits = bhits;
	}
	public void setBfile(String bfile) {
		this.bfile = bfile;
	}
	public void setBcategory(String bcategory) {
		this.bcategory = bcategory;
	}
	
	
	@Override
	public String toString() {
		return "BoardDTO [bnumber=" + bnumber + ", bwriter=" + bwriter + ", btitle=" + btitle + ", bcontents="
				+ bcontents + ", bdate=" + bdate + ", bhits=" + bhits + ", bfile=" + bfile + ", bcategory=" + bcategory
				+ "]";
	}
	
	
}
