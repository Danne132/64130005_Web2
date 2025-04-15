package thiGK.ntu64130005.HoangDuyAn_ThiGKDe2.model;

public class Student {
	private String id, name, groupId;

	public Student(String id, String name, String groupId) {
		super();
		this.id = id;
		this.name = name;
		this.groupId = groupId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
	
	
}
