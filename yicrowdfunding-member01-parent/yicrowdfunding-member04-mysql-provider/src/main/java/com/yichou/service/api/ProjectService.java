package com.yichou.service.api;



import com.yichou.entity.vo.DetailProjectVO;
import com.yichou.entity.vo.PortalTypeVO;
import com.yichou.entity.vo.ProjectVO;

import java.util.List;

public interface ProjectService {
    void saveProject(ProjectVO projectVO, Integer memberId);
    List<PortalTypeVO> getPortalTypeVO();
    DetailProjectVO getDetailProjectVO(Integer projectId);
}
