package com.example.nace.repository;


import com.example.nace.entity.Nace;
import org.springframework.data.repository.CrudRepository;
import javax.transaction.Transactional;


@Transactional
public interface NaceRepository extends  CrudRepository<Nace,Long>{

}
