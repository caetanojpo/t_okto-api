package br.com.okto.shared.dto;

public record ErrorInfo(
        String code,
        String message,
        String field
) {
}
