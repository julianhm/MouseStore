package com.julianherrera.springboot.web.app.models.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.julianherrera.springboot.web.app.models.entity.Pregunta;

public interface IPreguntaDao extends PagingAndSortingRepository<Pregunta, Long> {

}
