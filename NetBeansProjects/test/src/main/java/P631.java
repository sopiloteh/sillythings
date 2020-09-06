import java.util.ArrayList;
import java.util.Scanner;
public class P631 
{

public static void main(String[] args) {
ArrayList<String>customers=new ArrayList<>();
ArrayList<Double>sales=new ArrayList<>();
ArrayList<String>topNames=new ArrayList<>();
Scanner input=new Scanner(System.in);
String name;
int top;
double sale;
while(true)
{
System.out.print("Enter the customer name (q to stop):");
name=input.nextLine();
if("q".equalsIgnoreCase(name))
break;
customers.add(name);
System.out.print("Enter the "+name+"'s sales: $");
sale=input.nextDouble();
sales.add(sale);
input.nextLine();
}
System.out.print("\nEnter the number of top customers to dislpay: ");
top=input.nextInt();
topNames=nameOfBestCustomers(sales,customers,top);
System.out.println("\n\nTop "+top+" customes :");
System.out.println("===========================");
for(int j=0;j<topNames.size();j++)
{
System.out.println((j+1)+". "+topNames.get(j));
}
  
}
public static ArrayList nameOfBestCustomers(ArrayList<Double> sales, ArrayList<String> customers, int topN)
{
ArrayList <String>topCustomers=new ArrayList<>();
double tempSale;
String tempCustomer;
for (int i = 0; i < sales.size(); i++)
{
for (int j = i + 1; j < sales.size(); j++)
{
if (sales.get(i) < sales.get(j))
{
tempSale = sales.get(i);
sales.set(i, sales.get(j));
sales.set(j,tempSale);
  
tempCustomer=customers.get(i);
customers.set(i, customers.get(j));
customers.set(j,tempCustomer);
}
}
}
if(topN>sales.size())
return customers;

for(int j=0;j<topN;j++)
topCustomers.add(customers.get(j));
return topCustomers;
}
}