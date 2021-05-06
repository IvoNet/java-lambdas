package nl.ordina.anonymous;

public class AnonymousClass {

    //cd src/main/java
    //javac nl/ordina/example001/AnonymousClass.java

    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("in thread");
            }
        });
        thread.start();

        System.out.println("In Main");
    }
}
