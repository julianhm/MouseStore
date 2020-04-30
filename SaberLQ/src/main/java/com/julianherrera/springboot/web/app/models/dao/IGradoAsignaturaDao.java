package com.julianherrera.springboot.web.app.models.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.julianherrera.springboot.web.app.models.entity.GradoAsignatura;

public interface IGradoAsignaturaDao extends PagingAndSortingRepository<GradoAsignatura, Long> {

}
