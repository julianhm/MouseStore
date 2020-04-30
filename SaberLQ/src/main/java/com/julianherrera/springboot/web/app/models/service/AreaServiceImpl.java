package com.julianherrera.springboot.web.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.julianherrera.springboot.web.app.models.dao.IAreaDao;
import com.julianherrera.springboot.web.app.models.entity.Area;

@Service
public class AreaServiceImpl implements IAreaService{

	@Autowired
	private IAreaDao areaDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Area> findAll() {
		// TODO Auto-generated method stub
		return (List<Area>) areaDao.findAll();
	}

	@Override
	@Transactional
	public void save(Area area) {
		areaDao.save(area);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Area findOne(Long id) {
		return areaDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		areaDao.deleteById(id);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Area> findAll(Pageable pageable) {
		
		return areaDao.findAll(pageable);
	}
}
