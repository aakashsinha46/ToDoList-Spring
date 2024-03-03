package in.aakashsinha.ToDoList.controller;


import in.aakashsinha.ToDoList.Model.RequestBodyForList;
import in.aakashsinha.ToDoList.Service.ItemService;
import in.aakashsinha.ToDoList.constants.Status;
import in.aakashsinha.ToDoList.entity.Item;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/list")
@CrossOrigin(origins = "http://localhost:63342")
public class ItemController {

    @Autowired
    ItemService itemService;

    //add new list
    @PostMapping("/add")
    public ResponseEntity<String> addToList(@RequestBody RequestBodyForList requestBody){
        return new ResponseEntity<>(itemService.addToList(requestBody), HttpStatus.CREATED);
    }

    //update list
    @PutMapping("/edit/{id}")
    public ResponseEntity<String> updateList(@PathVariable String id, @RequestBody RequestBodyForList status){
        return new ResponseEntity<>(itemService.updateList(id, status));
    }

    //delete list
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteList(@PathVariable String id){
        return new ResponseEntity<>(itemService.deleteList(id));
    }

    //get all list
    @GetMapping("/all")
    public ResponseEntity<List<Item>> getAll(){
        return new ResponseEntity<>(itemService.getAll(), HttpStatus.OK);
    }


}
