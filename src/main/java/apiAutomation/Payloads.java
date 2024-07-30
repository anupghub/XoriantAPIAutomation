package apiAutomation;

public class Payloads {

	public Payloads(String description, String summary, IssueTypes issues,Projects project) {
		
		this.description=description;
		this.summary=summary;
		this.issues=issues;
		this.project=project;
	}
	
	private String summary;
	IssueTypes issues;
	Projects project;
	private String description;
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public IssueTypes getIssues() {
		return issues;
	}
	public void setIssues(IssueTypes issues) {
		this.issues = issues;
	}
	public Projects getProject() {
		return project;
	}
	public void setProject(Projects project) {
		this.project = project;
	}
	
}