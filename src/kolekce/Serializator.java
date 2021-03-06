package kolekce;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Objects;

/**
 *
 * @author Tomáš Vondra
 */
public class Serializator {

    public static <T> void uloz(String soubor, DoubleList<T> kolekce) throws IOException {

        try {
            Objects.requireNonNull(kolekce);
            try (ObjectOutputStream vystup = new ObjectOutputStream(
                    new FileOutputStream(soubor))) {

                int pocet = kolekce.getMohutnost();
                vystup.writeInt(pocet);
                vystup.writeObject(kolekce.zpristupniPrvni());
                for (int i = 1; i < pocet; i++) {
                    vystup.writeObject(kolekce.zpristupniNaslednika());
                }

            }
        } catch (IOException | KolekceException ex) {
            
        } //Chyba

    }

    public static <T> DoubleList<T> nacti(String soubor, DoubleList<T> kolekce)
            throws IOException {

        try {
            Objects.requireNonNull(kolekce);
            try (ObjectInputStream vstup = new ObjectInputStream(
                    new FileInputStream(soubor))) {

                int pocet = vstup.readInt();
                for (int i = 0; i < pocet; i++) {
                    kolekce.vlozPosledni((T) vstup.readObject());
                }
                vstup.close();
            }
        } catch (IOException | ClassNotFoundException ex) {

        } //Chyba prázdný catch. Vyjímku bych měl odchytit až v gui
        return kolekce;
    }

}
