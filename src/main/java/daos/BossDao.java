package daos;

import java.util.List;

public interface BossDao {
    public Boss getBossByID(int id);
    public List findAllBosses();
    public Boss update(Boss boss);
    public Boss create(Boss boss);
    public void delete(int id);
}
