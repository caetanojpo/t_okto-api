package br.com.okto.shared.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.Instant;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record ApiResponse<T>(
        @JsonProperty("data") T data,
        @JsonProperty("errors") List<ErrorInfo> errors,
        @JsonProperty("meta") PageInfo<T> meta,
        @JsonProperty("timestamp") Instant timestamp
) {
    public static <T> ApiResponse<T> success(T data) {
        return new ApiResponse<>(data, null, null, Instant.now());
    }

    public static <T> ApiResponse<T> success(T data, PageInfo<T> meta) {
        return new ApiResponse<>(data, null, meta, Instant.now());
    }

    public static <T> ApiResponse<T> error(List<ErrorInfo> errors) {
        return new ApiResponse<>(null, errors, null, Instant.now());
    }
}

