import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ZeroTwoArgument {
    //vi skal ikke slev kode funktionel interfaces men bruge dem javafolk har lavet

    //vi laver vores egen forEach, her kaldes forEachString fordi vi bestemmer den kun tager strenge
    //primitv gammeldags maskinagtig kode
    static void forEachString(List<String> list, Consumer<String> consumer){
        for (String s : list) {
            consumer.accept(s); //accept har en metode der tager en parameter
        }
    }
    //nu generisk, husk <T> efter static/før void
    static <T> void forEach(List<T> list, Consumer<T> consumer){
        for (T s : list) {
            consumer.accept(s); //accept har en metode der tager en parameter
        }
    }
    public interface TwoArguments {
        int myFunct(int a, int b);
    }

    static int valutaregner(List<Integer> dollars, TwoArguments twoArguments, int kurs){
        //man koder sin forretningsregel et sted og kan overføre den som parametre til andre ting
        int sum = 0;
        for (Integer dollar : dollars) {
            sum += twoArguments.myFunct(dollar, kurs);
        }
        return sum;
    }
    //en ting vi kunne lave er at gøre at den kan tage pennies og kurs der ikke er et heltal
    //chatGPT er meget god til funktionel programmering!
    //kan man lave funktion er finder alle tisdage i 2023 på en linje kode
    //spørg cjatGPT om alt muligt. For Patino gav chatGPT dog ikke funktionel programmering
    //selvom han sagde det skulle være funktionel programmering
    //sig koden skal skrives på én linje


    public static void main(String[] args) {
        //generics er lavet så man ikke skal lave funktionel interface for hver datatype
        Consumer<String> toUpper = (x) -> System.out.println(x.toUpperCase());
        //^^ behøver ikke parantes om x
        toUpper.accept("hello world");
        //Consumer er en funktionel interface, som har en metode accept
        //accept tager en string og returnerer void
        //Consumer er en generisk interface, som tager en generisk type
        //ctr + klik på consumer for "bagom kode" for funk interface
        //har enkelt metoed som tager generisk paramter
        //fx udføre funktion på hver element i array
        //hedder consumer fordi den tager et eller andet en og spiser det
        //alt det her giver ikke mening før vi har et array hvor vi kan udføre en funktion på hver indeks

        List<Integer> listArray = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Consumer<Integer> out = (Integer x) -> System.out.println(x);
        Consumer<Integer> out2 = (x) -> System.out.println(x);
        //Interger x er bare for at vise typen, behøves ikke skrives

        //man skal skriver egen forEach som tager to parametre, tager liste med hvilken som helst type
        //tager consuder med hvilken som hestl type og udføre funktionen på hver indeks}

        List<String> lststr = Arrays.asList("hello", "world", "how", "are", "you");
        forEachString(lststr, toUpper); //toUpper er en consumer, lavet ovenover, vi overføre
        //funktion som parameter til forEachString
        forEach(listArray, out);

        //vi har allerede sådan en forEach i java:
        //skal have consumer og string/noget der nedarver fra string
        lststr.forEach(toUpper);

        //vi vil have en funktion der tager en liste af dollarsedler og kurs og en funktion der tager to
        //paramtre som tager dollarsedler og kurs og gør noget med dem fx ganger dem
        List<Integer> dollars = Arrays.asList(1, 5);

        //penge skal have dollars, funktion der gør noget med TwoArguments og kurs:
        TwoArguments bank = (x, y) -> x * y;

        int penge = valutaregner(dollars, bank, 6);
        System.out.println(penge);
        //uoverskueligt men man kan også skrive TwoArguments (bank) funktion direkte her:
        //men dårligt fordi forretningsregel ligger der frem for at kunne nemt findes et overskueligt sted
        int penge2 = valutaregner(dollars, (x, y) -> x * y, 6);

        LocalDate.of(2023, 1, 1).datesUntil(LocalDate.of(2023, 12, 31))
                .filter(x -> x.getDayOfWeek().getValue() == 2)
                .forEach(x -> System.out.println(x));
        //System.out::println - syntax betyder at den skal bruge println metoden fra Systemobjekt,
        //syntax sugar, alternativ til lamba, forkortelse til lambda

        //java har stream klasse hvor al funktionel hejs er i. der kunne ikke komme mere ind i collection
        //stream er lavet til funktionel programmering. Collections blev også lavet til fuk prog
        //de lavede ny stream klasse fordi ting man putter i collection skule være bagudkompatibel
        //collection laves til stream og der gøres noget med det og laves tilbage til collection

    }
}
// de har også meget funktionel prog med interfaces i c sharp

//c++ kode oversættes direkte til maskinkode, ingen virtuel maskine som med java
//første sprog med generics