package SchoolCommunity.SchoolCommunityBackendNew.mappers;

import SchoolCommunity.SchoolCommunityBackendNew.model.Corporation;
import SchoolCommunity.SchoolCommunityBackendNew.model.CorporationExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface CorporationMapper {
    long countByExample(CorporationExample example);

    int deleteByExample(CorporationExample example);

    int deleteByPrimaryKey(Long userid);

    int insert(Corporation record);

    int insertSelective(Corporation record);

    List<Corporation> selectByExample(CorporationExample example);

    Corporation selectByPrimaryKey(Long userid);

    int updateByExampleSelective(@Param("record") Corporation record, @Param("example") CorporationExample example);

    int updateByExample(@Param("record") Corporation record, @Param("example") CorporationExample example);

    int updateByPrimaryKeySelective(Corporation record);

    int updateByPrimaryKey(Corporation record);
}