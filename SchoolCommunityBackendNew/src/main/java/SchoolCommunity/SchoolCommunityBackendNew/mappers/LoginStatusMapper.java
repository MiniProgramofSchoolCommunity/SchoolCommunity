package SchoolCommunity.SchoolCommunityBackendNew.mappers;

import SchoolCommunity.SchoolCommunityBackendNew.model.LoginStatus;
import SchoolCommunity.SchoolCommunityBackendNew.model.LoginStatusExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface LoginStatusMapper {
    long countByExample(LoginStatusExample example);

    int deleteByExample(LoginStatusExample example);

    int deleteByPrimaryKey(String token);

    int insert(LoginStatus record);

    int insertSelective(LoginStatus record);

    List<LoginStatus> selectByExample(LoginStatusExample example);

    LoginStatus selectByPrimaryKey(String token);

    int updateByExampleSelective(@Param("record") LoginStatus record, @Param("example") LoginStatusExample example);

    int updateByExample(@Param("record") LoginStatus record, @Param("example") LoginStatusExample example);

    int updateByPrimaryKeySelective(LoginStatus record);

    int updateByPrimaryKey(LoginStatus record);
}