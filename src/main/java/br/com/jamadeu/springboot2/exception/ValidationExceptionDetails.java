package br.com.jamadeu.springboot2.exception;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@ToString
public class ValidationExceptionDetails extends ExceptionDetails {
    private final String fields;
    private final String fieldsMessage;
}
