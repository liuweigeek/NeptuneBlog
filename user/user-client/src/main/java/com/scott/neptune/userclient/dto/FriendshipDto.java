package com.scott.neptune.userclient.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: scott
 * @Email: <a href="mailto:liuweigeek@outlook.com">Scott Lau</a>
 * @Date: 2019/10/6 15:59
 * @Description: 关注关系
 */
@Data
@Builder
@EqualsAndHashCode(callSuper = false, of = {"sourceId", "targetId"})
@NoArgsConstructor
@AllArgsConstructor
public class FriendshipDto implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 关注人ID
     */
    private Long sourceId;

    /**
     * 被关注人ID
     */
    private Long targetId;

    /**
     * 关注人
     */
    private RelationshipUserDto sourceUser;

    /**
     * 被关注人
     */
    private RelationshipUserDto targetUser;

    /**
     * 关注时间
     */
    private Date followDate;

    /**
     * 关注来源
     */
    private String followFrom;

}
