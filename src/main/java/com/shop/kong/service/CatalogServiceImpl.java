package com.shop.kong.service;

import com.google.protobuf.InvalidProtocolBufferException;
import com.shop.kong.constant.I18n;
import com.shop.kong.entity.Catalog;
import com.shop.kong.entity.Message.*;
import com.shop.kong.repositories.CatalogRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

@Service
@Slf4j
public class CatalogServiceImpl implements CatalogService {

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private CatalogRepository catalogRepository;

    @Override
    public List<Catalog> listCatalogs() {
        List<Catalog> listCatalogs = catalogRepository.findAll();

        Locale locale = LocaleContextHolder.getLocale();
        if (listCatalogs.isEmpty()) {
            String message = messageSource.getMessage(I18n.ERROR_NOT_FOUND, null, locale);
            System.out.println(message);
        }

        String message = messageSource.getMessage(I18n.GREETING, null, locale);
        System.out.println(message);

        return listCatalogs;
    }

    @Override
    public mac_address getMacAddress(byte[] input) throws InvalidProtocolBufferException {
        mac_address response = mac_address.parseFrom(input);

        log.info(response.toString());

        return response;
    }

    @Override
    public stream_location getStreamLocation(byte[] input) throws InvalidProtocolBufferException {
        stream_location response = stream_location.parseFrom(input);

        log.info(response.toString());

        return response;
    }
}
