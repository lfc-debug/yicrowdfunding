package com.yichou.handler;


import com.yichou.api.MySQLRemoteService;
import com.yichou.constant.CrowdConstant;
import com.yichou.entity.vo.AddressVO;
import com.yichou.entity.vo.MemberLoginVO;
import com.yichou.entity.vo.OrderProjectVO;
import com.yichou.util.ResultEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class OrderHandler {

    @Autowired
    private MySQLRemoteService mySQLRemoteService;

    private Logger logger = LoggerFactory.getLogger(OrderHandler.class);

    @RequestMapping("/save/address")
    public String saveAddress(AddressVO addressVO, HttpSession session) {
        // 1.执行地址信息的保存
        ResultEntity<String> resultEntity = mySQLRemoteService.saveAddressRemote(addressVO);
        logger.debug("地址保存处理结果："+resultEntity.getResult());
        // 2.从Session域获取orderProjectVO对象
        OrderProjectVO orderProjectVO = (OrderProjectVO) session.getAttribute("orderProjectVO");
        // 3.从orderProjectVO对象中获取returnCount
        Integer returnCount = orderProjectVO.getReturnCount();
        // 4.重定向到指定地址，重新进入确认订单页面
        return "redirect:http://localhost/order/confirm/order/"+returnCount;
    }

    @RequestMapping("/confirm/order/{returnCount}")
    public String showConfirmOrderInfo(
            @PathVariable("returnCount") Integer returnCount,
            HttpSession session) {
        // 1.把接收到的回报数量合并到 Session 域
        OrderProjectVO orderProjectVO = (OrderProjectVO) session.getAttribute("orderProjectVO");
        orderProjectVO.setReturnCount(returnCount);
        session.setAttribute("orderProjectVO", orderProjectVO);
        // 2.获取当前已登录用户的 id
        MemberLoginVO memberLoginVO = (MemberLoginVO)
                session.getAttribute(CrowdConstant.ATTR_NAME_LOGIN_MEMBER);
        Integer memberId = memberLoginVO.getId();
        // 3.查询目前的收货地址数据
        ResultEntity<List<AddressVO>> resultEntity = mySQLRemoteService.getAddressVORemote(memberId);
        if(ResultEntity.SUCCESS.equals(resultEntity.getResult())) {
            List<AddressVO> list = resultEntity.getData();
            session.setAttribute("addressVOList", list);
        }
        return "confirm_order";
    }

    @RequestMapping("/confirm/return/info/{projectId}/{returnId}")
    public String showReturnConfirmInfo(
            @PathVariable("projectId") Integer projectId,
            @PathVariable("returnId") Integer returnId,
            HttpSession session) {
        ResultEntity<OrderProjectVO> resultEntity = mySQLRemoteService.getOrderProjectVORemote(projectId, returnId);
        if(ResultEntity.SUCCESS.equals(resultEntity.getResult())) {
            OrderProjectVO orderProjectVO = resultEntity.getData();
            // 为了能够在后续操作中保持orderProjectVO数据，存入Session域
            session.setAttribute(CrowdConstant.ATTR_NAME_ORDER_PROJECT, orderProjectVO);
        }
        return "confirm_return";
    }
}
