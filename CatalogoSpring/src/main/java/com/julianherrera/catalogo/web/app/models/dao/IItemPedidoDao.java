package com.julianherrera.catalogo.web.app.models.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.julianherrera.catalogo.web.app.models.entity.ItemPedido;


public interface IItemPedidoDao extends PagingAndSortingRepository<ItemPedido, Long> {

}
