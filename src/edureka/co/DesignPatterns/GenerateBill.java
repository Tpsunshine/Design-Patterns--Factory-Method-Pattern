/* Java Program showing Factory Design Pattern to calculate Electricity Bill.
 * Author : Thabo Pitso
 * Date: 2022/03/07
 */

package edureka.co.DesignPatterns;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

abstract class Plan
{
	protected double rate;
	abstract void getRate();
	
	public void calculateBill(int units) 
	{
		System.out.println(units * rate);
		
	}
	
} // end of Plan class

//Create the concrete classes that extends Plan abstract class
class DomesticPlan extends Plan
{
	//@override
	public void getRate() 
	{
		rate = 3.50;
	}
	
} //End of DomesticPlan class

class CommercialPlan extends Plan
{
	//@override
	public void getRate() 
	{
		rate = 7.50;
		
	}
	
} //End of the CommercialPlan class.

class InstitutionalPlan extends Plan
{
	//@override
	public void getRate() 
	{
		rate = 5.50;
		
	}
	
} // End of the InstitutionalPlan class

/* Create a GetFactory to generate object of concrete
 * classes based on given information
 */

class GetPlanFactory

//use getPlan method to get object of type Plan

{
	public Plan getPlan(String planType) 
	{
		if(planType == null) 
		{
			return null;
			
		}
		if(planType.equalsIgnoreCase("DOMESTICPLAN")) 
		{
			return new DomesticPlan();
		}
		
		else if(planType.equalsIgnoreCase("COMMERCIALPLAN")) 
		{
			return new CommercialPlan();
			
		}
		
		else if(planType.equalsIgnoreCase("INSTITUTIONALPLAN")) 
		{
			return new InstitutionalPlan();
			
		}
		
		return null;
	}
	
} // End of GetPlanFactory class

/* Generate Bill using the GetplanFactory to get the object of concrete classes by
 * passing an information such as type of plan DOMESTICPLAN or COMMERCIALPLAN or INSTITUTIONAL PLAN
 */

public class GenerateBill {

	public static void main(String[] args) throws IOException 
	{
		GetPlanFactory planFactory = new GetPlanFactory();
		
		
		System.out.println("Enter the name of plan fow which the bill will be generated: ");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		
		String planName = br.readLine();
		System.out.println("Enter the number of units for bill will be calculated: ");
		int units = Integer.parseInt(br.readLine());
		
		
		Plan p = planFactory.getPlan(planName);
		//call getRate method and calculateBill()method of DomesticPlan
		
		
		System.out.println("Bill amount for " +planName+ " of " +units+ " units is : ");
		p.getRate();
		p.calculateBill(units);
		

	}

}//End of GenerateBill class.
