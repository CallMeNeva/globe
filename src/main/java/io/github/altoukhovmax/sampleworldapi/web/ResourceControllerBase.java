package io.github.altoukhovmax.sampleworldapi.web;

import org.springframework.core.convert.converter.Converter;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public abstract class ResourceControllerBase<E, D> {

    private final Converter<E, D> entityConverter;

    protected ResourceControllerBase(Converter<E, D> entityConverter) {
        this.entityConverter = entityConverter;
    }

    protected ResponseEntity<D> showOne(Optional<E> entity) {
        return ResponseEntity.of(entity.map(entityConverter::convert));
    }

    protected ResponseEntity<List<D>> showList(List<E> entities) {
        return ResponseEntity.ok(entities
                .stream()
                .map(entityConverter::convert)
                .collect(Collectors.toList()));
    }
}
