package io.github.callmeneva.globe;

import org.modelmapper.ModelMapper;
import org.springframework.util.Assert;

import java.util.List;

public final class ModelMapperUtils {

    public static <E, D> List<D> mapAll(ModelMapper mapper, List<E> entities, Class<D> targetClass) {
        Assert.notNull(mapper, "Mapper is null");
        Assert.notNull(entities, "Entities list is null");
        Assert.notNull(targetClass, "Target class is null");

        return entities.stream()
                .map(entity -> mapper.map(entity, targetClass))
                .toList();
    }
}
