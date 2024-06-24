package com.duyhien.springDataJPA24d6m.Controller;

import com.duyhien.springDataJPA24d6m.Dto.Request.UserRequestDTO;
import com.duyhien.springDataJPA24d6m.Dto.Response.PageResponse;
import com.duyhien.springDataJPA24d6m.Dto.Response.UserDetailResponse;
import com.duyhien.springDataJPA24d6m.Model.UserStatus;
import com.duyhien.springDataJPA24d6m.Service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@Slf4j
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/")
    public ResponseEntity<Long> addUser(@RequestBody UserRequestDTO request) {
        log.info("Request add user, {} {}", request.getFirstName(), request.getLastName());

//        try {
            long userId = userService.saveUser(request);
//            return new ResponseEntity<>(HttpStatus.CREATED.value(), Translator.toLocale("user.add.success"), userId);
            return ResponseEntity.ok(userId);
//        } catch (Exception e) {
//            return new ResponseError(HttpStatus.BAD_REQUEST.value(), "Add user fail");
//            return ResponseEntity.ok();
//        }
    }

    @PutMapping("/{userId}")
    public ResponseEntity<String> updateUser(@PathVariable long userId, @RequestBody UserRequestDTO request) {
        log.info("Request update userId={}", userId);

//        try {
            userService.updateUser(userId, request);
            return ResponseEntity.ok("success");
//            return new ResponseData<>(HttpStatus.ACCEPTED.value(), Translator.toLocale("user.upd.success"));
//        } catch (Exception e) {
//            log.error(ERROR_MESSAGE, e.getMessage(), e.getCause());
//            return new ResponseError(HttpStatus.BAD_REQUEST.value(), "Update user fail");
//        }
    }

    @PatchMapping("/{userId}")
    public ResponseEntity<String> updateStatus(@PathVariable int userId, @RequestParam UserStatus status) {
        log.info("Request change status, userId={}", userId);

//        try {
            userService.changeStatus(userId, status);
            return ResponseEntity.ok("success");
//    } catch (Exception e) {
//        log.error(ERROR_MESSAGE, e.getMessage(), e.getCause());
//        return new ResponseError(HttpStatus.BAD_REQUEST.value(), "Change status fail");
//        }
    }


    @DeleteMapping("/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable long userId) {
        log.info("Request delete userId={}", userId);

//        try {
            userService.deleteUser(userId);
        return ResponseEntity.ok("success");
//            return new ResponseData<>(HttpStatus.NO_CONTENT.value(), Translator.toLocale("user.del.success"));
//        } catch (Exception e) {
//            log.error(ERROR_MESSAGE, e.getMessage(), e.getCause());
//            return new ResponseError(HttpStatus.BAD_REQUEST.value(), "Delete user fail");
//        }
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserDetailResponse> getUser(@PathVariable long userId) {
        log.info("Request get user detail, userId={}", userId);

//        try {
            UserDetailResponse user = userService.getUser(userId);
            return ResponseEntity.ok(user);
//            return new ResponseData<>(HttpStatus.OK.value(), "user", user);
//        } catch (Exception e) {
//            log.error(ERROR_MESSAGE, e.getMessage(), e.getCause());
//            return new ResponseError(HttpStatus.BAD_REQUEST.value(), e.getMessage());
//        }
    }

    @GetMapping("/list")
    public ResponseEntity<PageResponse> getAllUsers(@RequestParam(defaultValue = "0", required = false) int pageNo,
                                                   @RequestParam(defaultValue = "20", required = false) int pageSize) {
        log.info("Request get user list, pageNo={}, pageSize={}", pageNo, pageSize);

//        try {
            PageResponse<?> users = userService.getAllUsers(pageNo, pageSize);
            return ResponseEntity.ok(users);
//            return new ResponseData<>(HttpStatus.OK.value(), "users", users);
//        } catch (Exception e) {
//            log.error(ERROR_MESSAGE, e.getMessage(), e.getCause());
//            return new ResponseError(HttpStatus.BAD_REQUEST.value(), e.getMessage());
//        }
    }
}
