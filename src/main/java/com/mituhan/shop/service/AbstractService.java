package com.mituhan.shop.service;

public interface AbstractService<T> {
    void delete(Long[] ids);
    int totalItem();
}
