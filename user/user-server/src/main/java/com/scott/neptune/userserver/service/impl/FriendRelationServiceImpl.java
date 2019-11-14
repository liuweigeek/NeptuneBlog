package com.scott.neptune.userserver.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.scott.neptune.common.response.ServerResponse;
import com.scott.neptune.userapi.dto.UserDto;
import com.scott.neptune.userserver.entity.FriendRelationEntity;
import com.scott.neptune.userserver.mapper.FriendRelationMapper;
import com.scott.neptune.userserver.service.IFriendRelationService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Slf4j
@Transactional
@Service
public class FriendRelationServiceImpl implements IFriendRelationService {

    @Resource
    private FriendRelationMapper friendRelationMapper;

    /**
     * 保存好友关系
     *
     * @param friendRelationEntity 单向好友关系
     * @return 保存结果
     */
    @Override
    public ServerResponse save(FriendRelationEntity friendRelationEntity) {

        if (friendRelationMapper.exists(friendRelationEntity)) {
            return ServerResponse.createBySuccess();
        }
        try {
            friendRelationEntity.setFollowDate(new Date());
            friendRelationMapper.insert(friendRelationEntity);
            return ServerResponse.createBySuccess();
        } catch (Exception e) {
            log.error(e.getMessage());
            return ServerResponse.createByErrorMessage("关注失败");
        }

    }

    /**
     * 获取好友关系
     *
     * @param fromId
     * @param toId
     * @return
     */
    @Override
    public FriendRelationEntity getRelationByFromIdAndToId(String fromId, String toId) {
        return friendRelationMapper.getOne(FriendRelationEntity.builder().fromId(fromId).toId(toId).build());
    }

    /**
     * 删除好友关系
     *
     * @param friendRelationEntity 单向好友关系
     * @return 删除结果
     */
    @Override
    public boolean delete(FriendRelationEntity friendRelationEntity) {

        try {
            friendRelationMapper.delete(friendRelationEntity);
            return true;
        } catch (Exception e) {
            log.error(e.getMessage());
            return false;
        }

    }

    /**
     * 根据关注人和被关注人解除关系
     *
     * @param fromId 关注人
     * @param toId   被关注人
     * @return
     */
    @Override
    public boolean deleteByFromIdAndToId(String fromId, String toId) {
        try {
            friendRelationMapper.delete(FriendRelationEntity.builder().fromId(fromId).toId(toId).build());
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    /**
     * 获取关注列表
     *
     * @param userId 当前登陆用户Id
     * @return 关注列表
     */
    @Override
    public IPage<UserDto> findFollowing(String userId, int pageNumber, int pageSize) {
        if (StringUtils.isBlank(userId)) {
            return new Page<>(pageNumber, pageSize);
        }
        Page<UserDto> page = new Page<>(pageNumber - 1, pageSize);
        return friendRelationMapper.findFollowing(page, FriendRelationEntity.builder().fromId(userId).build());
    }

    /**
     * 获取关注者列表
     *
     * @param userId 当前登陆用户Id
     * @return 关注者列表
     */
    @Override
    public IPage<UserDto> findFollower(String userId, int pageNumber, int pageSize) {
        if (StringUtils.isBlank(userId)) {
            return new Page<>(pageNumber, pageSize);
        }
        Page<UserDto> page = new Page<>(pageNumber - 1, pageSize);
        return friendRelationMapper.findFollower(page, FriendRelationEntity.builder().toId(userId).build());
    }

    /**
     * 获取全部已关注用户
     *
     * @param userId
     * @return
     */
    @Override
    public List<UserDto> findAllFollowing(String userId) {
        try {
            return friendRelationMapper.findAllFollowing(FriendRelationEntity.builder().fromId(userId).build());
        } catch (Exception e) {
            log.error("findAllFollowing exception: ", e);
            return Collections.emptyList();
        }

    }

    /**
     * 获取全部关注者
     *
     * @param userId
     * @return
     */
    @Override
    public List<UserDto> findAllFollower(String userId) {
        try {
            return friendRelationMapper.findAllFollower(FriendRelationEntity.builder().toId(userId).build());
        } catch (Exception e) {
            log.error("findAllFollower exception: ", e);
            return Collections.emptyList();
        }
    }

    /**
     * 获取用户关系
     *
     * @param fromUserId
     * @param toUserId
     * @return
     */
    /*@Override
    public UserDto.RelationEnum getRelation(String fromUserId, String toUserId) {
        if (StringUtils.equals(fromUserId, toUserId)) {
            return null;
        }
        FriendRelationEntity friendRelationEntity = this.getRelationByFromIdAndToId(fromUserId, toUserId);
        if (Objects.isNull(friendRelationEntity)) {
            return UserDto.RelationEnum.UN_FOLLOW;
        }
        return UserDto.RelationEnum.FOLLOWING;
    }*/
}