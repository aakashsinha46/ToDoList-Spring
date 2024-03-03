package in.aakashsinha.ToDoList.repository;

import in.aakashsinha.ToDoList.entity.Item;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends MongoRepository<Item, String> {
}
