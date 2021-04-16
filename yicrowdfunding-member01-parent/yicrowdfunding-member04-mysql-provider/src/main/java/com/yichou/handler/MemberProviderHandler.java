package com.yichou.handler;


import com.yichou.entity.po.MemberPO;
import com.yichou.service.api.MemberService;
import com.yichou.util.ResultEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MemberProviderHandler {

    @Autowired
    private MemberService memberService;

    @RequestMapping("/save/member/remote")
    public ResultEntity<String> saveMemberRemote(@RequestBody MemberPO memberPO){
        try {
            memberService.saveMember(memberPO);
            return ResultEntity.successWithoutData();
        } catch (Exception e){
            return ResultEntity.failed(e.getMessage());
        }
    }

    @RequestMapping("/get/member/selective/remote")
    public ResultEntity<List<MemberPO>> getMemberSelectiveRemote(@RequestBody MemberPO memberPO){
        try{
            List<MemberPO> list = memberService.getMemberSelective(memberPO);
            return ResultEntity.successWithData(list);
        } catch (Exception e){
            return ResultEntity.failed(e.getMessage());
        }
    }

}
