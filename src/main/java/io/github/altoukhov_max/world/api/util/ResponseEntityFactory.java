package io.github.altoukhov_max.world.api.util;

import io.github.altoukhov_max.world.api.dto.mapper.DTOMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

public class ResponseEntityFactory<E, D> {

    private final DTOMapper<E, D> mapper;

    private ResponseEntityFactory(DTOMapper<E, D> mapper) {
        this.mapper = mapper;
    }

    public static <E, D> ResponseEntityFactory<E, D> withMapper(DTOMapper<E, D> mapper) {
        Assert.notNull(mapper, "DTO mapper must not be null");
        return new ResponseEntityFactory<>(mapper);
    }

    public ResponseEntity<D> create(Supplier<Optional<E>> entitySupplier) {
        Assert.notNull(entitySupplier, "Entity supplier must not be null");
        Optional<E> entity = entitySupplier.get();
        return ResponseEntity.of(entity.map(mapper::map));
    }

    public ResponseEntity<List<D>> createOfList(Supplier<List<E>> entityListSupplier) {
        Assert.notNull(entityListSupplier, "Entity list supplier must not be null");
        List<E> entities = entityListSupplier.get();
        return ResponseEntity.ok(mapper.map(entities));
    }
}
