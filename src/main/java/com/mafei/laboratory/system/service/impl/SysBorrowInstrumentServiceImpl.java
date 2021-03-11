package com.mafei.laboratory.system.service.impl;

import com.mafei.laboratory.commons.enums.StatusEnum;
import com.mafei.laboratory.system.entity.SysBorrowInstrument;
import com.mafei.laboratory.system.entity.vo.BorrowInstrumentVo;
import com.mafei.laboratory.system.repository.SysBorrowInstrumentRepository;
import com.mafei.laboratory.system.repository.SysInstrumentRepository;
import com.mafei.laboratory.system.service.SysBorrowInstrumentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.*;

/**
 * 设备借用表(SysBorrowInstrument)表服务实现类
 *
 * @author makejava
 * @since 2021-03-10 08:48:25
 */
@Service
@Transactional
@RequiredArgsConstructor
public class SysBorrowInstrumentServiceImpl implements SysBorrowInstrumentService {
    private final SysBorrowInstrumentRepository repository;
    private final SysInstrumentRepository instrumentRepository;
    private List<BorrowInstrumentVo> list;

    @Override
    public List<BorrowInstrumentVo> findAll() {
        List<SysBorrowInstrument> all = repository.findAllByStatus();
        list = new ArrayList<>(all.size());
        for (SysBorrowInstrument borrowInstrument : all) {
            BorrowInstrumentVo vo = new BorrowInstrumentVo();
            BeanUtils.copyProperties(borrowInstrument, vo);
            vo.setInstrumentName(instrumentRepository.getName(vo.getInstrumentId()));
            list.add(vo);
        }
        return list;
    }

    @Override
    public List<BorrowInstrumentVo> findAllByOther() {
        List<SysBorrowInstrument> all = repository.findAll();
        list = new LinkedList<>();
        for (SysBorrowInstrument borrowInstrument : all) {
            BorrowInstrumentVo vo = new BorrowInstrumentVo();
            BeanUtils.copyProperties(borrowInstrument, vo);
            vo.setInstrumentName(instrumentRepository.getName(vo.getInstrumentId()));
            list.add(vo);
        }
        return list;
    }

    @Override
    public List<SysBorrowInstrument> findAllByStatus(Set<Long> ids) {
        return null;
    }

    @Override
    public SysBorrowInstrument queryById(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public void insert(BorrowInstrumentVo borrowVo) {
        SysBorrowInstrument borrowInstrument = new SysBorrowInstrument();
        borrowInstrument.setUserId(borrowVo.getUserId());
        borrowInstrument.setInstrumentId(borrowVo.getInstrumentId());
        borrowInstrument.setStatus(borrowVo.getStatus());
        borrowInstrument.setBorrowStatus(borrowVo.getBorrowStatus());
        borrowInstrument.setComment(borrowVo.getComment());
        borrowInstrument.setCreateBy(borrowVo.getUserName());
        borrowInstrument.setCreateTime(borrowVo.getCreateTime());
        borrowInstrument.setUpdateTime(new Date());

        repository.save(borrowInstrument);
        instrumentRepository.updateStatus(borrowVo.getInstrumentId(), StatusEnum.BORROW.getStatus());
    }

    @Override
    public void updateBorrow(String status, Long id) {
        try {
            repository.updateBorrowStatus(id, status);
            Long instrumentId = queryById(id).getInstrumentId();
            instrumentRepository.updateStatus(instrumentId, StatusEnum.NORMAL.getStatus());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateCheck(String status, Long id) {
        try {
            repository.updateStatus(id, status);
            Long instrumentId = queryById(id).getInstrumentId();
            instrumentRepository.updateStatus(instrumentId, StatusEnum.NORMAL.getStatus());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
