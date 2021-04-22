package com.mituhan.shop.service;

public interface BaseService<T> {
    void delete(Long[] ids);
    int totalItem();
    T save(T objectDTO);
}
