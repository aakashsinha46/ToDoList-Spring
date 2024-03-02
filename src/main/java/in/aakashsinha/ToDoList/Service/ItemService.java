package in.aakashsinha.ToDoList.Service;

import in.aakashsinha.ToDoList.Model.RequestBodyForList;
import in.aakashsinha.ToDoList.entity.Item;
import org.bson.types.ObjectId;
import org.springframework.http.HttpStatusCode;

import java.util.List;

public interface ItemService {

    ObjectId addToList(RequestBodyForList requestBodyForList);

    HttpStatusCode updateList(ObjectId id, RequestBodyForList status);

    HttpStatusCode deleteList(ObjectId id);

    List<Item> getAll();
}
