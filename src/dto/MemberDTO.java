package dto;

public class MemberDTO {
	private String mid;
	private String mpw;
	private String mname;
	private String mbirth;
	private String mphone;
	private String memail;
	private String maddress;
	private String mprofile;
	
	
	public MemberDTO() {
		super();
	}
	public MemberDTO(String mid, String mpw, String mname, String mbirth, String mphone, String memail, String maddress,
			String mprofile) {
		super();
		this.mid = mid;
		this.mpw = mpw;
		this.mname = mname;
		this.mbirth = mbirth;
		this.mphone = mphone;
		this.memail = memail;
		this.maddress = maddress;
		this.mprofile = mprofile;
	}
	
	
	public String getMid() {
		return mid;
	}
	public String getMpw() {
		return mpw;
	}
	public String getMname() {
		return mname;
	}
	public String getMbirth() {
		return mbirth;
	}
	public String getMphone() {
		return mphone;
	}
	public String getMemail() {
		return memail;
	}
	public String getMaddress() {
		return maddress;
	}
	public String getMprofile() {
		return mprofile;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public void setMpw(String mpw) {
		this.mpw = mpw;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public void setMbirth(String mbirth) {
		this.mbirth = mbirth;
	}
	public void setMphone(String mphone) {
		this.mphone = mphone;
	}
	public void setMemail(String memail) {
		this.memail = memail;
	}
	public void setMaddress(String maddress) {
		this.maddress = maddress;
	}
	public void setMprofile(String mprofile) {
		this.mprofile = mprofile;
	}
	
	
	@Override
	public String toString() {
		return "MemberDTO [mid=" + mid + ", mpw=" + mpw + ", mname=" + mname + ", mbirth=" + mbirth + ", mphone="
				+ mphone + ", memail=" + memail + ", maddress=" + maddress + ", mprofile=" + mprofile + "]";
	}
	
	
	
	
}
