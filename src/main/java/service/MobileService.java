package service;

import mvc.server.dto.Mobile;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class MobileService {

    private static List<Mobile> todos = new ArrayList<>(
            Arrays.asList(
                    new Mobile(UUID.randomUUID().toString(), "Learn more programing in Java", "Study"),
                    new Mobile(UUID.randomUUID().toString(), "Understand and practice SOLID principle", "Study"),
                    new Mobile(UUID.randomUUID().toString(), "Understand and practice MVC", "Study")
            )
    );

    public List<Todo> retrievedTodos() {
        return todos;
    }

    public void addTodos(Todo todo) {
        todos.add(todo);
    }

    public void deleteTodo(String uuid) {
        todos = todos.stream()
                .filter(todo -> !todo.getUuid().equals(uuid))
                .collect(Collectors.toList());
    }

}
