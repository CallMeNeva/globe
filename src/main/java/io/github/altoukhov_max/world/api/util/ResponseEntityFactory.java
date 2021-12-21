/*
 * Copyright 2021 Maxim Altoukhov
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package io.github.altoukhov_max.world.api.util;

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
