//import static org.junit.jupiter.api.Assertions.*;

//import org.junit.jupiter.api.Test;
import java.util.Collection;

import org.junit.*;
import org.junit.Test;
import junit.framework.*;

public class ToDoListTest extends TestCase {
	private Task task1;
	private Task task2;
	private Task task3;
	private ToDoList todoList;

	public ToDoListTest() {
		super();
	}

	@Before
	public void setUp() throws Exception {
		task1 = new Task("desc 1");
		task2 = new Task("desc 2");
		task3 = new Task("desc 3");

		todoList = new ToDoList();
	}

	@After
	public void tearDown() throws Exception {
		task1 = null;
		task2 = null;
		task3 = null;

		todoList = null;
	}

	@Test
	public void testAddTask() {
		assertNotNull(todoList);
		todoList.addTask(task1);
		assertEquals(1, todoList.getAllTasks().size());
		assertEquals(task1, todoList.getTask(task1.getDescription()));
	}

	@Test
	public void testgetStatus() {
		assertNotNull(todoList);
		todoList.addTask(task1);
		assertEquals(false, todoList.getStatus(task1.getDescription()));
		todoList.completeTask(task1.getDescription());
		assertEquals(true, todoList.getStatus(task1.getDescription()));
	}

	@Test
	public void testRemoveTask() {
		assertNotNull(todoList);
		todoList.addTask(task1);
		todoList.addTask(task2);
		;

		todoList.removeTask(task1.getDescription());
		assertNull(todoList.getTask(task1.getDescription()));
	}

	@Test
	public void testGetCompletedTasks() {
		task1.setComplete(true);
		task3.setComplete(true);
		todoList.addTask(task1);
		todoList.addTask(task2);
		todoList.addTask(task3);

		Collection<Task> tasks = todoList.getCompletedTasks();
		assertEquals(2, tasks.size());
	}

	@Test
	public void testGetPriorityTasks() {
		task1.setComplete(true);
		task3.setComplete(true);
		task1.setPriority(1);
		task3.setPriority(2);
		todoList.addTask(task1);
		todoList.addTask(task2);
		todoList.addTask(task3);

		Collection<Task> tasks = todoList.getPriorityTask(1);
		assertEquals(1, tasks.size());
	}

	@Test
	public void testGetCategoryTasks() {
		task1.setComplete(true);
		task3.setComplete(true);
		task1.setCategory("shopping");
		task3.setCategory("outing");
		todoList.addTask(task1);
		todoList.addTask(task2);
		todoList.addTask(task3);

		Collection<Task> tasks = todoList.getCategory("shopping");
		assertEquals(1, tasks.size());
		tasks = todoList.getCategory("outing");
		assertEquals(1, tasks.size());
	}

	@Test
	public void testRemoveTaskButCannotFind() {
		int initNumOfTask = todoList.getAllTasks().size();
		todoList.removeTask("Not Existing");
		assertEquals(initNumOfTask, todoList.getAllTasks().size());
	}

	@Test
	public void testRemoveLastTaskAndReturnIsEmpty() {
		todoList.addTask(task1);
		todoList.removeTask(task1.getDescription());
		assertTrue(todoList.getAllTasks().isEmpty());
	}

	@Test
	public void testPrintTaskInTodoList() {
		todoList.addTask(task1);
		assertEquals(task1.print(), todoList.getTask(task1.getDescription()).print());
	}

	@Test
	public void testForExistingTask() {
		ToDoList todoList = new ToDoList();
		Task task = new Task("desc", false);
		Task newTask = new Task("desc", false);
		Collection<Task> collection = todoList.getAllTasks();
		todoList.addTask(task);
		todoList.addTask(newTask);

		// should expect 1 since new task is not added
		assertEquals(1, collection.size());
	}
	
	@Test 
	public void testToDoListSeachFunction() {
		ToDoList todoList = new ToDoList();
		Task task = new Task("desc", false);
		Task newTask = new Task("desc1", false);
		Task newTask2 = new Task("notdess", false);
		Collection<Task> collection = todoList.searchTaskByDescription("desc");
		assertTrue(collection.isEmpty());
		todoList.addTask(task);
		todoList.addTask(newTask);
		todoList.addTask(newTask2);
		collection = todoList.searchTaskByDescription("desc");

		// should expect 1 since new task is not added
		assertEquals(2, collection.size());	}
}
