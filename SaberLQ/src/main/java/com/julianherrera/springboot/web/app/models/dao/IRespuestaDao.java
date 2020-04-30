package com.julianherrera.springboot.web.app.models.dao;

import org.springframework.data.repository.PagingAndSortingRepository;


import com.julianherrera.springboot.web.app.models.entity.Respuesta;

public interface IRespuestaDao extends PagingAndSortingRepository<Respuesta, Long> {

}
