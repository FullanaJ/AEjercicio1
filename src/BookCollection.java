import java.util.*;

public class BookCollection {

    ArrayList<Book> libros;

    public BookCollection(ArrayList<Book> libros) {
        this.libros = libros;
    }

    public int ejercicio1() {
        //opcion 1
       /* int i = 0;

        for (Book libro : libros ) {
            if (libro.pages()>500)
                i++;
        }*/

        //opcion 2
        return libros.stream().mapToInt(Book::pages).sum();

    }

    public int ejercicio2() {
/*
        int i = 0;

        for (Book libro : libros) {
            if (libro.pages()<300)
                i++;
        }

        return i;
        */
        // version 2
        return (int) libros.stream().filter(o -> o.pages() < 300).count();
    }

    public void ejercicio3() {
        /*
        for (Book libro : libros) {
            if (libro.pages()>500)
                System.out.println(libro.title());
        }
        */
        //version2
        libros.stream().filter(o -> o.pages() > 500).map(Book::title).forEach(System.out::println);
    }

    public ArrayList<Book> ejercicio4() {

        ArrayList<Book> lib = new ArrayList<>();

        libros.sort((o1, o2) -> {
            return Integer.compare(o2.pages(), o1.pages());
        });

        lib.add(libros.get(0));
        lib.add(libros.get(1));
        lib.add(libros.get(2));

        return lib;

    }

    public int ejercicio5() {
    /*
        int i = 0;

        for (Book libro : libros ) {
            i += libro.pages();
        }

        return i;

     */
        return libros.stream().mapToInt(Book::pages).sum();
    }

    public ArrayList<Book> ejercicio6() {

        ArrayList<Book> lib = new ArrayList<>();
        int promedio = this.ejercicio1() / libros.size();
        /*
        for (Book libro : libros ) {
            if (libro.pages() > promedio)
                lib.add(libro);
        }
        return lib;
        */
        return new ArrayList<>(libros.stream().filter((o) -> o.pages() > promedio).toList());
    }

    public ArrayList<String> ejercicio7() {
        /*
        HashMap<String,String> map = new HashMap<>();

        for (Book libro : libros) {
            map.put(libro.author(),null);
        }

        return new ArrayList<>(map.keySet().stream().toList());

        */
        return new ArrayList<>((new HashSet<>(libros.stream().map(Book::author).toList())).stream().toList());
    }

    public ArrayList<String> ejercicio8() {

        HashMap<String, Integer> map = new HashMap<>();
        ArrayList<String> lista = new ArrayList<>();
        Integer numero;

        for (Book libro : libros) {
            // Version 2
            //map.put(libro.author(),map.getOrDefault(libro.author(),0));

            // Version 3
            map.merge(libro.author(), 1, Integer::sum);
            /*
            numero = map.get(libro.author());
            if (numero != null) {
                numero++;
                map.put(libro.author(),numero);
            }else
                map.put(libro.author(),1);*/
        }
        for (Map.Entry<String, Integer> entery : map.entrySet()) {
            if (entery.getValue() > 1)
                lista.add(entery.getKey());
        }
        return lista;
    }

    public Book ejercicio9() {

        /*libros.sort( (o1, o2) -> {

                if (o1.pages() < o2.pages())
                    return 1;
                if (o1.pages() > o2.pages())
                    return -1;
                return 0;
            });
        return libros.get(0);
         */
        return libros.stream().max(Comparator.comparingInt(Book::pages)).get();
    }

    public ArrayList<String> ejercicio10() {
        /*
        ArrayList<String> titulos = new ArrayList<>();
        for (Book libro: libros) {
            titulos.add(libro.title());
        }
        return titulos;

         */
        return new ArrayList<>(libros.stream().map(Book::title).toList());
    }

    public ArrayList<Book> ordenarAlfabeticamente() {

        Collections.sort(libros);
        return libros;
    }
}
