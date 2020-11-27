package dto;

public class PageDTO {
	
	private int page;
	private int maxPage;
	private int startPage;
	private int endPage;
	
	
	public int getPage() {
		return page;
	}
	public int getMaxPage() {
		return maxPage;
	}
	public int getStartPage() {
		return startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
}
