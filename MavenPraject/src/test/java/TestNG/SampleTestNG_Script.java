package TestNG;

import org.testng.annotations.Test;


	public class SampleTestNG_Script {
	 @Test(invocationCount = 3)
		public void India() {
			System.out.println("India is my country");
		}	
		
		@Test		
		public void Telengana() {
		System.out.println("Telangana is my state");
		}
		
		@Test(enabled = false)
		public void Hyderabad(){
			System.out.println("Hyderabad is my city");
		
		
		}
		
}
