package com.example.recursos;

import com.example.recursos.model.Recurso;
import com.example.recursos.repository.RecursoRepository;
import com.example.recursos.service.RecursoService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class RecursoServiceTest {

    RecursoRepository repository = Mockito.mock(RecursoRepository.class);
    RecursoService service = new RecursoService(repository);

    @Test
    void asignarRecursoLoMarcaNoDisponible() {
        Recurso recurso = new Recurso(1L, "Pedro", "Dev","Alpha", true, null );
        when(repository.findById(1L)).thenReturn(Optional.of(recurso));
        when(repository.save(recurso)).thenReturn(recurso);

        Optional<Recurso> resultado = service.asignar(1L, 5L);

        assertTrue(resultado.isPresent());
        assertFalse(resultado.get().isDisponible());
        assertEquals(5L, resultado.get().getProyectoAsignadoId());
    }
    @Test
    void listarDisponibles(){
        when(repository.findByDisponibleTrue()).thenReturn(List.of(new Recurso()));
        assertEquals(1, service.listarDisponibles().size());
    }
}
