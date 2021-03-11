package com.mafei.laboratory.system.service.impl;

import com.mafei.laboratory.system.entity.SysBorrowLaboratory;
import com.mafei.laboratory.system.entity.vo.BorrowLaboratoryVo;
import com.mafei.laboratory.system.repository.SysBorrowLaboratoryRepository;
import com.mafei.laboratory.system.repository.SysLaboratoryRepository;
import com.mafei.laboratory.system.service.SysBorrowLaboratoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

/**
 * 设备借用表(SysBorrowLaboratory)表服务实现类
 *
 * @author wts
 * @since 2021-03-07 08:48:26
 */
@Service
@Transactional
@RequiredArgsConstructor
public class SysBorrowLaboratoryServiceImpl implements SysBorrowLaboratoryService {
    private final SysBorrowLaboratoryRepository repository;
    private final SysLaboratoryRepository laboratoryRepository;
    private List<BorrowLaboratoryVo> list;

    @Override
    public List<BorrowLaboratoryVo> findAll() {
        List<SysBorrowLaboratory> all = repository.findAllByStatus();
        list = new ArrayList<>(all.size());
        for (SysBorrowLaboratory borrowInstrument : all) {
            BorrowLaboratoryVo vo = new BorrowLaboratoryVo();
            BeanUtils.copyProperties(borrowInstrument, vo);
            vo.setLaboratoryName(laboratoryRepository.getName(vo.getLaboratoryId()));
            list.add(vo);
        }
        return list;
    }

    @Override
    public List<BorrowLaboratoryVo> findAllByOther() {
        List<SysBorrowLaboratory> all = repository.findAll();
        list = new LinkedList<>();
        for (SysBorrowLaboratory borrowInstrument : all) {
            BorrowLaboratoryVo vo = new BorrowLaboratoryVo();
            BeanUtils.copyProperties(borrowInstrument, vo);
            vo.setLaboratoryName(laboratoryRepository.getName(vo.getLaboratoryId()));
            list.add(vo);
        }
        return list;
    }

    @Override
    public List<SysBorrowLaboratory> findAllByStatus(Set<Long> ids) {
        return null;
    }

    @Override
    public SysBorrowLaboratory queryById(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public void insert(BorrowLaboratoryVo borrowVo) {
        SysBorrowLaboratory borrowInstrument = new SysBorrowLaboratory();
        borrowInstrument.setUserId(borrowVo.getUserId());
        borrowInstrument.setLaboratoryId(borrowVo.getLaboratoryId());
        borrowInstrument.setStatus(borrowVo.getStatus());
        borrowInstrument.setBorrowStatus(borrowVo.getBorrowStatus());
        borrowInstrument.setComment(borrowVo.getComment());
        borrowInstrument.setCreateBy(borrowVo.getUserName());
        borrowInstrument.setCreateTime(borrowVo.getCreateTime());
        borrowInstrument.setUpdateTime(new Date());

        repository.save(borrowInstrument);
    }

    @Override
    public void updateBorrow(String status, Long id) {
        try {
            repository.updateBorrowStatus(id, status);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateCheck(String status, Long id) {
        try {
            repository.updateStatus(id, status);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
