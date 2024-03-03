package in.aakashsinha.ToDoList.entity;

import in.aakashsinha.ToDoList.constants.Status;
import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;


@Document(collection = "task")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Item {
    @Id
    private String id;
    @NonNull
    private String list;
    private Instant timeStamp;
    private Status status = Status.INCOMPLETE;
}
