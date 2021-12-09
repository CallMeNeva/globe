package io.github.altoukhov_max.world.api.dto.mapper;

import java.util.List;

@FunctionalInterface
public interface DTOMapper<E, D> {

    D map(E entity);

    default List<D> map(List<E> entities) {
        return entities.stream()
                .map(this::map)
                .toList();
    }
}
