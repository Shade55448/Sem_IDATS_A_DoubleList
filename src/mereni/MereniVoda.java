
package mereni;

import java.time.LocalDateTime;

/**
 *
 * @author Tomáš Vondra
 */
public class MereniVoda extends Mereni {
    
    private double spotrebaM3;

    public double getSpotrebaM3() {
        return spotrebaM3;
    }

    public void setSpotrebaM3(double spotrebaM3) {
        this.spotrebaM3 = spotrebaM3;
    }

    public MereniVoda(double spotreba, int idSenzor, LocalDateTime casMereni) {
        super(idSenzor, TypSenzoruEnum.VODA, casMereni);
        this.spotrebaM3 = spotreba;
    }

    @Override
    public String toString() {
        return super.toString() + " [Spotřeba: " + spotrebaM3 + "m3]";
    }
    

}
