/******************************************************************************
CS003B Java
Erick Bravo
06/22/20
P3.14 Saying Hello
*******************************************************************************/

public class simpTestHello 
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
/*
public class simpTestHello 
{
    public static void main(String[] args)
    {
        simpHello mess1 = new simpHello();
        System.out.println(mess1.sayHello());
        simpHello mess2 = new simpHello();
        System.out.println(mess2.sayHello());
        
    }
}

original code
Test results below using Apache NetBeans
Hello, World!
Hello, World!
------------------------------------------------------------------------
BUILD SUCCESS
------------------------------------------------------------------------
Total time:  0.733 s
Finished at: 2020-06-22T17:44:39-07:00

modified code
Hello! Erick
I'm sorry ErickI'm afraid I can't do that
Goodbye
------------------------------------------------------------------------
BUILD SUCCESS
------------------------------------------------------------------------
Total time:  1.030 s
Finished at: 2020-06-23T11:05:22-07:00
*/
