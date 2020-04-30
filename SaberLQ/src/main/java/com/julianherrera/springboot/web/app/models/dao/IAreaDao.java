package com.julianherrera.springboot.web.app.models.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.julianherrera.springboot.web.app.models.entity.Area;

public interface IAreaDao extends PagingAndSortingRepository<Area, Long> {

}
