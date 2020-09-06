/******************************************************************************
CS003B Java
Erick Bravo
06/22/20
P3.14 Saying Hello
*******************************************************************************/

// main code here
public class testHello 
{
    public static void main(String[] args)
    {
        // this sets name variable to whater you want it to be
        sayHello greeter = new sayHello("Erick");
        // starts off with basic hello
        System.out.println(greeter.sayHello());
        // this takes precidence over goodbye
        System.out.println(greeter.refuseHelp());
        // then it says goodbye
        System.out.println(greeter.sayGoodbye());
    }
    
}
