package rough;

import org.testng.annotations.Test;




/**
 * @author JainNe
 * In case if we clubbed the priority and without priority methods then first preference will be given to non priority methods and then 
 * priority methods will be executed.
 * 
 * 
 *
 */
public class TestNGDemo 
{

	
	@Test
	public void test2()
	{
		System.out.println("i am in test 2");
	}
	

	@Test(priority = 1)
	public void test3()
	{
		System.out.println("i am in test 3");
	}
	

	@Test
	public void test4()
	{
		System.out.println("i am in test 4");
	}
	
	@Test(priority = 2)
	public void test1()
	{
		System.out.println("i am in test 1");
	}
	
}
