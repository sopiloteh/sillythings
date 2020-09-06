/******************************************************************************
CS003B Java
Yonas Adamu & Erick Bravo
07/16/20
P10.7 Lambada
*******************************************************************************/


public interface Filter
{
    // this is what sifts through the -1000 and +1000 accounts
    boolean accept(Object anObject);
}


/*
**************************************************************************
// original working code
public interface Filter
{
    // this is what sifts through the -1000 and +1000 accounts
    boolean accept(Object anObject);
}
**************************************************************************

attempt 1
public interface Filter
{
    (boolean anObject) -> {return accept;}
}

attempt 2
public interface Filter
{
    boolean accept;
    accept = () ->Object anobject;
}

attempt 3
public interface Filter
{
    Filter = () -> (boolean anObject) -> {return accept;}
}
*/

    

