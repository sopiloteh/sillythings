/******************************************************************************
CS003B Java
Erick Bravo
06/22/20
P3.14 Saying Hello
*******************************************************************************/

// functions for saying and not saying hello
public class sayHello 
{
    // declares whatever name is used to be a string
    String name;
    
    //this tags the name to where you want it to go
    public sayHello(String name)
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
        return "I'm sorry " +name+ "I'm afraid I can't do that";
    }
}
