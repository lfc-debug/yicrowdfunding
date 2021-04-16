package com.yichou.service.impl;


import com.yichou.entity.po.MemberPO;
import com.yichou.entity.po.MemberPOExample;
import com.yichou.mapper.MemberPOMapper;
import com.yichou.service.api.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberPOMapper memberPOMapper;

    @Override
    public List<MemberPO> getMemberSelective(MemberPO memberPO) {
        MemberPOExample example = new MemberPOExample();
        MemberPOExample.Criteria criteria = example.createCriteria();
        if(memberPO.getLoginacct()!=null) {
            criteria.andLoginacctEqualTo(memberPO.getLoginacct());
        }
        if(memberPO.getUsername()!=null){
            criteria.andUsernameEqualTo(memberPO.getUsername());
        }
        if(memberPO.getUserpswd()!=null){
            criteria.andUserpswdEqualTo(memberPO.getUserpswd());
        }
        if(memberPO.getEmail()!=null){
            criteria.andEmailEqualTo(memberPO.getEmail());
        }
        return memberPOMapper.selectByExample(example);
    }

    @Override
    @Transactional(
            propagation = Propagation.REQUIRES_NEW,
            rollbackFor = Exception.class,
            readOnly = false)
    public void saveMember(MemberPO memberPO) {
        memberPOMapper.insertSelective(memberPO);
    }
}
