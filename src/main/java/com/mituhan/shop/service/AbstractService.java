package com.mituhan.shop.service;

public interface AbstractService<T> {
    T save(T objectDTO);
    void delete(Long[] ids);
    int totalItem();
}
