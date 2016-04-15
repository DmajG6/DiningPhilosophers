class Philosopher extends Thread{

int i;
int minThinkingTime,maxThinkingTime,minEatingTime,maxEatingTime;
private ChopSticks c;
private Table d;
private String status;

public Philosopher(int index,int minThinkingTime,int maxThinkingTime,int minEatingTime,int maxEatingTime, ChopSticks chopSticks, Table table){
    this.i = index;
    this.minThinkingTime = minThinkingTime;
    this.maxThinkingTime = maxThinkingTime;
    this.minEatingTime = minEatingTime;
    this.maxEatingTime = maxEatingTime;
    this.c = chopSticks;
    this.d = table;
} 

public void think(){
    try{
        //System.out.println(i+" Philosopher is thinking");
        Thread.sleep((int)(Math.random()*(maxThinkingTime - minThinkingTime))+minThinkingTime);
        status = "thinking";
    }catch(InterruptedException e){

    }
}

public void eat(){
    try{
        //System.out.println(i+" Philosopher is eating");
        Thread.sleep((int)(Math.random()*(maxEatingTime - minEatingTime))+minEatingTime);
        status = "eating";
    }catch(InterruptedException e){

    }
}

public void run() {
    while (true) {
         think();
         d.join();
         c.take(i);
         eat();
         c.release(i);
         d.leave();
         displayStatus();
    }
}

public void displayStatus(){
	
	System.out.println("--");
	int i = 1;
	for(Philosopher p: mainclass.philosophers){
		System.out.println("Philosopher "+i+" is "+p.status);
		i++;
	}
	
	
}
}