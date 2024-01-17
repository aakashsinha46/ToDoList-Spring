// app.js
document.addEventListener("DOMContentLoaded", function () {
  fetchTodos();
});

// get all the list
function fetchTodos() {
  axios
    .get("http://localhost:8080/v1/list/all")
    .then((response) => {
      const apiData = response.data;
      const formattedTodos = apiData.map((todo) => {
        return {
          id: todo.id,
          task: todo.list,
          timeOriginalObject: new Date(todo.timeStamp),
          timeStamp: new Date(todo.timeStamp).toLocaleString(), // Format date
          status: todo.status,
        };
      });

      // Sort todos by recently created (descending order)
      formattedTodos.sort(
        (a, b) =>
          new Date(b.timeOriginalObject).getTime() -
          new Date(a.timeOriginalObject).getTime()
      );

      displayTodos(formattedTodos);
    })
    .catch((error) => {
      console.error("Error fetching todos:", error);
    });
}

// display the list
function displayTodos(todos) {
  const todoList = document.getElementById("todoList");
  todoList.innerHTML = "";

  todos.forEach((todo) => {
    const listItem = document.createElement("li");

    // Apply style based on the completed status
    const completedStyle =
      todo.status === "COMPLETE" ? "text-decoration: line-through;" : "";

    listItem.innerHTML = `
            <input type="checkbox" ${
              todo.status === "COMPLETE" ? "checked" : ""
            } onchange="updateTodoStatus(${todo.id}, this.checked)">
            ${todo.task} - ${todo.timeStamp}
            <button class="delete-btn" onclick="deleteTodo(${
              todo.id
            })"><span class="material-symbols-outlined">
                                                                        delete
                                                                        </span></button>
        `;

    // Apply the completed style to the entire list item
    listItem.style.cssText = completedStyle;
    todoList.appendChild(listItem);
  });
}

//add new to list
function addTodo() {
  const newTodoInput = document.getElementById("newTodo");
  const newTodo = { list: newTodoInput.value, status: "INCOMPLETE" };

  axios
    .post("http://localhost:8080/v1/list/add", JSON.stringify(newTodo), {
      headers: {
        "Content-Type": "application/json",
      },
    })
    .then((response) => {
      fetchTodos();
      newTodoInput.value = "";
    })
    .catch((error) => {
      console.error("Error adding todo:", error);
    });
}

// Function to handle Enter key press for adding a new todo
function handleKeyPress(event) {
  if (event.key === "Enter") {
    addTodo();
  }
}

// Add event listener to the input field for Enter key press
const newTodoInput = document.getElementById("newTodo");
newTodoInput.addEventListener("keypress", handleKeyPress);

//edit status
function updateTodoStatus(id, completed) {
  const updatedTodo = { status: completed ? "COMPLETE" : "INCOMPLETE" };
  axios
    .put(`http://localhost:8080/v1/list/edit/${id}`, updatedTodo)
    .then((response) => {
      fetchTodos();
    })
    .catch((error) => {
      console.error("Error updating todo status:", error);
    });
}

//delete list
function deleteTodo(id) {
  axios
    .delete(`http://localhost:8080/v1/list/${id}`)
    .then((response) => {
      fetchTodos();
    })
    .catch((error) => {
      console.error("Error deleting todo:", error);
    });
}
