package com.example.nace.service;

import com.example.nace.entity.Nace;
import com.example.nace.repository.NaceRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;


@Service
public class NaceService {

    private Logger logger = LoggerFactory.getLogger(NaceService.class);

    @Autowired
    private NaceRepository naceRepository;

    public long addNace(Nace nace) throws IllegalStateException{
        if (nace.getOrder_Number()>0) {
            naceRepository.save(nace);
            return nace.getOrder_Number();
        }
        else
        throw new IllegalStateException("OrderNumberNotValid");
    }
    
    public ArrayList<Nace> getAllNaces(){
            return (ArrayList<Nace>) naceRepository.findAll();
    }
}
