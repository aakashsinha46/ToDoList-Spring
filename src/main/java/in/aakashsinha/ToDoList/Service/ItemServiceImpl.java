package in.aakashsinha.ToDoList.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import in.aakashsinha.ToDoList.Model.RequestBodyForList;
import in.aakashsinha.ToDoList.entity.Item;
import in.aakashsinha.ToDoList.repository.ItemRepository;
import lombok.extern.log4j.Log4j2;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
@Log4j2
public class ItemServiceImpl implements ItemService {

    @Autowired
    ItemRepository itemRepository;

    @Override
    public String addToList(RequestBodyForList requestBodyForList) {
        ObjectMapper objectMapper = new ObjectMapper();
        Item item = objectMapper.convertValue(requestBodyForList, Item.class);
        item.setTimeStamp(Instant.now());

        item = itemRepository.save(item);

        log.info("item added");
        return item.getId();
    }

    @Override
    public HttpStatusCode updateList(String id, RequestBodyForList status) {

        //check if exists
        if (itemRepository.findById(id).isPresent()) {
            //true -> update
            Item item = itemRepository.findById(id).orElseThrow();
            item.setStatus(status.getStatus());

            itemRepository.save(item);
            return HttpStatus.ACCEPTED;
        }
        //else -> return 404
        else return HttpStatus.NOT_FOUND;

    }

    @Override
    public HttpStatusCode deleteList(String id) {
        itemRepository.deleteById(id);
        return HttpStatus.ACCEPTED;
    }

    @Override
    public List<Item> getAll() {
        return itemRepository.findAll();
    }

}
