package com.shop.kong.service;

import com.shop.kong.constant.I18n;
import com.shop.kong.entity.Catalog;
import com.shop.kong.repositories.CatalogRepository;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

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
            log.info(message);
        }

        String message = messageSource.getMessage(I18n.GREETING, null, locale);
        log.info("Message: {}", message);

        return listCatalogs;
    }
}
