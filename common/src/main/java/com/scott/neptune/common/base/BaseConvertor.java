package com.scott.neptune.common.base;

import java.util.function.Function;

/**
 * @Author: scott
 * @Email: <a href="wliu@fleetup.com">scott</a>
 * @Date: 2020/8/3 21:05
 * @Description:
 */
public abstract class BaseConvertor<ENTITY, DTO> {

    private Function<ENTITY, DTO> INSTANCE_TO_DTO = null;

    private Function<DTO, ENTITY> INSTANCE_TO_ENTITY = null;


    /**
     * convert to DTO
     *
     * @return
     */
    //TODO concurrency
    public Function<ENTITY, DTO> convertToDto() {
        if (INSTANCE_TO_DTO == null) {
            INSTANCE_TO_DTO = getFunctionInstanceToDto();
        }
        return INSTANCE_TO_DTO;
    }

    /**
     * convert to Entity
     *
     * @return
     */
    //TODO concurrency
    public Function<DTO, ENTITY> convertToEntity() {
        if (INSTANCE_TO_ENTITY == null) {
            INSTANCE_TO_ENTITY = getFunctionInstanceToEntity();
        }
        return INSTANCE_TO_ENTITY;
    }

    /**
     * @return
     */
    protected abstract Function<ENTITY, DTO> getFunctionInstanceToDto();

    /**
     * if (INSTANCE_TO_DTO == null) {
     * INSTANCE_TO_DTO = getFunctionInstanceToDto();
     * }
     * return INSTANCE_TO_DTO;
     *
     * @return
     */
    protected abstract Function<DTO, ENTITY> getFunctionInstanceToEntity();

}