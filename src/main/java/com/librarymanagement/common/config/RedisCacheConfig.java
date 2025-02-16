package com.librarymanagement.common.config;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.librarymanagement.book.ui.dto.response.GetBookInfoHttpResponse;
import com.librarymanagement.user.ui.dto.response.GetUserInfoHttpResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.time.Duration;

@Configuration
@EnableCaching
@RequiredArgsConstructor
public class RedisCacheConfig {


    private final RedisConnectionFactory redisConnectionFactory;

    private static final Duration USER_INFO_EXPIRATION = Duration.ofMinutes(10);
    private static final Duration BOOK_INFO_EXPIRATION = Duration.ofMinutes(10);

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper()
                .findAndRegisterModules()
                .enable(SerializationFeature.INDENT_OUTPUT)
                .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                .registerModule(new JavaTimeModule());
    }

    @Bean
    @Primary
    public RedisCacheManager defaultCacheManager() {
        return RedisCacheManager.builder(redisConnectionFactory)
                .build();
    }

    @Bean
    public RedisCacheManager userInfoCacheManager() {
        return RedisCacheManager.builder(redisConnectionFactory)
                .cacheDefaults(createJsonCacheConfig(USER_INFO_EXPIRATION, GetUserInfoHttpResponse.class))
                .build();
    }

    @Bean
    public RedisCacheManager bookInfoCacheManager() {
        return RedisCacheManager.builder(redisConnectionFactory)
                .cacheDefaults(createJsonCacheConfig(BOOK_INFO_EXPIRATION, GetBookInfoHttpResponse.class))
                .build();
    }

    private <T> RedisCacheConfiguration createJsonCacheConfig(Duration ttl, Class<T> type) {
        return RedisCacheConfiguration.defaultCacheConfig()
                .entryTtl(ttl)
                .disableCachingNullValues()
                .serializeKeysWith(RedisSerializationContext.SerializationPair.fromSerializer(new StringRedisSerializer()))
                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(jsonSerializer(objectMapper(), type)));
    }

    private <T> RedisSerializer<T> jsonSerializer(ObjectMapper objectMapper, Class<T> type) {
        return new Jackson2JsonRedisSerializer<>(objectMapper, type);
    }

}