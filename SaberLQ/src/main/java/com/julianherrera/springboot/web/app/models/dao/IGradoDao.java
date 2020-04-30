package com.julianherrera.springboot.web.app.models.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.julianherrera.springboot.web.app.models.entity.Grado;

public interface IGradoDao extends PagingAndSortingRepository<Grado, Long> {

}
