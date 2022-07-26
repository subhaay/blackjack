# BlackJack Java application

Simple java program that simulates black jack card game.

## Build the application

Run `mvn package` to build and package the app.

## Run the application

Run `java -cp target/blackjack-1.0-SNAPSHOT.jar org.mgm.bj.Blackjack 3` to run the application.

## Running unit tests

Run `mvn test` to execute the unit tests. PrintStream and ByteArrayOutputStream libraries were used to test the System.out.println statements. Mockito framework is also added to mock services.

## Code Coverage
Jacoco is used for code coverage for java. Coverage report can be found in `/target/site/jacoco/index.html`. Screenshot attached below.

![Code Coverage](/images/code_coverage.png?raw=true "Code Coverage")

## Blackjack Program Guide

1. After running the command with input 3 as argument, game will start with 3 players.
2. Deck is shuffled.
3. Each player along with the dealer will get the first card.
4. Dealer will have his card face down.
5. After the first round, each of the players can play their hand one by one.
6. Player will have an option to 'hit' or 'stand'.
7. If a player total hand count more than 21, he is busted.
8. After all the players are done with their hand, dealer will proceed with his hand.
9. Dealer is dealt with cards based on a simple/complex dealer strategy which can be configured.
10. Dealer will hit until his total hand count is less than 17.
11. Dealer can stand if his total count is between 17 and 21 inclusive.
12. Dealer is busted if he is over 21.
13. Winners are calculated based on below business logic.
    1. If a player is busted, dealer wins.
    2. If dealer is busted, player will win.
    3. If a player ties with the dealer, dealer wins.
    4. Between dealer and a player whoever is closer to 21 without going over it, he will be the winner.

## Dealer Strategies
Dealer Strategies are applied by the dealer based on the cards available and the current total score. There are strategy that is available and among I divided into two strategy for the time being. Here are the two strategies:
### Complex Strategy
If the card total score is 17 then check whether it is a soft 17. If the conditions are true the dealer should hit.

What is Soft 17?

I have method to calculate soft 17 for example Ace Ace 5 is a soft 17 whereas Ace Jack 6 will not be a soft 17. 

### Simple Strategy
If the card total score is less than 17, the dealer should hit.

## Class Diagram


## Design Pattern
### Design for dealer strategy:
For dealer strategy I have put the responsibility to choose a strategy to another class DecisionMaker so that the strategies can be changed independently without changing any code in the main class.






