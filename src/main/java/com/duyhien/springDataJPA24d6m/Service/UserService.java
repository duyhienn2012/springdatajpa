package com.duyhien.springDataJPA24d6m.Service;

import com.duyhien.springDataJPA24d6m.Dto.Request.UserRequestDTO;
import com.duyhien.springDataJPA24d6m.Dto.Response.PageResponse;
import com.duyhien.springDataJPA24d6m.Dto.Response.UserDetailResponse;
import com.duyhien.springDataJPA24d6m.Model.UserStatus;

public interface UserService {

    long saveUser(UserRequestDTO request);

    void updateUser(long userId, UserRequestDTO request);

    void changeStatus(long userID, UserStatus status);

    void deleteUser(long userId);

    UserDetailResponse getUser(long userId);

    PageResponse getAllUsers(int pageNo, int pageSize);
}
