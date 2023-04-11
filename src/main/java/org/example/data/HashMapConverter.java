package org.example.data;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.AttributeConverter;

import java.io.IOException;

public class HashMapConverter implements AttributeConverter<Address, String> {

    private static final ObjectMapper objectMapper = new ObjectMapper();
    @Override
    public String convertToDatabaseColumn(Address address) {


        String addressJson = null;
        try {
            addressJson = objectMapper.writeValueAsString(address);
        } catch (final JsonProcessingException e) {
            System.out.println("JSON writing error");
        }

        return addressJson;
    }

    @Override
    public Address convertToEntityAttribute(String addressJson) {

        Address address = null;
        try {
            address = objectMapper.readValue(addressJson, Address.class);
        } catch (final IOException e) {
            System.out.println("JSON reading error");
        }

        return address;
    }

}
