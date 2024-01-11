package in.aakashsinha.ToDoList.repository;

import in.aakashsinha.ToDoList.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
}
