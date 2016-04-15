public class mainclass {

public static int X = 5; 

public static Philosopher[] philosophers = new Philosopher[4];

public static void main(String[] args) {
    philosophers = new Philosopher[X];
    ChopSticks chopsticks = new ChopSticks(X); 
    Table table = new Table(X);

    for(int i = 0;i<X;i++)
        philosophers[i] = new Philosopher(i,100,200,300,1000,chopsticks,table);

    for(int i = 0;i<X;i++)
        philosophers[i].start();


}

}