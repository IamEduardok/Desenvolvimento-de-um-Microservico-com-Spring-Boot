package com.ecommerce.demo.controller;


import com.ecommerce.demo.controller.ProdutoController;
import com.ecommerce.demo.model.Produto;
import com.ecommerce.demo.service.ProdutoService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class DemoApplicationTests {

    @Mock
    private ProdutoService produtoService;

    @InjectMocks
    private ProdutoController produtoController;

    @Test
    void testListarTodos() {
        // Arrange
        Produto p1 = new Produto("Notebook", "Dell Inspiron", new BigDecimal("4500.00"), 10);
        Produto p2 = new Produto("Mouse", "Sem fio", new BigDecimal("120.00"), 50);
        when(produtoService.listarTodos()).thenReturn(Arrays.asList(p1, p2));

        // Act
        ResponseEntity<List<Produto>> resposta = produtoController.listarTodos();

        // Assert
        assertEquals(HttpStatus.OK, resposta.getStatusCode());
        assertEquals(2, resposta.getBody().size());
    }

    @Test
    void testBuscarPorIdExistente() {
        // Arrange
        Long id = 1L;
        Produto produto = new Produto("Teclado", "Mecânico", new BigDecimal("350.00"), 15);
        when(produtoService.buscarPorId(id)).thenReturn(produto);

        // Act
        ResponseEntity<Produto> resposta = produtoController.buscarPorId(id);

        // Assert
        assertEquals(HttpStatus.OK, resposta.getStatusCode());
        assertEquals("Teclado", resposta.getBody().getNome());
    }

    @Test
    void testBuscarPorIdInexistente() {
        // Arrange
        Long id = 99L;
        when(produtoService.buscarPorId(id)).thenReturn(null);

        // Act
        ResponseEntity<Produto> resposta = produtoController.buscarPorId(id);

        // Assert
        assertEquals(HttpStatus.NOT_FOUND, resposta.getStatusCode());
    }
}