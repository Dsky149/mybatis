import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JdbcOracleTest {
    public static void main(String[] args) {
        //设置链接
        Connection connection = null;
        //预编译
        PreparedStatement preparedStatement = null;
        //返回结果集
        ResultSet resultSet = null;
        try {
            //congfig the driver
            Class.forName("oracle.jdbc.driver.OracleDriver");
            //connnection
            connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "oracle", "oracle");
            //edit the sql
            String sql = "select * from users";
            //prepare the sql
            preparedStatement = connection.prepareStatement(sql);
            //get the result
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String id = resultSet.getString("ID");
                System.out.println(id);
            }

        } catch (Exception e) {
            e.printStackTrace();
            try {
                resultSet.close();
                preparedStatement.close();
                connection.close();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    }
}
