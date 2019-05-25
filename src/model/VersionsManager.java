package model;

public class VersionsManager {
	private boolean enabled;
	private VersionsStrategy versionStrategy;
	
	public VersionsManager(boolean enabled, VersionsStrategy versionStrategy) {
		super();
		this.enabled = enabled;
		this.versionStrategy = versionStrategy;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void enable() {
		this.enabled = true;
	}

	public void disable() {
		this.enabled = false;
	}
	
	public VersionsStrategy getVersionsStrategy() {
		return versionStrategy;
	}

	public void setVersionsStrategy(VersionsStrategy versionStrategy) {
		this.versionStrategy = versionStrategy;
	}
	public void setCurrentVersion(Document currentDoc) {
			versionStrategy.putVersion(currentDoc);
	}
	
	public String getPreviousVersion() {
		return versionStrategy.getVersion();
		 
	}
	
	public void rollbackToPreviousVersion(Document currentDoc) {
		if (this.versionStrategy.getEntireHistory().size() > 0) {
			currentDoc.setContents(this.getPreviousVersion());
		}else {
			System.out.println("There isn't another previous version, you can't rollback!");
		}
	}
	
	
	
}
