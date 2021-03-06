package com.scott.neptune.common.component;

import com.scott.neptune.common.property.MinioProperties;
import io.minio.GetBucketPolicyArgs;
import io.minio.MinioClient;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * @Author: scott
 * @Email: <a href="mailto:liuweigeek@outlook.com">Scott Lau</a>
 * @Date: 2019/10/4 17:51
 * @Description: NeptuneBlog
 */
@Slf4j
public class MinioComponentTest {

    private final MinioClient minioClient;
    private final MinioProperties minioProperties;

    public MinioComponentTest(MinioClient minioClient, MinioProperties minioProperties) {
        this.minioClient = minioClient;
        this.minioProperties = minioProperties;
    }

    @Test
    public void getPolicy() {

        try {
            String policy = minioClient.getBucketPolicy(GetBucketPolicyArgs.builder().
                    bucket(minioProperties.getBucket())
                    .build());
            log.info(policy);
            assert true;
        } catch (Exception e) {
            assert false;
        }
    }
}