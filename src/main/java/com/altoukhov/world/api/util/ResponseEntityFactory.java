package com.altoukhov.world.api.util;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

@Component
public class ResponseEntityFactory {

    private final ModelMapper modelMapper;

    @Autowired
    public ResponseEntityFactory(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public <E, D> ResponseEntity<D> create(Supplier<Optional<E>> entitySupplier, Class<D> dtoClass) {
        Assert.notNull(entitySupplier, "Entity supplier must not be null");
        Assert.notNull(dtoClass, "DTO class must not be null");

        Optional<E> entity = entitySupplier.get();
        Optional<D> dto = entity.map(e -> modelMapper.map(e, dtoClass));

        return ResponseEntity.of(dto);
    }

    public <E, D> ResponseEntity<List<D>> createForList(Supplier<List<E>> entityListSupplier, Class<D> dtoClass) {
        Assert.notNull(entityListSupplier, "Entity list supplier must not be null");
        Assert.notNull(dtoClass, "DTO class must not be null");

        List<E> entities = entityListSupplier.get();
        Assert.notNull(entities, "Entity list must not be null");

        List<D> dtos = entities.stream()
                .map(entity -> modelMapper.map(entity, dtoClass))
                .toList();

        return ResponseEntity.ok(dtos);
    }
}
