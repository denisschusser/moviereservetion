import java.util.ArrayList;
import java.util.List;

public class FilmRepositoryImpl implements FilmRepository {
    private List<Film> filme = new ArrayList<>();

    @Override
    public List<Film> findAll() {
        return new ArrayList<>(filme);
    }

    @Override
    public Film findById(int id) {
        for (Film film : filme) {
            if (film.getId() == id) {
                return film;
            }
        }
        return null;
    }

    @Override
    public void save(Film film) {
        filme.add(film);
    }

    @Override
    public void delete(int id) {
        filme.removeIf(film -> film.getId() == id);
    }
}
