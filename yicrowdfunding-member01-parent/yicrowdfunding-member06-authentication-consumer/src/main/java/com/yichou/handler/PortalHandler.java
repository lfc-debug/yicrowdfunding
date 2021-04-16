package com.yichou.handler;


import com.yichou.api.MySQLRemoteService;
import com.yichou.constant.CrowdConstant;
import com.yichou.entity.vo.PortalTypeVO;
import com.yichou.util.ResultEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class PortalHandler {

    @Autowired
    private MySQLRemoteService mySQLRemoteService;

    @RequestMapping("/")
    public String showPortalPage(Model model){
        ResultEntity<List<PortalTypeVO>> resultEntity = mySQLRemoteService.getPortalTypeProjectDataRemote();
        String result = resultEntity.getResult();
        if(ResultEntity.SUCCESS.equals(result)){
            List<PortalTypeVO> list = resultEntity.getData();
            model.addAttribute(CrowdConstant.ATTR_NAME_PORTAL_DATA, list);
        }
        return "portal";
    }

}
