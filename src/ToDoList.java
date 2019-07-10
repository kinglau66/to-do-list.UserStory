import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collection;

public class ToDoList {

	private HashMap<String, Task> tasks = new HashMap<String, Task>();

	public void addTask(Task task) {
		tasks.put(task.getDescription(), task);
	}

	public void completeTask(String description) {
		Task task = null;
		if ((task = tasks.get(description)) != null) {
			task.setComplete(true);
		}
		;
	}
	public void setPriorityTask(String description, int priority) {
		Task task = null;
		if ((task = tasks.get(description)) != null) {
			task.setPriority(priority);
		}
		;
	}

	public boolean getStatus(String description) {
		Task task = null;
		if ((task = tasks.get(description)) != null) {
			return task.isComplete();
		}
		;
		return false;
	}

//	-1 return if cnt find
	public int getPriority(String description) {
		Task task = null;
		if ((task = tasks.get(description)) != null) {
			return task.getPriority();
		}
		;
		return -1;
	}

	public Task getTask(String description) {
		return tasks.get(description);
	}

	public Task removeTask(String description) {
		Task ret = 
		 tasks.remove(description);
		if(ret != null)
		System.out.print("Removed : (" + ret.print() + ")\n");
		else
		System.out.print("Removed : None(!)\n");
		return ret;
	}

	public Collection<Task> getAllTasks() {
		
		System.out.print("/// " + "TaskList of size " + String.format("%03d", tasks.size()) +  " ///\n"); 
		for (Task i : tasks.values()) {
			//ret.add(i);
			System.out.print(i.print());
		  }
		System.out.print("/// " + "_____________________" + " ///\n"); 
		return tasks.values();
	}

	public Collection<Task> getCompletedTasks() {
		Collection<Task> completedTasks = new ArrayList<Task>();
		Collection<Task> allTasks = new ArrayList<Task>();
		allTasks = getAllTasks();
		for (Task task : allTasks)
			if (task.isComplete() == true){
				System.out.print(task.print());
				completedTasks.add(task);
			}
		return completedTasks;
	}

	public Collection<Task> getPriorityTask(int priority) {
		Collection<Task> completedTasks = new ArrayList<Task>();
		Collection<Task> allTasks = new ArrayList<Task>();
		allTasks = getAllTasks();
		for (Task task : allTasks)
			if (task.getPriority() == priority){
				//System.out.print(task.print());
				completedTasks.add(task);
			}
				
		return completedTasks;
	}
	
	public Collection<Task> getCategory(String categoryName) {
		Collection<Task> catTasks = new ArrayList<Task>();
		Collection<Task> allTasks = new ArrayList<Task>();
		allTasks = getAllTasks();
		for (Task task : allTasks)
			if (task.getCategory().equals(categoryName)){
				catTasks.add(task);
				//System.out.print(task.print());
			}
		return catTasks;
	}

}
