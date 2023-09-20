import java.util.ArrayList;

public class App {

    public static void main(String[] args) {
        ArrayList<Book> libros = new ArrayList<>();

        libros.add(new Book("9788422616337", "El Señor de los Anillos", "J.R.R. Tolkien", 800));
        libros.add(new Book("9788445077528", "El Hobbit", "J.R.R. Tolkien", 350));
        libros.add(new Book("9788466316781", "Cabo Trafalgar", "Arturo Pérez Reverte", 320));
        libros.add(new Book("9788493975074", "El corazón de la piedra", "José María García López", 560));
        libros.add(new Book("9788493291488", "Salmos de vísperas", "Esteban Hernández Castelló", 95));
        libros.add(new Book("9788420685625", "La música en las catedrales españolas del Siglo de Oro", "Robert Stevenson", 600));
        libros.add(new Book("9788423913077", "Luces de bohemia", "Ramón del Valle-Inclán", 296));
        libros.add(new Book("9788448031121", "Contando atardeceres", "La vecina rubia", 528));
        libros.add(new Book("9781529342079", "The Master: The Brilliant Career of Roger Federer", "Christopher Clarey", 456));
        libros.add(new Book("9788408264385", "La teoría de los archipiélagos", "Alice Kellen", 300));
        libros.add(new Book("9788423362479", "Esperando al diluvio", "Dolores Redondo", 576));
        libros.add(new Book("9788466367349", "El italiano", "Arturo Pérez Reverte", 400));
        libros.add(new Book("9788466359290", "Línea de fuego", "Arturo Pérez Reverte", 688));

        BookCollection bc = new BookCollection(libros);

        System.out.println("Cantidad de libros con mas de 500 paginas: " + bc.ejercicio1());
        System.out.println("Cantidad de libros con menos de 300 paginas: " + bc.ejercicio2());
        System.out.println("Cantidad de titulos con mas de 500 paginas: ");
        bc.ejercicio3();
        recorreTitulos(bc.ejercicio4(), "Los 3 libros con mayor numero de paginas:");
        System.out.println("Suma total de la pagina de todos los libros: " + bc.ejercicio5());
        recorreTitulos(bc.ejercicio6(), "Libros que superan la media de pagina: ");
        recorre(bc.ejercicio7(), "Todos los autores: ");
        recorre(bc.ejercicio8(), "Autores con mas de un libro: ");
        System.out.println("libro con mayo numero de paginas: " + bc.ejercicio9().title());
        recorre(bc.ejercicio10(), "Todos los libros");
    }

    public static void recorreTitulos(ArrayList<Book> lista, String mensaje) {
        System.out.println(mensaje);
        //for (Book libro: lista) System.out.println(libro.title());
        lista.stream().map(Book::title).forEach(System.out::println);
    }

    public static void recorre(ArrayList<String> lista, String mensaje) {

        System.out.println(mensaje);
        lista.forEach(System.out::println);
    }
}

