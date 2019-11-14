package com.scott.neptune.fileserver.component;

import com.scott.neptune.fileserver.FileServerApplicationTests;
import com.scott.neptune.fileserver.property.MinioProperties;
import io.minio.MinioClient;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * @Author: scott
 * @Email: <a href="mailto:wliu@fleetup.com">scott</a>
 * @Date: 2019/10/4 17:51
 * @Description: NeptuneBlog
 */
@Slf4j
public class MinioComponentTest extends FileServerApplicationTests {

    @Resource
    private MinioClient minioClient;

    @Resource
    private MinioProperties minioProperties;

    @Test
    public void getPolicy() {

        try {
            String policy = minioClient.getBucketPolicy(minioProperties.getBucket());
            log.info(policy);
            assert true;
        } catch (Exception e) {
            assert false;
        }
    }
}