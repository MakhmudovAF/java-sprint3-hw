public class Subtask extends Task {
    private int epicId;

    public Subtask(String name, String description, int id, String status) {
        super(name, description, id, status);
    }

    public int getEpicId() {
        return epicId;
    }

    public void setEpicId(int epicId) {
        this.epicId = epicId;
    }
}