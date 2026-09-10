package sg.edu.ntu.taskflow_api.model;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.UUID;

@Data
@NoArgsConstructor
@JsonPropertyOrder({ "id", "title", "description", "priority", "isCompleted" })
public class Task {
    private final Long id = UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;
    private String title;
    private String description;
    private String priority;
    private boolean isCompleted;

    // Keep this constructor — it has custom logic used for preloading data
    public Task(String title, String description, String priority, boolean isCompleted) {
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.isCompleted = isCompleted;
    }
}
