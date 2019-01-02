package com.vinod.recipeapp.repository;

import com.vinod.recipeapp.domain.UnitOfMeasure;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UnitOfMeasureRepositoryIT {

    @Autowired
    private UnitOfMeasureRepository unitOfMeasureRepository;


    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void findByName() {
        Optional<UnitOfMeasure> unitOfMeasureOptional = unitOfMeasureRepository.findByName("Gram");
        assertEquals("Gram",unitOfMeasureOptional.get().getName());

    }

    @Test
    public void findByNameLiter() {
        Optional<UnitOfMeasure> unitOfMeasureOptional = unitOfMeasureRepository.findByName("Liter");
        assertEquals("Liter",unitOfMeasureOptional.get().getName());

    }
}