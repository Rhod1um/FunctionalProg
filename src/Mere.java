import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Mere {

    public static void g7(){
        //g7 gammeldags collection?
        List<String> g7 = Arrays.asList("USA", "Japan", "France", "Germany", "Italy", "U.K.", "Canada");
        Function<String, String> toUpper = (s) -> s.toUpperCase();
        List<String> g7Upper = g7.stream().map(toUpper).collect(Collectors.toList());
        //man får stream frem for liste. Vi vil tilbage til liste. (fra  liste til stream og tilbage til collection)
        //.collect(Collectors.toList()); -> Hvad man end får ud af map, put det ind i en liste

        g7Upper.forEach(System.out::println);

        Function <String, Integer> strLength = (s) -> s.length();
        List<Integer> lstLength = g7.stream().map(strLength).collect(Collectors.toList());
        lstLength.forEach(System.out::println);
    }

    public static void uendelig(){
        Supplier<Double> ran = () -> Math.random();
        Stream<Double> ranNums = Stream.generate(ran);
        //brug var obj til test hvilken type man får, fx viste var obj her at man fik stream af double
        //stream: pluk æbne,
        ranNums.forEach(System.out::println);
        //uendelig løkke printer random number
        //stream skal ses lidt som en fil, er åben indtil man lukker den.
        //når man putter ting fra den over i en liste så lukker man den når den putter det over i listen auto
        //collections bruges til at gemme ting, streams bruges til at manipulere ting
    }

    public static void main(String[] args) {
        Supplier<Double> ran = () -> Math.random();
        Stream<Double> ranNums = Stream.generate(ran);
        Function<Double, Long> dblround = d -> Math.round(d*100);
        //var obj = Stream.generate(ran).map(dblround); //får uendelig mange tal mellem 1 og 100
        //filter til at få lige tal:
        Predicate<Long> longequal = l -> l % 2 == 0;
        //predicate er altid boolan
        Double sumaf12 = Stream.generate(ran).
                map(dblround).
                filter(longequal)
                .limit(12) //limit til at få 12 tal, man skal stoppe den på en måde
                .mapToDouble(d->d)
                        .sum();

        //obj.forEach(System.out::println);
        System.out.println();
        //man kan ikke have length på stream, årsag til at lave det til collection/liste
        //vi ville have skrevet sout(obj.lenth) men det kan ma ikke så vi looper igennem og printer
        //med obj.forEach(System.out::println);

        //nu er .mapToDouble(d->d)
        //                        .sum(); tilføjet

        System.out.println(sumaf12);
        //stream har heller ikke sum funktion så derfor laves til double
    }

} //.filter skal have predicate, boolsk funktion, map skal ikke - skal have type ind og type ud
//jave har Function type som tager type ind og type ud. for type ind og returnere specificerede tilabetype
