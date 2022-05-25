import java.math.BigDecimal;
import java.util.List;

public class Person {
    private List<String> characterTraits;
    private Types type;
    private BigDecimal jaccard;
    private BigDecimal cosinus;

    public Person(List<String> characterTraits) {
        this.characterTraits = characterTraits;
    }

    public List<String> getCharacterTraits() {
        return characterTraits;
    }

    public void setCharacterTraits(List<String> characterTraits) {
        this.characterTraits = characterTraits;
    }

    public Types getType() {
        return type;
    }

    public void setType(Types type) {
        this.type = type;
    }

    public BigDecimal getJaccard() {
        return jaccard;
    }

    public void setJaccard(BigDecimal jaccard) {
        this.jaccard = jaccard;
    }

    public BigDecimal getCosinus() {
        return cosinus;
    }

    public void setCosinus(BigDecimal cosinus) {
        this.cosinus = cosinus;
    }
}
