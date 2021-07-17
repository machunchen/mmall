package com.chen.mmall003.service.impl;

import com.chen.mmall003.entity.User;
import com.chen.mmall003.mapper.UserMapper;
import com.chen.mmall003.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 建强
 * @since 2021-05-29
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
