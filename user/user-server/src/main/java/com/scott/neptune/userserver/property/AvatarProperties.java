package com.scott.neptune.userserver.property;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: scott
 * @Email: <a href="mailto:liuweigeek@outlook.com">scott</a>
 * @Date: 2019/10/29 15:08
 * @Description: NeptuneBlog
 */
@Data
@Component
@ConfigurationProperties(prefix = "neptune.user.avatar")
public class AvatarProperties {

    private String extension;

    private List<AvatarSizeValObj> sizes = new ArrayList<>();

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class AvatarSizeValObj {

        private Integer sizeType;
        private String sizeName;
        private Integer width;
        private Integer height;
    }

}
