package io.github.altoukhov_max.world.api;

import org.springframework.core.convert.converter.Converter;
import org.springframework.http.ResponseEntity;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

public abstract class ResourceControllerBase<E, D> {

    private final Converter<E, D> entityConverter;

    protected ResourceControllerBase(Converter<E, D> entityConverter) {
        this.entityConverter = entityConverter;
    }

    protected ResponseEntity<D> responseOf(Optional<E> entity) {
        return ResponseEntity.of(entity.map(entityConverter::convert));
    }

    protected ResponseEntity<Collection<D>> responseOf(Collection<E> entities) {
        return ResponseEntity.ok(entities.stream()
                .map(entityConverter::convert)
                .collect(Collectors.toList()));
    }
}
