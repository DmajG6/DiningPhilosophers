
public class ChopSticks {

	private int chopStickCount[];
	private int X;

	public ChopSticks(int X){
	    this.X = X;
	    chopStickCount = new int[X];
	    for(int i = 0;i<X;i++)
	        chopStickCount[i] = 2;
	}


	public synchronized void take(int philosopher){
	    while(chopStickCount[philosopher] != 2){
	        try{
	            wait();
	        }catch(InterruptedException e){

	        }
	     }
	    chopStickCount[(philosopher+1)%X]--;
	    chopStickCount[(Math.abs(philosopher-1+X))%X]--; 

	}



	public synchronized void release(int philosopher){
	    chopStickCount[(philosopher+1)%X]++;
	    chopStickCount[(Math.abs(philosopher-1+X))%X]++;
	    notifyAll();
	}

	
	
	
}
