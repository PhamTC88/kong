package com.shop.kong.service;

import com.google.protobuf.InvalidProtocolBufferException;
import com.shop.kong.entity.Catalog;
import com.shop.kong.entity.Message.mac_address;

import java.io.IOException;
import java.util.List;

public interface CatalogService {
    List<Catalog> listCatalogs();

    mac_address getMacAddress(byte[] input) throws InvalidProtocolBufferException;
}
