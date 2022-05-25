import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.List;
import java.util.TreeSet;

public class Algorithm {
    public static void getCharacterType(Person person) {
        Algorithm alg = new Algorithm();
        HashMap<Types, BigDecimal> coefficientsJ = new HashMap<>();
        HashMap<Types, BigDecimal> coefficientsC = new HashMap<>();
        coefficientsJ.put(Types.CHOLERIC, alg.getJaccardCoef(Types.CHOLERIC, person.getCharacterTraits()));
        coefficientsC.put(Types.CHOLERIC, alg.getCosCoef(Types.CHOLERIC, person.getCharacterTraits()));

        coefficientsJ.put(Types.MELANCHOLIC, alg.getJaccardCoef(Types.MELANCHOLIC, person.getCharacterTraits()));
        coefficientsC.put(Types.MELANCHOLIC, alg.getCosCoef(Types.MELANCHOLIC, person.getCharacterTraits()));

        coefficientsJ.put(Types.PHLEGMATIC, alg.getJaccardCoef(Types.PHLEGMATIC, person.getCharacterTraits()));
        coefficientsC.put(Types.PHLEGMATIC, alg.getCosCoef(Types.PHLEGMATIC, person.getCharacterTraits()));

        coefficientsJ.put(Types.SANGUINE, alg.getJaccardCoef(Types.SANGUINE, person.getCharacterTraits()));
        coefficientsC.put(Types.SANGUINE, alg.getCosCoef(Types.SANGUINE, person.getCharacterTraits()));


    }

    private BigDecimal getCosCoef(Types type, List<String> list){
        int[] arrayType = new int[type.traits.size()];
        int[] arrayPerson = new int[type.traits.size()];
        for (int i=0; i<type.traits.size(); i++){
            arrayType[i]=1;
        }
        int pers=0;
        for (int i=0; i<type.traits.size(); i++){
            if (list.contains(type.traits.get(i))){
                arrayPerson[i]=1;
                pers++;
            } else {
                arrayPerson[i]=0;
            }
        }

        int sum=0;
        int sumT=0;
        int sumP=0;
        for (int i=0; i<type.traits.size(); i++){
            sum= sum +(arrayType[i]*arrayPerson[i]);
            sumP=sumP+(arrayPerson[i]*arrayPerson[i]);
            sumT=sumT+(arrayType[i]*arrayType[i]);
        }
        BigDecimal coef = BigDecimal.valueOf(sum).divide(BigDecimal.valueOf(Math.sqrt(sumP)*Math.sqrt(sumT)), 2, RoundingMode.HALF_UP);
        System.out.println("Совпало "+pers+" черт характера человека из "+ type.traits.size() + " черт характера в этом психотипе" );
        System.out.println("-----Коэффициент Косинуса: " + coef+"-----");
        return coef;
    }

    private int getUnionSize(List<String> list1, List<String> list2) {
        TreeSet<String> union = new TreeSet<String>(list1);
        union.addAll(list2);
        System.out.println("Размер объединения:" + union.size());
        return union.size();
    }

    private int getIntersectionSize(List<String> list1, List<String> list2) {
        TreeSet<String> intersection = new TreeSet<>(list1);
        intersection.removeIf(item -> !list2.contains(item));
        System.out.println("Размер пересечения:" + intersection.size());
        return intersection.size();
    }

    private BigDecimal getJaccardCoef(Types type, List<String> list) {
        System.out.println("Сравниваю с " + type.name());
        int unionSize = getUnionSize(list, type.traits);
        int intersectionSize = getIntersectionSize(list, type.traits);
        BigDecimal coef = BigDecimal.valueOf(intersectionSize).divide(BigDecimal.valueOf(unionSize), 2, RoundingMode.HALF_UP);
        System.out.println("-----Коэффициент Жаккарда: " + coef+"-----");
        return coef;
    }
}
