package com.ecommerce.demo.controller;

import com.ecommerce.demo.model.Produto;
import com.ecommerce.demo.service.ProdutoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ProdutoControllerTest {

    @Mock
    private ProdutoService produtoService;

    @InjectMocks
    private ProdutoController produtoController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void listarTodos_DeveRetornarListaDeProdutos() {
        // Arrange
        Produto produto = new Produto("Produto Teste", "Descrição", BigDecimal.TEN, 10);
        when(produtoService.listarTodos()).thenReturn(Collections.singletonList(produto));

        // Act
        ResponseEntity<List<Produto>> resposta = produtoController.listarTodos();

        // Assert
        assertEquals(HttpStatus.OK, resposta.getStatusCode());
        assertFalse(resposta.getBody().isEmpty());
        assertEquals(1, resposta.getBody().size());
        verify(produtoService, times(1)).listarTodos();
    }

    @Test
    void buscarPorId_QuandoExistir_DeveRetornarProduto() {
        // Arrange
        Long id = 1L;
        Produto produto = new Produto("Produto Teste", "Descrição", BigDecimal.TEN, 10);
        when(produtoService.buscarPorId(id)).thenReturn(produto);

        // Act
        ResponseEntity<Produto> resposta = produtoController.buscarPorId(id);

        // Assert
        assertEquals(HttpStatus.OK, resposta.getStatusCode());
        assertNotNull(resposta.getBody());
        verify(produtoService, times(1)).buscarPorId(id);
    }

    @Test
    void buscarPorId_QuandoNaoExistir_DeveRetornarNotFound() {
        // Arrange
        Long id = 99L;
        when(produtoService.buscarPorId(id)).thenReturn(null);

        // Act
        ResponseEntity<Produto> resposta = produtoController.buscarPorId(id);

        // Assert
        assertEquals(HttpStatus.NOT_FOUND, resposta.getStatusCode());
        verify(produtoService, times(1)).buscarPorId(id);
    }
}