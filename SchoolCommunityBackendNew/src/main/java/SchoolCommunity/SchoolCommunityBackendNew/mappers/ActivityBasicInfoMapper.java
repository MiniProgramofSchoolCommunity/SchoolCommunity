package SchoolCommunity.SchoolCommunityBackendNew.mappers;

import SchoolCommunity.SchoolCommunityBackendNew.model.ActivityBasicInfo;
import SchoolCommunity.SchoolCommunityBackendNew.model.ActivityBasicInfoExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ActivityBasicInfoMapper {
    long countByExample(ActivityBasicInfoExample example);

    int deleteByExample(ActivityBasicInfoExample example);

    int deleteByPrimaryKey(Long activityid);

    int insert(ActivityBasicInfo record);

    int insertSelective(ActivityBasicInfo record);

    List<ActivityBasicInfo> selectByExample(ActivityBasicInfoExample example);

    ActivityBasicInfo selectByPrimaryKey(Long activityid);

    int updateByExampleSelective(@Param("record") ActivityBasicInfo record, @Param("example") ActivityBasicInfoExample example);

    int updateByExample(@Param("record") ActivityBasicInfo record, @Param("example") ActivityBasicInfoExample example);

    int updateByPrimaryKeySelective(ActivityBasicInfo record);

    int updateByPrimaryKey(ActivityBasicInfo record);
}