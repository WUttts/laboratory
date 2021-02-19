package com.mafei.laboratory.system.service.impl;

import com.mafei.laboratory.commons.exception.BadRequestException;
import com.mafei.laboratory.system.entity.SysUser;
import com.mafei.laboratory.system.entity.vo.LoginUserVo;
import com.mafei.laboratory.system.repository.SysUserRepository;
import com.mafei.laboratory.system.service.SysUserService;
import com.mafei.laboratory.system.service.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wutangsheng
 * @create 2021-02-18 14:13
 * @info
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements SysUserService {
    private final SysUserRepository userRepository;

    @Override
    public LoginUserVo queryByUsername(UserDto userDto) {
        SysUser user = userRepository.findByLoginName(userDto.getUsername());
        Long roleId = userRepository.queryRoleId(user.getUserId());
        if (null == user) {
            throw new BadRequestException("用户不存在");
        }
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
        return null;
    }

    @Override
    public List<SysUser> queryAllByLimit(int offset, int limit) {
        return null;
    }

    @Override
    public SysUser insert(SysUser sysUser) {
        return null;
    }

    @Override
    public SysUser update(SysUser sysUser) {
        return null;
    }

    @Override
    public boolean deleteById(Long userId) {
        return false;
    }
}
