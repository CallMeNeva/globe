package io.github.altoukhovmax.sampleworldapi.web;

import org.springframework.core.convert.converter.Converter;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public abstract class ResourceControllerBase<E, D> {

    private final Converter<E, D> entityDTOConverter;

    protected ResourceControllerBase(Converter<E, D> entityDTOConverter) {
        this.entityDTOConverter = entityDTOConverter;
    }

    protected ResponseEntity<D> showOne(Optional<E> entity) {
        return ResponseEntity.of(entity.map(entityDTOConverter::convert));
    }

    protected ResponseEntity<List<D>> showList(List<E> entities) {
        return entities.isEmpty() ?
                ResponseEntity.notFound().build() :
                ResponseEntity.ok(entities
                        .stream()
                        .map(entityDTOConverter::convert)
                        .collect(Collectors.toList()));
    }
}
