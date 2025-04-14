package thiGK.ntu64130005.HoangDuyAn_ThiGK.model;

public class Page {
	public String pageName, keyword, content;
	public int id, parentPageId;
	
	public Page(int id, String pageName, String keyword, String content, int parentPageId) {
		this.id = id;
		this.pageName = pageName;
		this.keyword = keyword;
		this.content = content;
		this.parentPageId = parentPageId;
	}
}
