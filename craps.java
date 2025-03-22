 1   // Fig. 5.8: Craps.java
 2   // Craps class simulates the dice game craps.
 3   import java.security.SecureRandom;
 4
 5   public class Craps {
 6      // create secure random number generator for use in method rollDice
 7      private static final SecureRandom randomNumbers = new SecureRandom();
 8
 9      // enum type with constants that represent the game status
10      private enum Status { CONTINUE, WON, LOST };              
11
12      // constants that represent common rolls of the dice
13      private static final int SNAKE_EYES = 2;
14      private static final int TREY = 3;      
15      private static final int SEVEN = 7;     
16      private static final int YO_LEVEN = 11; 
17      private static final int BOX_CARS = 12; 
18
19      // plays one game of craps
20      public static void main(String[] args) {
21         int myPoint = 0; // point if no win or loss on first roll
22         Status gameStatus; // can contain CONTINUE, WON or LOST
23
24         int sumOfDice = rollDice(); // first roll of the dice
25
26         // determine game status and point based on first roll
27         switch (sumOfDice) {
28            case SEVEN: // win with 7 on first roll    
29            case YO_LEVEN: // win with 11 on first roll
30               gameStatus = Status.WON;
31               break;
32            case SNAKE_EYES: // lose with 2 on first roll
33            case TREY: // lose with 3 on first roll      
34            case BOX_CARS: // lose with 12 on first roll 
35               gameStatus = Status.LOST;
36               break;
37            default: // did not win or lose, so remember point
38               gameStatus = Status.CONTINUE; // game is not over
39               myPoint = sumOfDice; // remember the point       
40               System.out.printf("Point is %d%n", myPoint);
41               break;
42         }
43
44         // while game is not complete
45         while (gameStatus == Status.CONTINUE) { // not WON or LOST
46            sumOfDice = rollDice(); // roll dice again
47
48            // determine game status
49            if (sumOfDice == myPoint) // win by making point
50               gameStatus = Status.WON;
51   }
52            else {
53               if (sumOfDice == SEVEN) // lose by rolling 7 before point
54                  gameStatus = Status.LOST;
55         }
56       }
57     }
58
59          // display won or lost message
60         if (gameStatus == Status.WON) {
61            System.out.println("Player wins");
62         }
63         else
64            System.out.println("Player loses");
65         }
66      }
67
68      // roll dice, calculate sum and display results
69      public static int rollDice() {
70         // pick random die values
71         int die1 = 1 + randomNumbers.nextInt(6); // first die roll
72         int die2 = 1 + randomNumbers.nextInt(6); // second die roll
73
74         int sum = die1 + die2; // sum of die values
75
76         // display results of this roll
77         System.out.printf("Player rolled %d + %d = %d%n", die1, die2, sum);
78
79         return sum;
80      }
81   }
