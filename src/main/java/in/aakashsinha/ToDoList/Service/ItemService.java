package in.aakashsinha.ToDoList.Service;

import in.aakashsinha.ToDoList.Model.RequestBodyForList;
import in.aakashsinha.ToDoList.constants.Status;
import in.aakashsinha.ToDoList.entity.Item;
import org.springframework.http.HttpStatusCode;

import java.util.List;

public interface ItemService {

    Long addToList(RequestBodyForList requestBodyForList);

    HttpStatusCode updateList(long id, RequestBodyForList status);

    HttpStatusCode deleteList(long id);

    List<Item> getAll();
}
