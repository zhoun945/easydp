import com.freedom.easydp.StartApplication;
import com.freedom.easydp.entity.Table;
import com.freedom.easydp.service.TableService;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * PACKAGE_NAME
 *
 * @author nan.zhou
 * @date 2018-09-14
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {StartApplication.class})
@SpringBootConfiguration
public class GeneratorTest {

  @Autowired
  private TableService tableService;

  @Test
  public void test() {
    List<Table> tableList = new ArrayList<>();
    Table table = new Table();
    table.setTableName("csl_account");
    table.setComment("账号信息");
    tableList.add(table);
    tableService.generate(1001L, 1001L, tableList);
  }

}
