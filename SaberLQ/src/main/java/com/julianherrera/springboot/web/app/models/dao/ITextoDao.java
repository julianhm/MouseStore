package com.julianherrera.springboot.web.app.models.dao;

import org.springframework.data.repository.PagingAndSortingRepository;


import com.julianherrera.springboot.web.app.models.entity.Texto;

public interface ITextoDao extends PagingAndSortingRepository<Texto, Long> {

}
