package Model;

public class NavDrawerItem {
	private String title;
	private int icon;
	private boolean isCounterVisible = false;

	
	
	public NavDrawerItem(String title, int icon) {
		this.title = title;
		this.icon = icon;
	}
	public NavDrawerItem(String title, int icon, boolean isCounterVisible) {
		this.title = title;
		this.icon = icon;
		this.isCounterVisible = isCounterVisible;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getIcon() {
		return icon;
	}

	public void setIcon(int icon) {
		this.icon = icon;
	}

	public boolean isCounterVisible() {
		return isCounterVisible;
	}

	public void setCounterVisible(boolean isCounterVisible) {
		this.isCounterVisible = isCounterVisible;
	}

}
