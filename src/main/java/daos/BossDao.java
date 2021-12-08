package daos;

import java.util.List;

public interface BossDao {
    public Boss getBossByID(int id);
    public List findAllBosses();
    public Boss update(Boss dto);
    public Boss create(Boss dto);
    public void delete(int id);
}
