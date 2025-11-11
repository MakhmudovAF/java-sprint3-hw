public class Main {
    public static void main(String[] args) {
        Manager manager = new Manager();

        System.out.println("=== СОЗДАНИЕ ЗАДАЧ И ЭПИКОВ ===");

        Task task1 = manager.createTask(new Task("Задача 1", "Описание задачи 1", "NEW"));
        Task task2 = manager.createTask(new Task("Задача 2", "Описание задачи 2", "NEW"));

        Epic epic1 = manager.createEpic(new Epic("Эпик 1", "Первый эпик с двумя подзадачами", "NEW"));
        Subtask subtask1 = manager.createSubtask(new Subtask("Подзадача 1.1", "Первая подзадача первого эпика", "NEW", epic1.getId()));
        Subtask subtask2 = manager.createSubtask(new Subtask("Подзадача 1.2", "Вторая подзадача первого эпика", "NEW", epic1.getId()));

        Epic epic2 = manager.createEpic(new Epic("Эпик 2", "Второй эпик с одной подзадачей", "NEW"));
        Subtask subtask3 = manager.createSubtask(new Subtask("Подзадача 2.1", "Единственная подзадача второго эпика", "NEW", epic2.getId()));

        System.out.println("\n--- Все задачи ---");
        for (Task task : manager.getAllTasks()) {
            System.out.println(task);
        }

        System.out.println("\n--- Все эпики ---");
        for (Epic epic : manager.getAllEpics()) {
            System.out.println(epic);
        }

        System.out.println("\n--- Все подзадачи ---");
        for (Subtask subtask : manager.getAllSubtasks()) {
            System.out.println(subtask);
        }

        System.out.println("\n=== ИЗМЕНЕНИЕ СТАТУСОВ ===");

        task1.setStatus("DONE");
        manager.updateTask(task1);

        subtask1.setStatus("IN_PROGRESS");
        manager.updateSubtask(subtask1);

        subtask2.setStatus("DONE");
        manager.updateSubtask(subtask2);

        subtask3.setStatus("DONE");
        manager.updateSubtask(subtask3);

        System.out.println("\n--- После изменения статусов ---");
        System.out.println("Задача 1: " + task1.getStatus() + " (должен быть DONE)");
        System.out.println("Подзадача 1.1: " + subtask1.getStatus() + " (должен быть IN_PROGRESS)");
        System.out.println("Эпик 1: " + manager.getEpicById(epic1.getId()).getStatus() + " (должен быть IN_PROGRESS)");
        System.out.println("Эпик 2: " + manager.getEpicById(epic2.getId()).getStatus() + " (должен быть DONE)");

        System.out.println("\n--- Все задачи после изменения статусов ---");
        for (Task task : manager.getAllTasks()) {
            System.out.println(task);
        }

        System.out.println("\n--- Все эпики после изменения статусов ---");
        for (Epic epic : manager.getAllEpics()) {
            System.out.println(epic);
        }

        System.out.println("\n--- Все подзадачи после изменения статусов ---");
        for (Subtask subtask : manager.getAllSubtasks()) {
            System.out.println(subtask);
        }

        System.out.println("\n=== ПРОВЕРКА УДАЛЕНИЯ ===");

        System.out.println("Удаляем задачу с id=" + task1.getId());
        manager.deleteTaskById(task1.getId());

        System.out.println("Удаляем эпик с id=" + epic1.getId());
        manager.deleteEpicById(epic1.getId());

        System.out.println("\n--- После удаления ---");
        System.out.println("Все задачи:");
        for (Task task : manager.getAllTasks()) {
            System.out.println(task);
        }

        System.out.println("\nВсе эпики:");
        for (Epic epic : manager.getAllEpics()) {
            System.out.println(epic);
        }

        System.out.println("\nВсе подзадачи:");
        for (Subtask subtask : manager.getAllSubtasks()) {
            System.out.println(subtask);
        }

        System.out.println("\n--- Проверка удаления подзадач эпика 1 ---");
        System.out.println("Подзадача 1.1 (id=" + subtask1.getId() + "): " + manager.getSubtaskById(subtask1.getId()));
        System.out.println("Подзадача 1.2 (id=" + subtask2.getId() + "): " + manager.getSubtaskById(subtask2.getId()));
        System.out.println("Подзадача 2.1 (id=" + subtask3.getId() + "): " + manager.getSubtaskById(subtask3.getId()));
        
        System.out.println("\n--- Подзадачи оставшегося эпика 2 ---");
        for (Subtask subtask : manager.getSubtasksByEpicId(epic2.getId())) {
            System.out.println(subtask);
        }
    }
}