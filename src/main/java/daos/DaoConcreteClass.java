package daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DaoConcreteClass implements BossDao {
    Boss boss;
    Connection connection = ConnectionFactory.getConnection();

    public Boss getBossByID(final int id) {
        try{
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM bosses WHERE id=" + id);

            if(resultSet.next()) {
                return bossFromResultSet(resultSet);
            }

        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return null;
    }

    private Boss bossFromResultSet(ResultSet resultSet) throws SQLException {
        Boss boss = new Boss();

            while (resultSet.next()) {
                boss.setId(resultSet.getInt(1));
                boss.setName(resultSet.getString(2));
                boss.setLocation(resultSet.getString(3));
                boss.setHp(resultSet.getInt(4));
                boss.setWeakness(resultSet.getString(5));
                boss.setResistances(resultSet.getString(6));
                boss.setNumber_of_souls(resultSet.getInt(7));
            }
        return boss;
    }


    public List<Boss> findAllBosses() {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM bosses;");
            List<Boss> bosses = new ArrayList<>();
            while (resultSet.next()) {
                Boss boss = bossFromResultSet(resultSet);
                bosses.add(boss);
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return null;
    }

    public Boss update(Boss dto) {
        return null;
    }

    public Boss create(Boss dto) {
        return null;
    }

    public void delete(int id) {

    }
}
