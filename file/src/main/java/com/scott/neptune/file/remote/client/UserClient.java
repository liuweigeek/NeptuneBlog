package com.scott.neptune.file.remote.client;

import com.scott.neptune.common.response.ServerResponse;
import com.scott.neptune.file.remote.hystrix.UserClientFallbackFactory;
import com.scott.neptune.userapi.dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * User服务的远程调用接口
 *
 * @author scott
 */
@FeignClient(name = "user", fallbackFactory = UserClientFallbackFactory.class)
public interface UserClient {

    /**
     * 获取指定用户
     *
     * @param id 用户ID
     * @return 用户对象
     */
    @GetMapping(value = "/userServer/getUserById/{id}")
    ServerResponse<UserDto> getUserById(@PathVariable String id);

    /**
     * 获取当前登录用户
     *
     * @return 当前登录用户
     */
    @GetMapping(value = "/userServer/getLoginUser")
    ServerResponse<UserDto> getLoginUser();

    /**
     * 通过ID列表获取全部用户
     *
     * @param idList 用户ID列表
     * @return 用户对象列表
     */
    @GetMapping(value = "/userServer/findAllUserByIdList")
    List<UserDto> findAllUserByIdList(List<String> idList);

    /**
     * 获取全部正在关注的用户Id
     *
     * @return
     */
    @GetMapping(value = "/friendServer/getFollowingUserIds")
    ServerResponse<List<String>> getFollowingUserIds();
}
