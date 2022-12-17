package com.creditsaison.omni.commons;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public abstract class AbstractMappingConverter<BO, E> {
    public AbstractMappingConverter() {
    }

    public abstract Function<BO, E> businessToEntity();

    public abstract Function<E, BO> entityToBusinessObject();

    public BO convertToBO(E entity) {
        return this.entityToBusinessObject().apply(entity);
    }

    public E convertToEntity(BO bo) {
        return this.businessToEntity().apply(bo);
    }

    public List<E> convertToEntityList(List<BO> bos) {
        List<E> eList = new ArrayList<>();
        bos.forEach(bo -> {
            E e = convertToEntity(bo);
            eList.add(e);
        });
        return eList;
    }

    public List<BO> convertToBOList(List<E> es) {
        List<BO> boList = new ArrayList<>();
        es.forEach(e -> {
            BO bo = convertToBO(e);
            boList.add(bo);
        });
        return boList;
    }
}
