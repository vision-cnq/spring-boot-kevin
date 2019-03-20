package com.kevin.service.impl;

import com.kevin.entity.Emps;
import com.kevin.mapper.EmpsMapper;
import com.kevin.service.EmpsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author kevin
 * @version 1.0
 * @description
 * @createDate 2019/3/20
 */
@Service
public class EmpsServiceImpl implements EmpsService {

    @Autowired
    private EmpsMapper empsMapper;

    @Override
    public List<Emps> selectEmps() {
        return empsMapper.selectEmps();
    }
}
