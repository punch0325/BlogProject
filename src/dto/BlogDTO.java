package dto;

public class BlogDTO {
	
	private int blognum;
	private String blogid;
	private String blogname;
	private int bloghits;
	private String blogimage;
	
	
	public BlogDTO() {
		super();
	}
	public BlogDTO(int blognum, String blogid, String blogname, int bloghits, String blogimage) {
		super();
		this.blognum = blognum;
		this.blogid = blogid;
		this.blogname = blogname;
		this.bloghits = bloghits;
		this.blogimage = blogimage;
	}
	
	
	public int getBlognum() {
		return blognum;
	}
	public String getBlogid() {
		return blogid;
	}
	public String getBlogname() {
		return blogname;
	}
	public int getBloghits() {
		return bloghits;
	}
	public String getBlogimage() {
		return blogimage;
	}
	public void setBlognum(int blognum) {
		this.blognum = blognum;
	}
	public void setBlogid(String blogid) {
		this.blogid = blogid;
	}
	public void setBlogname(String blogname) {
		this.blogname = blogname;
	}
	public void setBloghits(int bloghits) {
		this.bloghits = bloghits;
	}
	public void setBlogimage(String blogimage) {
		this.blogimage = blogimage;
	}


	@Override
	public String toString() {
		return "BlogDTO [blognum=" + blognum + ", blogid=" + blogid + ", blogname=" + blogname + ", bloghits="
				+ bloghits + ", blogimage=" + blogimage + "]";
	}
	
	
	
}
