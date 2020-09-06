/******************************************************************************
CS003B Java
Erick Bravo
06/22/20
P3.14 Saying Hello
*******************************************************************************/

public class simpHello 
{
    // declares whatever name is used to be a string
    String name;
    
    //this tags the name to where you want it to go
    public simpHello(String name)
    {
        this.name = name;
    }
    
    // this adds the name to the string of hello
    public String sayHello()
    {
        return "Hello! " +name;
    }
    
    // adds a good bye too
    public String sayGoodbye()
    {
        return "Goodbye";
    }
    
    // this will reject the goodbye
    public String refuseHelp()
    {
        return "I'm sorry " +name+ " , I'm afraid I can't do that";
    }
}
// just a really simple hello to the world
// original code before modified
/*
public class simpHello
    {
        public String sayHello()
        {
            return "Hello, World!";
        }
    }
*/
