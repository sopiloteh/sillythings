/*
All the species aboard the Orville
with the various things they do

Copyright (c) 2020, Erick Bravo
*/
#ifndef SPECIES_SPECIES_H_
#define SPECIES_SPECIES_H_
#include <string>
#include <iostream>

class Eevak
{
    private:
        bool _isRunning = false;

    public:
        bool isRunning();
        void run();
        void stop();

};

class Gelatin
{
    private:
        double weightData;
        const char* _shape;
        char str[32];
        
    protected:
        char shapeData[32];

    public:
        Gelatin(double weightVal);
        double weight();
        void morph();
        int halfA;
        int halfB;
        const char* shape();
        Gelatin split();
};

class Humanoid
{
    private:
        bool _isHumanoid = true;

    protected:
        double heightData;
        double weightData;

    public:
        bool isHumanoid();
        double height();
        double weight();

};

class Human : public Humanoid
{
    private:
        bool _male;

    public:
        Human(bool genderVal, double heightVal, double weightVal);
        bool isMale();

};


class Kaylon : public Humanoid
{
    private:
        bool _isFiring = false;

    public:
        Kaylon(double heightVal, double weightVal);

        bool isFiring();
        void startFiring();
        void stopFiring();
};

class Moclan : public Humanoid
{
    private:
        bool _isEgg;
        bool egg;
        bool crack;
      
    public:
        Moclan(double heightVal, double weightVal);

        bool isEgg();
        Moclan layEgg();
        Moclan hatch();

};

#endif