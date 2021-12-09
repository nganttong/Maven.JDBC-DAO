package daos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DaoConcreteClass implements BossDao {

    Connection connection = ConnectionFactory.getConnection();

    public Boss getBossByID(int id) {
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
        return new Boss(
                resultSet.getInt(1),
                resultSet.getString(2),
                resultSet.getString(3),
                resultSet.getInt(4),
                resultSet.getString(5),
                resultSet.getString(6),
                resultSet.getInt(7));

    }


    public List<Boss> findAllBosses() {
        List<Boss> bosses = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM bosses;");

            while (resultSet.next()) {
                Boss boss = bossFromResultSet(resultSet);
                bosses.add(boss);
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return bosses;
    }

    public Boss update(Boss boss) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE bosses SET" +
                    " name=?, location=?, hp=?, weakness=?, resistances=?, number_of_souls=? WHERE id=?");
            preparedStatement.setString(1, boss.getName());
            preparedStatement.setString(2, boss.getLocation());
            preparedStatement.setInt(3, boss.getHp());
            preparedStatement.setString(4, boss.getWeakness());
            preparedStatement.setString(5, boss.getResistances());
            preparedStatement.setInt(6, boss.getNumber_of_souls());
            preparedStatement.setInt(7,boss.getId());
            int i = preparedStatement.executeUpdate();

            if(i == 1) {
                return getBossByID(boss.getId());
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return boss;
    }

    public Boss create(Boss boss) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO bosses VALUES (DEFAULT, ?, " +
                    "?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, boss.getName());
            preparedStatement.setString(2, boss.getLocation());
            preparedStatement.setInt(3, boss.getHp());
            preparedStatement.setString(4, boss.getWeakness());
            preparedStatement.setString(5, boss.getResistances());
            preparedStatement.setInt(6, boss.getNumber_of_souls());
            int i = preparedStatement.executeUpdate();

            if (i == 1) {

                ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
                if(generatedKeys.next()) {
                    return getBossByID(generatedKeys.getInt(1));
                }
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return boss;
    }

    public void delete(int id) {
        try {
            Statement statement = connection.createStatement();
            int i = statement.executeUpdate("DELETE FROM bosses WHERE id=" + id);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }

    }
}
