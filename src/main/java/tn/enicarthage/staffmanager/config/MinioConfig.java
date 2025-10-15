package tn.enicarthage.staffmanager.config;

import io.minio.BucketExistsArgs;
import io.minio.MakeBucketArgs;
import io.minio.MinioClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class MinioConfig {

    @Value("${minio.url}")
    private String minioUrl;

    @Value("${minio.access-key}")
    private String accessKey;

    @Value("${minio.secret-key}")
    private String secretKey;

    @Value("${minio.bucket-name}")
    private String bucketName;

    @Value("${minio.auto-create-bucket:true}")
    private boolean autoCreateBucket;

    @Bean
    public MinioClient minioClient() {
        try {
            MinioClient minioClient = MinioClient.builder()
                    .endpoint(minioUrl)
                    .credentials(accessKey, secretKey)
                    .build();

            // Create bucket if it doesn't exist and auto-create is enabled
            if (autoCreateBucket) {
                boolean bucketExists = minioClient.bucketExists(
                        BucketExistsArgs.builder()
                                .bucket(bucketName)
                                .build()
                );

                if (!bucketExists) {
                    minioClient.makeBucket(
                            MakeBucketArgs.builder()
                                    .bucket(bucketName)
                                    .build()
                    );
                    log.info("MinIO bucket '{}' created successfully", bucketName);
                } else {
                    log.info("MinIO bucket '{}' already exists", bucketName);
                }
            }

            log.info("MinIO client configured successfully - URL: {}, Bucket: {}", minioUrl, bucketName);
            return minioClient;

        } catch (Exception e) {
            log.error("Error configuring MinIO client: {}", e.getMessage());
            throw new RuntimeException("Failed to configure MinIO client", e);
        }
    }

    @Bean
    public String minioBucketName() {
        return bucketName;
    }
}
