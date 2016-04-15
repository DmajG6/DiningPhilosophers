class Forks{


private int forkCount[];
private int X;

public Forks(int X){
    this.X = X;
    forkCount = new int[X];
    for(int i = 0;i<X;i++)
        forkCount[i] = 2;
}


public synchronized void take(int philosopher){
    while(forkCount[philosopher] != 2){
        try{
            wait();
        }catch(InterruptedException e){

        }
     }
    forkCount[(philosopher+1)%X]--;
    forkCount[(Math.abs(philosopher-1+X))%X]--; 

}



public synchronized void release(int philosopher){
    forkCount[(philosopher+1)%X]++;
    forkCount[(Math.abs(philosopher-1+X))%X]++;
    notifyAll();
}

}