README for LottoGUI.java
***created/compiled using Eclipse IDE***
- a swing interface
- use of PriorityQueue data structure to keep track of numbers
   - 1st numbers selected go in & come out
- swing actions used to record user interaction with interface

RULES:
 * Player starts off with $10
 * IF: all 6 numbers picked are winners doubles payoff
 * ELSE: payoff is number of matches (ie, 3 = 3, 1 = 1)
 * shift-click on Draw allows for cheating: user selected numbers set to numbers
 
INSTRUCTIONS:
1. Clicking on a number turns the button's background blue, and adds this number into the selected 
   numbers
2. Clicking on a selected (blue) number will turn the button's background back to the default
   color, and remove this number from the selected numbers
3. If six numbers have been picked, then the user cannot select additional numbers.
 