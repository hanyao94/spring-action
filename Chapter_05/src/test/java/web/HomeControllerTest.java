/**
 *
 * <p>
 * 项目名：	spring-action
 * 文件名：	HomeControllerTest.java
 * 模块说明：
 * 修改历史：
 * 2019/4/3 - seven - 创建。
 */
package web;

import com.seven.spring.action.web.HomeController;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

/**
 * @author seven
 */
public class HomeControllerTest {

  @Test
  public void testHomePage() throws Exception {
    HomeController controller = new HomeController();
    MockMvc mockMvc = standaloneSetup(controller).build();
    mockMvc.perform(get("/"))
            .andExpect(view().name("home"));
  }
}
