/*
All the species aboard the Orville
This is the gelatin declaration
it is a blob and splits and makes shapes

Copyright (c) 2020, Erick Bravo
*/

#include "species.h"
/*
    private:
        double weightData;
        char shapeData[64];

    public:
        Gelatin(double weightVal);
            Gelatin gelatin(540);
            EXPECT_EQ(gelatin.weight(), 540);
        Gelatin(Gelatin &thing);
        bool compare(char *shapeA, char *shapeB);
            flat&&sphere != crazy
        double weight();
        void morph();
            EXPECT_STREQ(gelatin.shape(), "flat");
            gelatin.morph("crazy");
        void shape();
            EXPECT_STREQ(gelatin.shape(), "sphere");
        Gelatin split();
            EXPECT_NE(newGelatin, gelatin);
*/

Gelatin::Gelatin(double weightVal)
{
   weightData = weightVal;
   _shape = "sphere";
}

double Gelatin::weight()
{
    return weightData;
}

const char* Gelatin::shape()
{
    return str;
}

void Gelatin::morph(const char* value)
{
    std::string hold(value);
    if (hold == "flat" || hold == "sphere")
    {
        _shape = value;
    }
    else
    {
        _shape = "sphere";
    }    
}

void Gelatin::morph()
{
    _shape = "sphere";
}

Gelatin Gelatin::split()
{
    Gelatin halfA(weightData/2);
    return halfA;
}



