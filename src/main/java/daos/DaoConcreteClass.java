package daos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DaoConcreteClass implements BossDao {

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
        Boss resultBoss = new Boss();
            while (resultSet.next()) {
                resultBoss.setId(resultSet.getInt(1));
                resultBoss.setName(resultSet.getString(2));
                resultBoss.setLocation(resultSet.getString(3));
                resultBoss.setHp(resultSet.getInt(4));
                resultBoss.setWeakness(resultSet.getString(5));
                resultBoss.setResistances(resultSet.getString(6));
                resultBoss.setNumber_of_souls(resultSet.getInt(7));
            }
        return resultBoss;
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
            int i = preparedStatement.executeUpdate();

            if(i == 1) {
                return getBossByID(boss.getId());
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return null;
    }

    public Boss create(Boss boss) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO bosses VALUES (NULL, " +
                    "?, ?, ?, ?, ?)");
            preparedStatement.setString(1, boss.getName());
            preparedStatement.setString(2, boss.getLocation());
            preparedStatement.setInt(3, boss.getHp());
            preparedStatement.setString(4, boss.getWeakness());
            preparedStatement.setString(5, boss.getResistances());
            preparedStatement.setInt(6, boss.getNumber_of_souls());
            int i = preparedStatement.executeUpdate();

            if (i == 7) {
                return getBossByID(boss.getId());
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return null;
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
