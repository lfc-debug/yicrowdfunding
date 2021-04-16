package com.yichou.mapper;

import com.yichou.entity.po.ProjectPO;
import com.yichou.entity.po.ProjectPOExample;
import java.util.List;

import com.yichou.entity.vo.DetailProjectVO;
import com.yichou.entity.vo.DetailReturnVO;
import com.yichou.entity.vo.PortalProjectVO;
import com.yichou.entity.vo.PortalTypeVO;
import org.apache.ibatis.annotations.Param;

public interface ProjectPOMapper {
    long countByExample(ProjectPOExample example);

    int deleteByExample(ProjectPOExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ProjectPO record);

    int insertSelective(ProjectPO record);

    List<ProjectPO> selectByExample(ProjectPOExample example);

    ProjectPO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ProjectPO record, @Param("example") ProjectPOExample example);

    int updateByExample(@Param("record") ProjectPO record, @Param("example") ProjectPOExample example);

    int updateByPrimaryKeySelective(ProjectPO record);

    int updateByPrimaryKey(ProjectPO record);

    void insertTypeRelationship(@Param("typeIdList")List<Integer> typeIdList, @Param("projectId")Integer projectId);

    void insertTagRelationship(@Param("tagIdList") List<Integer> tagIdList, @Param("projectId") Integer projectId);

    List<PortalTypeVO> selectPortalTypeVOList();

    List<PortalProjectVO> selectPortalProjectVOList(Integer id);

    List<String> selectDetailPicturePath(Integer id);

    List<DetailReturnVO> selectDeatailReturnVO(Integer id);

    DetailProjectVO selectDetailProjectVO(Integer id);
}