# Right-Wing-Problem

The Right Wing problem is summarized as follow:
Given an integer array whose values are less or equal to the length of said array, how can you tell if it is possible for a marker, starting at position 0, to reach the last position of the array?

The marker can move in two directions: left or right.

The displacement is the integer value stored in the position the marker is currently "standing" in.
E.g. If the marker is at position 0, and the integer value at position 0 is 3, then the market will move 3 positions to the right (as it cannot move left and beyond the boundaries of the array).

The solution implemented here uses multiple recursion and is not entirely foolproof (see comments in RightWing1.java).
The problem generates a number of test cases (to be determined by user input) and prints them into a txt file.
It displays TRUE when it is possible to reach the rightmost position, and FALSE otherwise.
The time required to obtain the answer (in nanoseconds) is also printed along the randomly generated arrays for users' perusal.

There exist a linear solution to simpler variant of the Right Wing Problem.
The variant implements the following change: "what if the market can only move to the right, and never to the left?"
The solution to this variant is to add the position to their corresponding array value. Define the "required position" as the position a market must reach in order to land on the rightmost position. Iterate through the array to verify if it is possible to reach the "required position".

I believe I might code and submit the code for that variant in the future. I also believe that it is one of many algorithmic problems on LeetCode.com
