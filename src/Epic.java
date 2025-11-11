import java.util.ArrayList;

public class Epic extends Task {
    private ArrayList<Integer> subtasksId;

    public Epic(String name, String description, int id, String status) {
        super(name, description, id, status);
    }
}