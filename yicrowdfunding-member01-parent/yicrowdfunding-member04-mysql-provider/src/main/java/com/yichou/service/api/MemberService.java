package com.yichou.service.api;



import com.yichou.entity.po.MemberPO;

import java.util.List;

public interface MemberService {

    public List<MemberPO> getMemberSelective(MemberPO memberPO);

    public void saveMember(MemberPO memberPO);
}
