import java.util.Scanner;

public class Main {
    private static FilmRepository filmRepository = new FilmRepositoryImpl();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Adaugă film");
            System.out.println("2. Afișează toate filmele");
            System.out.println("3. Caută film după ID");
            System.out.println("4. Șterge film după ID");
            System.out.println("5. Ieșire");

            System.out.print("Alege o opțiune: ");
            int optiune = scanner.nextInt();
            scanner.nextLine();

            switch (optiune) {
                case 1:
                    adaugaFilm(scanner);
                    break;
                case 2:
                    afiseazaFilme();
                    break;
                case 3:
                    cautaFilm(scanner);
                    break;
                case 4:
                    stergeFilm(scanner);
                    break;
                case 5:
                    System.out.println("La revedere!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opțiune invalidă!");
                    break;
            }
        }
    }

    private static void adaugaFilm(Scanner scanner) {
        System.out.print("Introduceti ID-ul filmului: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Introduceti numele filmului: ");
        String nume = scanner.nextLine();
        System.out.print("Introduceti descrierea filmului: ");
        String descriere = scanner.nextLine();

        Film film = new Film(id, nume, descriere);
        filmRepository.save(film);
        System.out.println("Film adaugat cu succes!");
    }

    private static void afiseazaFilme() {
        System.out.println("Lista de filme:");
        filmRepository.findAll().forEach(film -> System.out.println(film.getId() + ". " + film.getNume() + " - " + film.getDescriere()));
    }

    private static void cautaFilm(Scanner scanner) {
        System.out.print("Introduceti ID-ul filmului: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Film film = filmRepository.findById(id);
        if (film != null) {
            System.out.println("Filmul cu ID-ul " + id + " este: " + film.getNume() + " - " + film.getDescriere());
        } else {
            System.out.println("Nu a fost găsit niciun film cu ID-ul " + id);
        }
    }

    private static void stergeFilm(Scanner scanner) {
        System.out.print("Introduceti ID-ul filmului de șters: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        filmRepository.delete(id);
        System.out.println("Film șters cu succes!");
    }
}
