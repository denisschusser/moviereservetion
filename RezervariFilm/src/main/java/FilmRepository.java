import java.util.List;

public interface FilmRepository {
    List<Film> findAll();
    Film findById(int id);
    void save(Film film);
    void delete(int id);
}
