package com.neusoft.neu23.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.neusoft.neu23.entity.Guest;
import com.neusoft.neu23.mapper.GuestMapper;
import com.neusoft.neu23.service.GuestService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuestSeriveImpl extends ServiceImpl<GuestMapper, Guest> implements GuestService {
    @Override
    public Integer addGuest(Guest guest) {
        guest.setGid(null);  // 设置id为null，可以启动数据库的自动递增列功能
        int  i =  baseMapper.insert(guest);
        if(i>0)
            return guest.getGid(); // 返回插入自动递增列的id值
        return -1;
    }

    @Override
    public List<Guest> listByLastName(String lastName) {
        LambdaQueryWrapper<Guest> wrapper = new LambdaQueryWrapper<>();
        wrapper.likeRight(Guest::getName, lastName);
        return baseMapper.selectList(wrapper);
    }
}
