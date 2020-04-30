package com.julianherrera.springboot.web.app.models.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.julianherrera.springboot.web.app.models.entity.Imagen;


public interface IImagenDao extends PagingAndSortingRepository<Imagen, Long> {

}
