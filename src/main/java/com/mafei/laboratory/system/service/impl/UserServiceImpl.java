package com.mafei.laboratory.system.service.impl;

import com.mafei.laboratory.commons.exception.BadRequestException;
import com.mafei.laboratory.system.entity.SysUser;
import com.mafei.laboratory.system.entity.vo.LoginUserVo;
import com.mafei.laboratory.system.entity.vo.UserVo;
import com.mafei.laboratory.system.repository.SysUserRepository;
import com.mafei.laboratory.system.service.SysUserService;
import com.mafei.laboratory.system.service.dto.LoginDto;
import com.mafei.laboratory.system.service.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author wutangsheng
 * @create 2021-02-18 14:13
 * @info
 */
@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements SysUserService {
    private final SysUserRepository userRepository;

    @Override
    public LoginUserVo queryByUsername(LoginDto userDto) {
        SysUser user = userRepository.findByLoginName(userDto.getUsername());
        if (user == null) {
            throw new BadRequestException("用户不存在");
        }

        Long roleId = userRepository.queryRoleId(user.getUserId());
        if (!user.getPassword().equals(userDto.getPassword())) {
            throw new BadRequestException("用户名或密码错误");
        }

        LoginUserVo loginUserVo = new LoginUserVo();

        //复制类
        BeanUtils.copyProperties(user, loginUserVo);
        loginUserVo.setRoleId(roleId);
        return loginUserVo;
    }

    @Override
    public SysUser queryById(Long userId) {
        return userRepository.findByUserId(userId);
    }

    @Override
    public List<SysUser> queryAllByLimit(int offset, int limit) {
        return null;
    }

    @Override
    public void insert(UserDto userDto) {
        SysUser user = new SysUser();
        BeanUtils.copyProperties(userDto, user);

        userRepository.save(user);

    }

    @Override
    public void update(UserDto userDto) {
        SysUser user = userRepository.findByUserId(userDto.getUserId());
        try {
            user.setUserName(userDto.getUserName());
            user.setEmail(userDto.getEmail());
            user.setPhonenumber(userDto.getPhonenumber());
            user.setSex(userDto.getSex());
            user.setStatus(userDto.getStatus());
            userRepository.save(user);
        } catch (BadRequestException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateStatus(String status, Set<Long> ids) {
        try {
            List<SysUser> list = userRepository.queryByIds(ids);
            for (SysUser user : list) {
                user.setStatus(status);
            }
            userRepository.saveAll(list);
        } catch (BadRequestException e) {
            e.printStackTrace();
        }

    }

    @Override
    public boolean deleteById(Long userId) {
        SysUser user = userRepository.deleteByUserId(userId);
        return user == null;
    }

    @Override
    public void deleteByIds(Set<Long> userId) {
        try {
            userRepository.deleteByUserIds(userId);
        } catch (BadRequestException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<UserVo> queryAll() {
        List<SysUser> list = userRepository.findAll();
        List<UserVo> userVoList = new ArrayList<>(list.size());
        for (SysUser user : list) {
            UserVo userVo = new UserVo();
            BeanUtils.copyProperties(user, userVo);
            if ("0".equals(user.getSex())) {
                userVo.setSex("男");
            } else if ("1".equals(user.getSex())) {
                userVo.setSex("女");
            } else {
                userVo.setSex("未知");
            }

            if ("0".equals(user.getStatus())) {
                userVo.setStatus("正常");
            } else {
                userVo.setStatus("停用");
            }

            userVoList.add(userVo);
        }
        return userVoList;
    }
}
