package SchoolCommunity.SchoolCommunityBackendNew;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
public class UserControllerTest extends TestClass {

    @Autowired
    private MockMvc mockMvc;

//    String responseString = mockMvc.perform(
//            get("/categories/getAllCategory")    //请求的url,请求的方法是get
//                    .contentType(MediaType.APPLICATION_FORM_URLENCODED)  //数据的格式
//            　　　　　　　　　　　　　　 .param("pcode","root")         //添加参数
//        ).andExpect(status().isOk())    //返回的状态是200
//            .andDo(print())         //打印出请求和相应的内容
//            .andReturn().getResponse().getContentAsString();

    @Test
    public void loginTest() throws Exception {
        String responseString = mockMvc.perform(
                MockMvcRequestBuilders.post("/user/login.do")
                        .accept(MediaType.ALL)
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("username", "tyx")
                        .param("pwd", "123")
        )
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn()
                .getResponse()
                .getContentAsString();
        System.out.println(responseString);
    }

    @Test
    @Transactional
    @Rollback
    public void registerTest() throws Exception{
        String responseString = mockMvc.perform(
                MockMvcRequestBuilders.post("/user/register.do")
                        .accept(MediaType.ALL)
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("username", "tyx")
                        .param("pwd", "123")
                        .param("type","2")
                        .param("email","123")
        )
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn()
                .getResponse()
                .getContentAsString();
        System.out.println(responseString);
    }
}
