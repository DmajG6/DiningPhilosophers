class Table{
private int isOccupied;
private int x;

public Table(int X){
    this.x = X;
    isOccupied = x -1;
}

public synchronized void join(){
    while(isOccupied == 0){
        try{
            wait();
        }catch(InterruptedException e){             
        }               
    }
     isOccupied--; 
}

public synchronized void leave(){

    isOccupied++;
    notify();

}
}