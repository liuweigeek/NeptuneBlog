package com.scott.neptune.file.service;

import com.scott.neptune.common.response.ServerResponse;
import com.scott.neptune.userapi.dto.UserAvatarDto;
import com.scott.neptune.userapi.dto.UserDto;

import java.io.File;
import java.util.List;

/**
 * @Author: scott
 * @Email: <a href="mailto:wliu@fleetup.com">scott</a>
 * @Date: 2019/10/29 15:21
 * @Description: NeptuneBlog
 */
public interface IAvatarService {

    ServerResponse<List<UserAvatarDto>> generateAvatar(UserDto userDto, File imageFile);
}
