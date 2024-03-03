package in.aakashsinha.ToDoList.Service;

import in.aakashsinha.ToDoList.Model.RequestBodyForList;
import in.aakashsinha.ToDoList.entity.Item;
import org.bson.types.ObjectId;
import org.springframework.http.HttpStatusCode;

import java.util.List;

public interface ItemService {

    String addToList(RequestBodyForList requestBodyForList);

    HttpStatusCode updateList(String id, RequestBodyForList status);

    HttpStatusCode deleteList(String id);

    List<Item> getAll();
}
