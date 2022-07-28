package com.example.nace.service;



import com.example.nace.entity.Nace;
import com.example.nace.repository.NaceRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


@ExtendWith(SpringExtension.class)
public class NaceServiceTest{

@InjectMocks
    NaceService service;

@Mock
    NaceRepository repository;

@Test
   public  void addNaceWithInvalidOrderNo() {
    Nace nace = new Nace();
    nace.setOrder_Number(-1);
    IllegalStateException thrown = assertThrows(IllegalStateException.class, () -> service.addNace(nace));
    assertTrue(thrown.getMessage().contains("OrderNumberNotValid"));
}

@Test
public  void addNaceWithValidOrderNo() {
    Nace nace = new Nace();
    nace.setOrder_Number(1000);
    long oder= service.addNace(nace);
    assertEquals(1000, oder);
}

@Test
    public void getAllNacesTestReturnsValues() {
    Nace nace1 = new Nace();
    nace1.setOrder_Number(101245);
    Nace nace2= new Nace();
    nace2.setOrder_Number(2987654);
    ArrayList <Nace> naceList = new ArrayList <Nace> (){{
        add(nace1);
        add(nace2);}};
    when (service.getAllNaces()).thenReturn(naceList);
    assertNotNull(service.getAllNaces());
    assertEquals(2,service.getAllNaces().size());
}
}

