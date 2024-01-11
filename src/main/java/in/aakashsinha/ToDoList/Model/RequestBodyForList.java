package in.aakashsinha.ToDoList.Model;

import in.aakashsinha.ToDoList.constants.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestBodyForList {

    private String list;
    private Status status;
}
