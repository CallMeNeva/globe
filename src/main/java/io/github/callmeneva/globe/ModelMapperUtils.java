// SPDX-FileCopyrightText: Copyright 2022 Maxim Altoukhov
// SPDX-License-Identifier: MIT

package io.github.callmeneva.globe;

import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.Objects;

public final class ModelMapperUtils {

    public static <E, D> List<D> mapAll(ModelMapper mapper, List<E> entities, Class<D> targetClass) {
        Objects.requireNonNull(mapper, "Mapper is null");
        Objects.requireNonNull(entities, "Entities list is null");
        Objects.requireNonNull(targetClass, "Target class is null");

        return entities.stream()
                .map(entity -> mapper.map(entity, targetClass))
                .toList();
    }
}
