package ru.gb.vkr.vkrProject.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.gb.vkr.vkrProject.Entity.User;
import ru.gb.vkr.vkrProject.service.UserService;
import java.util.List;
import java.util.Optional;

/**
 * Это REST-контроллер UserController, который обрабатывает HTTP-запросы,
 * связанные с пользователями, и использует UserService для выполнения запросов.
 */
@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Метод вызывает userService.getAllUsers(), чтобы получить список всех
     * зарегистрированных пользователей.
     * @return - метод возвращает ResponseEntity<List<User>>,
     * что означает, что ответ будет содержать список пользователей в формате JSON.
     */
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    /**
     * 1. Метод вызывает userService.getUserById(id), чтобы получить
     * пользователя по его идентификатору.
     * 2. Метод возвращает ResponseEntity<User>, что означает, что ответ
     * будет содержать информацию о пользователе в формате JSON. Если
     * пользователь не найден, возвращается HTTP-статус 404 (Not Found).
     */
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        Optional<User> user = userService.getUserById(id);
        return user.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * @param user - вызывает userService.createUser(user), чтобы создать нового пользователя.
     * @return Метод возвращает ResponseEntity<User>, что означает,
     * что ответ будет содержать созданного пользователя в формате JSON.
     * Возвращается HTTP-статус 201 (Created).
     */
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User createdUser = userService.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }

    /**
     * @param id принимает идентификатор пользователя в качестве переменной {id}
     *           и новые данные пользователя в теле запроса, обозначенные аннотацией @RequestBody.
     * @param user вызывает userService.updateUser(id, user), чтобы обновить информацию
     *             о пользователе.
     * @return - возвращает ResponseEntity<User>, что означает, что ответ
     *         будет содержать обновленного пользователя в формате JSON.
     *         Если пользователь не найден, возвращается HTTP-статус 404 (Not Found).
     */
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) {
        User updatedUser = userService.updateUser(id, user);
        if (updatedUser != null) {
            return ResponseEntity.ok(updatedUser);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Метод вызывает userService.deleteUser(id), чтобы удалить пользователя.
     * @param id принимает идентификатор пользователя в качестве переменной {id}.
     * @return возвращает ResponseEntity<Void>, что означает, что в ответе не будет
     * никаких данных, только HTTP-статус 204 (No Content).
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
