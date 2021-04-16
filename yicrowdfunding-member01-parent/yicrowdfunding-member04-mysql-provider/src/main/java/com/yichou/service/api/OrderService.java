package com.yichou.service.api;



import com.yichou.entity.vo.AddressVO;
import com.yichou.entity.vo.OrderProjectVO;
import com.yichou.entity.vo.OrderVO;

import java.util.List;

public interface OrderService {
    public OrderProjectVO getOrderProjectVO(Integer projectId, Integer returnId);
    List<AddressVO> getAddressVOList(Integer memberId);
    void saveAddress(AddressVO addressVO);
    void saveOrder(OrderVO orderVO);
}
