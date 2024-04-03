%Mr fart 09/13/2023
%ME Programming for Mechancial Engineers
%Calculates charge at specific time

%Inputs
t = 0.1 % Time in seconds, s
qo = 12.4 % Initial charge in coulomb, C
R = 40 % Resistance in ohms 
L = 5 % Inductance in Hertz, H
C = 10e-4 %Capacitance in farad, F

%Computations
a = 12.4e^(-400.1/25)cos % Term in charge equation
b = 0.1sqrt[1/5(10e-4)-(40/25)^2] %Term in charge equation
q = qoe^(-Rt/2L)cos[t*sqrt(1/LC)-(R/2L)^2] %Charge in q

%Outputs
q 