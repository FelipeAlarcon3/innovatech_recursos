package com.example.recursos;

import static org.junit.jupiter.api.Assertions.*;

import com.example.recursos.model.Recurso;
import com.example.recursos.repository.RecursoRepository;
import com.example.recursos.service.RecursoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RecursosApplicationTests {

    @Autowired
    private RecursoRepository recursoRepository;

    @Autowired
    private RecursoService recursoService;

    @Test
    void contextLoads() {

    }

    @Test
    void testGuardarYBuscarRecurso_FlujoReal() {

        Recurso recurso = new Recurso();
        recurso.setNombre("Felipe Alarcon");
        recurso.setRol("Desarrollador");
        recurso.setDisponible(true);


        Recurso recursoGuardado = recursoRepository.save(recurso);


        var idGenerado = recursoGuardado.getId();


        Recurso resultado = recursoService.buscarPorId(String.valueOf(idGenerado)).orElse(null);


        assertNotNull(resultado);
        assertEquals("Felipe Alarcon", resultado.getNombre());
    }
}