/**
 *
 * <p>
 * 项目名：	spring-action
 * 文件名：	ConcertTest.java
 * 模块说明：
 * 修改历史：
 * 2019/3/26 - seven - 创建。
 */
package aopxml;

import com.seven.spring.action.aopxml.CompactDisc;
import com.seven.spring.action.aopxml.ConcertConfig;
import com.seven.spring.action.aopxml.Encoreable;
import com.seven.spring.action.aopxml.Performance;
import com.seven.spring.action.aopxml.TrackCounter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import static org.junit.Assert.assertEquals;

/**
 * @author seven
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:aopxml.xml"})
public class ConcertTest {

  @Autowired
  Performance concert;

  @Test
  public void test() {
    concert.perform();
  }

  @ActiveProfiles("simple")
  public static class AudienceTest extends ConcertTest {

  }

  @ActiveProfiles("around")
  public static class AudienceAroundTest extends ConcertTest {

  }


  @RunWith(SpringJUnit4ClassRunner.class)
  @ContextConfiguration(locations = {"classpath:aopxml.xml"})
  @ActiveProfiles("aroundWidthParams")
  public static class CdaroundWidthParams {
    @Autowired
    private CompactDisc cd;

    @Autowired
    private TrackCounter counter;

    @Test
    public  void  testTrackcounter(){
      cd.playTrack(1);
      cd.playTrack(2);
      cd.playTrack(3);
      cd.playTrack(3);
      cd.playTrack(3);
      cd.playTrack(3);
      cd.playTrack(7);
      cd.playTrack(7);


      assertEquals(1, counter.getPlayCount(1));
      assertEquals(1, counter.getPlayCount(2));
      assertEquals(4, counter.getPlayCount(3));
      assertEquals(0, counter.getPlayCount(4));
      assertEquals(0, counter.getPlayCount(5));
      assertEquals(0, counter.getPlayCount(6));
      assertEquals(2, counter.getPlayCount(7));
    }
  }

  @ActiveProfiles("introduce")
  public static class EncoreableIntroducerTest extends ConcertTest {

    @Override
    public void test() {
      ((Encoreable)concert).performEncore();
    }
  }

}
