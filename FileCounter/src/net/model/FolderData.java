package net.model;

public class FolderData {
	private String fullPath;
	private long fileCount;
	private String pathDescription; 
	
	public FolderData() {
		super();
	}
	
	public FolderData(String fullPath, long fileCount, String pathDescription) {
		super();
		this.fullPath = fullPath;
		this.fileCount = fileCount;
		this.pathDescription = pathDescription;
	}
	
	public String getFullPath() {
		return fullPath;
	} 
	public void setFullPath(String fullPath) {
		this.fullPath = fullPath;
	}
	public long getFileCount() {
		return fileCount;
	}
	public void setFileCount(long fileCount) {
		this.fileCount = fileCount;
	}
	public String getPathDescription() {
		return pathDescription;
	}
	public void setPathDescription(String pathDescription) {
		this.pathDescription = pathDescription;
	}

	@Override
	public String toString() {
		return String.format("Full path :: %s; Files count :: %s; Path Description :: %s;%n",
				getFullPath(),
				getFileCount(), 
				getPathDescription());
	}
}