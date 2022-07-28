package com.example.nace.resource;

import com.example.nace.entity.Nace;
import com.example.nace.service.NaceService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;

import static org.mockito.ArgumentMatchers.any;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
public class NaceResourceTest {

    @InjectMocks
    NaceResource resource;

    @Mock
    NaceService service;

    @Test
    public void testAddNace(){
        when(service.addNace(any(Nace.class))).thenReturn(1L);
        Nace nace = new Nace();
        nace.setOrder_Number(1);
        ResponseEntity<String> entity = resource.addProduct(nace);
        assertEquals(entity.getStatusCodeValue(), 201);
        assertEquals(entity.getBody(), "Created :1");
    }


    @Test
    public void testGetAllNaces(){

        Nace nace1 = new Nace();
        nace1.setOrder_Number(1);
        Nace nace2 = new Nace();
        nace2.setOrder_Number(2);
        ArrayList<Nace> naceList = new ArrayList <Nace> (){{
            add(nace1);
            add(nace2);}};

        when(service.getAllNaces()).thenReturn(naceList);
        ResponseEntity <ArrayList<Nace>> entity = resource.getAllProducts();
        assertEquals(entity.getStatusCode(),  HttpStatus.OK);
        assertEquals(entity.getBody().size(), 2);
    }


}
