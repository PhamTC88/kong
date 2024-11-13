package com.shop.kong;

import com.google.protobuf.ByteString;
import com.google.protobuf.InvalidProtocolBufferException;
import com.shop.kong.entity.Message.mac_address;
import com.shop.kong.service.CatalogService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@SpringBootTest
@Slf4j
class KongApplicationTests {

    @Autowired
    private CatalogService catalogService;

    @Test
    void contextLoads() {
    }

    @Test
    void testGetMacAddress() throws InvalidProtocolBufferException {
        String macAddressStr = "\\320\\323\\340\\262@p";

        mac_address macAddress = mac_address.newBuilder().setAddr(ByteString.copyFromUtf8(macAddressStr)).build();

        byte[] macAddressByte = macAddress.toByteArray();

		mac_address response = catalogService.getMacAddress(macAddressByte);

		log.info(response.toString());

        Assertions.assertEquals(macAddress, response);
    }

}
