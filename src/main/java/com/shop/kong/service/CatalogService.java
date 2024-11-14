package com.shop.kong.service;

import com.google.protobuf.InvalidProtocolBufferException;
import com.shop.kong.entity.Catalog;
import com.shop.kong.entity.Message.mac_address;
import com.shop.kong.entity.Message.stream_location;

import java.util.List;

public interface CatalogService {
    List<Catalog> listCatalogs();

    mac_address getMacAddress(byte[] input) throws InvalidProtocolBufferException;

    stream_location getStreamLocation(byte[] input) throws InvalidProtocolBufferException;
}
