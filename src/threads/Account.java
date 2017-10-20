package threads; //this is a mini online atm system where num of people try to access same accnt balance
class User{
	int balance=50;	//currently or initial the accnt balance
	public int getBalance()
	{			
		return balance;		//reading balance value
	}
	public int withdraw(int amount)
	{
		balance=balance-10;	//withdrawing amount from balance
		return balance;	
	}
}
public class Account implements Runnable{ //runnable interface
	int amount;
	User usr=new User();	// object creation of class user

	public void run()
	{								//run method ----logic
		for(int i=0;i<3;i++)
		{transact(10);
		}
		if(usr.getBalance()<=0)
		{
			
			System.out.println("account is zero");
		}
	}
	private synchronized void transact(int amount)	//synchronized method to avoid race condition only one thread at time
	{
		this.amount=amount;
		if(amount<usr.getBalance())
		{
			System.out.println(Thread.currentThread().getName()+" start to withdrwal");
		
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		usr.withdraw(amount);
		System.out.println(Thread.currentThread().getName()+" complete withdrwal");
		}
		else 
			System.out.println(Thread.currentThread().getName()+" no sufficient funds");
		
	}
	
	
	
	
	
	public static void main(String[] args) {
		Account obj=new Account();
		Thread t1=new Thread(obj);
		Thread t2=new Thread(obj);
		t1.setName("vishnu"); //setting names here withdraw persons
		t2.setName("vipin");
		
		t1.start();
		t2.start();
	

	}

}
