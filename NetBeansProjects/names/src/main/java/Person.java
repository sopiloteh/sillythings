/******************************************************************************
CS003B Java
Erick Bravo
06/22/20
P3.06 Person
*******************************************************************************/

public class Person 
{
    // unchangable variables
    private String name;
    private String friends;
    
    // lets you put the name for friends
    public Person(String name)
    {
      this.name = name;
      friends = " ";
    }
    
    public void friend(String name)
    {
        friends += name+" ";
    }
    
    // this takes out the unwanted name with an if statement!
    public void unfriend(String name)
    {
        if(friends.contains(name))
        {
            // this sees at how big the index should be
            int start = friends.indexOf(name);
            // this scans the name to see how long it is
            int len = name.length();
            // this goes over the length of the string and sees if it matches
            // the name requested
            String temp = friends.substring(0,start) + 
                    friends.substring(start + len + 1, friends.length());
            friends = temp;
        }
    }
    
    // shows the new friends list
    public String getNames()
    {
        return friends;
    }
    
}
