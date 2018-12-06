package SchoolCommunity.SchoolCommunityBackendNew.mappers;

import SchoolCommunity.SchoolCommunityBackendNew.model.Requirement;
import SchoolCommunity.SchoolCommunityBackendNew.model.RequirementExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface RequirementMapper {
    long countByExample(RequirementExample example);

    int deleteByExample(RequirementExample example);

    int deleteByPrimaryKey(Long activityid);

    int insert(Requirement record);

    int insertSelective(Requirement record);

    List<Requirement> selectByExample(RequirementExample example);

    Requirement selectByPrimaryKey(Long activityid);

    int updateByExampleSelective(@Param("record") Requirement record, @Param("example") RequirementExample example);

    int updateByExample(@Param("record") Requirement record, @Param("example") RequirementExample example);

    int updateByPrimaryKeySelective(Requirement record);

    int updateByPrimaryKey(Requirement record);
}