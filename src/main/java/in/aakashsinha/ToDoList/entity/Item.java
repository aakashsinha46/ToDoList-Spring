package in.aakashsinha.ToDoList.entity;

import in.aakashsinha.ToDoList.constants.Status;
import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID")
    private long id;

    @Column(name = "LIST")
    @NonNull
    private String list;

    @Column(name = "TIME")
    private Instant timeStamp;

    @Column(name = "STATUS")
    private Status status = Status.INCOMPLETE;
}
