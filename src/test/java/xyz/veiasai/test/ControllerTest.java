package xyz.veiasai.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import xyz.veiasai.controller.RegisterController;
import xyz.veiasai.service.UserDaoService;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {
        //"/springmvc-config.xml" // 这里加载你用到的配置xml文件就可以了，可以配置多个
})
public class ControllerTest {

    private MockMvc mockMvc;

    @Mock
    private UserDaoService mediaService;

    @InjectMocks
    RegisterController mediaController;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(mediaController).build();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void index() throws Exception {
        // 构造一个查询条件


        // String json = JsonHelper.serialize(mediaSearchModel);
        // mock一个返回值
        /*List<AdvertiserAndMediaStatViewModel> mockResult = new Page<>();
        AdvertiserAndMediaStatViewModel mockModel = new AdvertiserAndMediaStatViewModel();
        mockModel.setTask_count(999L);
        mockResult.add(mockModel);
        // mock 方法返回值
        when(mediaService.getAdvertiserAndMediaStatList(mediaSearchModel)).thenReturn(mockResult);
        // 模拟一个post请求，把参数传递进去
        this.mockMvc.perform(
                (
                        post("/media/adv-media-stat-list-pager")
                                .contentType(MediaType.APPLICATION_JSON)
                                .param("start", "0")
                                .param("length", "10")
                                .flashAttr("searchModel", mediaSearchModel)// 在这里踩坑了，见下面描述
                ) ).andExpect(status().isOk()).andDo(print());

// 验证方法是否被调用1次；
        verify(mediaService, times(1)).getAdvertiserAndMediaStatList(mediaSearchModel); }*/
    }
}