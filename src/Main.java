
public class Main {

    public interface ZeroArgument{
        public void myFunct();
    }

    public static void printZero(ZeroArgument z0){
        z0.myFunct();
    }

    public interface TwoArguments {
        int myFunct(int a, int b);
    }

    public static void main(String[] args) {
        ZeroArgument z = () -> System.out.println("Hello World");
        //inplementere interfacet frem for at lave en klasse^
        printZero(z);//overføre funktion/landba udtryk til denne printZero metode
        //^^ekstra step, man ellers ikke gør for at vise hvordan man overføre funkt i java
        z.myFunct(); //behøver ikke ovreføre paramteren, kan kaleds direkte
        //z er et objekt af et lambda udtryk

        TwoArguments to = (x, y) -> x + y; //funktion kan gøre hvad som helst, fx iterere over en liste
        int i2 = to.myFunct(2, 3);
        System.out.println(i2);

        //vi skal lave interfaces i java fordi vi skal specificere datatyper. Behøves okke i js
        //nennemste måde at forklare hvordan funktionen skal se ud/datatyper er med interfaces
    }
}