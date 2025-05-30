
# Challenge 2: Car Functions

A car with the following functions:
-
- Turn on
- Turn off
- Accelerate
- Reduce Speed
- Turn left/right
- Verify speed
- Shift Gears

Implementation rules:
-
- When the car is created it needs to start turned off, in neutral gear, with 0 speed
- The car when turned off cannot execute any function
- When the car is accelerated it must increment 1 km/h of its speed (to a max of 120 Km/h)
- When reducing speed the car must decrement 1 km/h of its speed (to a minimum of 0 Km/h)
- The car must have 6 gears, not being able to skip through them
- The car speed must respect the following speed limits:
    - If the car is in the gear 0 (neutral point) it cannot accelerate
    - If it is in the 1st gear its speed can be between 0Km/h and 20Km/h
    - If it is in the 2nd gear its speed can be between 21Km/h and 40Km/h
    - If it is in the 3rd gear its speed can be between 41Km/h and 60Km/h
    - If it is in the 4th gear its speed can be between 61Km/h and 80Km/h
    - If it is in the 5th gear its speed can be between 81Km/h and 100Km/h
    - If it is in the 6th gear its speed can be between 101Km/h and 120Km/h
- The car can only be turned off if it is in neutral point (gear 0) and with 0 speed
- The car can only turn left/right if its speed is at least 1Km/h and at max 40Km/h