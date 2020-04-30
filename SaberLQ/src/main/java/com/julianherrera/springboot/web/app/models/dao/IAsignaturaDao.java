package com.julianherrera.springboot.web.app.models.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.julianherrera.springboot.web.app.models.entity.Asignatura;

public interface IAsignaturaDao extends PagingAndSortingRepository<Asignatura, Long> {

}
