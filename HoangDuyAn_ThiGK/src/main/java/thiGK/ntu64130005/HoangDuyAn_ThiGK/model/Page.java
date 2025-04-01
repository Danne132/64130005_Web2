package thiGK.ntu64130005.HoangDuyAn_ThiGK.model;

import java.awt.GridLayout;

public class Page {
	public String id, pageName, keyword, content, parentPageId;
	
	public Page(String id, String pageName, String keyword, String content, String parentPageId) {
		this.id = id;
		this.pageName = pageName;
		this.keyword = keyword;
		this.content = content;
		this.parentPageId = parentPageId;
	}
}
