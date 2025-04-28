package br.com.okto.shared.dto;

import java.util.List;

public record PageInfo<T>(
        List<T> content,
        long totalItems,
        int page,
        int size,
        int totalPages
) {
}
