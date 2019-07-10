
public class Task {
	private String description = null;
	private boolean isComplete = false;
	// priority from 0-2
	private int priority = 0;
	private Category category = null;

	public String getCategory() {
		if (this.category != null) {
			return category.getCatName();
		} else
			return "";
	}

	public void setCategory(String catName) {
		this.category = new Category(catName);
	}

	public Task(String description) {
		super();
		this.description = description;
	}

	public Task(String description, boolean isComplete) {
		super();
		this.description = description;
		this.isComplete = isComplete;
	}

	public Task(String description, boolean isComplete, int priority) {
		super();
		this.description = description;
		this.isComplete = isComplete;
		this.priority = priority;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isComplete() {
		return isComplete;
	}

	public void setComplete(boolean isComplete) {
		this.isComplete = isComplete;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public int getPriority() {
		return this.priority;
	}

}
