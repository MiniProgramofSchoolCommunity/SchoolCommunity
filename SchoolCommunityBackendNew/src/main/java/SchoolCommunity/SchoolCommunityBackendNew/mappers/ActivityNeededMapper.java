package SchoolCommunity.SchoolCommunityBackendNew.mappers;

import SchoolCommunity.SchoolCommunityBackendNew.model.ActivityNeeded;
import SchoolCommunity.SchoolCommunityBackendNew.model.ActivityNeededExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ActivityNeededMapper {
    long countByExample(ActivityNeededExample example);

    int deleteByExample(ActivityNeededExample example);

    int deleteByPrimaryKey(Long activityid);

    int insert(ActivityNeeded record);

    int insertSelective(ActivityNeeded record);

    List<ActivityNeeded> selectByExample(ActivityNeededExample example);

    ActivityNeeded selectByPrimaryKey(Long activityid);

    int updateByExampleSelective(@Param("record") ActivityNeeded record, @Param("example") ActivityNeededExample example);

    int updateByExample(@Param("record") ActivityNeeded record, @Param("example") ActivityNeededExample example);

    int updateByPrimaryKeySelective(ActivityNeeded record);

    int updateByPrimaryKey(ActivityNeeded record);
}