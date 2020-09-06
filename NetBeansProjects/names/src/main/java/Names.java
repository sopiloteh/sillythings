/******************************************************************************
CS003B Java
Erick Bravo
06/22/20
P3.06 Names
*******************************************************************************/

public class Names 
{
    public static void main(String[] args)
    {
        // this names all the friends
        Person person = new Person("Erick");
        person.friend("Bob");
        person.friend("Jack");
        person.friend("Leo");
        
        // shows all the friends
        System.out.println(person.getNames());
        
        // Defriends Bob after vegas
        // this looks for the word Bob and takes it out
        person.unfriend("Bob");
        System.out.println("After unfriending Bob");
        // prints out friends list with remaning names
        System.out.println(person.getNames());
        
        // Defriends Leo after totalling his car
        // this looks for the word Leo and takes it out
        person.unfriend("Leo");
        System.out.println("After unfriending Leo");
        // prints out friends list with remaning names
        System.out.println(person.getNames());
        
        // Defriends Jack after eating his hamburger
        // this looks for the word jack and takes it out
        person.unfriend("Jack");
        System.out.println("After unfriending Jack");
        // prints out friends list with remaning names
        System.out.println(person.getNames());    
    }    
}

/*
Run on NetBeans
 Bob Jack Leo 
After unfriending Bob
 Jack Leo 
After unfriending Leo
 Jack 
After unfriending Jack
 
------------------------------------------------------------------------
BUILD SUCCESS
------------------------------------------------------------------------
Total time:  2.418 s
Finished at: 2020-06-23T12:37:32-07:00
*/
