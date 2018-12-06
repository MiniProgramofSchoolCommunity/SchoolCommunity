package SchoolCommunity.SchoolCommunityBackendNew.mappers;

import SchoolCommunity.SchoolCommunityBackendNew.model.Manage;
import SchoolCommunity.SchoolCommunityBackendNew.model.ManageExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ManageMapper {
    long countByExample(ManageExample example);

    int deleteByExample(ManageExample example);

    int deleteByPrimaryKey(@Param("manageruserid") Long manageruserid, @Param("interviwee") Long interviwee);

    int insert(Manage record);

    int insertSelective(Manage record);

    List<Manage> selectByExample(ManageExample example);

    int updateByExampleSelective(@Param("record") Manage record, @Param("example") ManageExample example);

    int updateByExample(@Param("record") Manage record, @Param("example") ManageExample example);
}