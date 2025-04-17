package thiGK.ntu64130005.HoangDuyAn_ThiGKDe2.model;

public class Topic {
	private String id, topicName, topicDescription, supervisorId, topicType;

	public Topic(String id, String topicName, String topicDescription, String supervisorId, String topicType) {
		this.id = id;
		this.topicName = topicName;
		this.topicDescription = topicDescription;
		this.supervisorId = supervisorId;
		this.topicType = topicType;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTopicName() {
		return topicName;
	}

	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}

	public String getTopicDescription() {
		return topicDescription;
	}

	public void setTopicDescription(String topicDescription) {
		this.topicDescription = topicDescription;
	}

	public String getSupervisorId() {
		return supervisorId;
	}

	public void setSupervisorId(String supervisorId) {
		this.supervisorId = supervisorId;
	}

	public String getTopicType() {
		return topicType;
	}

	public void setTopicType(String topicType) {
		this.topicType = topicType;
	}
	
	
}
