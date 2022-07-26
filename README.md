# BlackJack Java application

Simple java program that simulates black jack card game.

## Build the application

Run `nvm package` to build and package the app.

## Run the application

Run `java -cp target/blackjack-1.0-SNAPSHOT.jar Blackjack 3` to run the application.

## Running unit tests

Run `nvm test` to execute the unit tests. PrintStream and ByteArrayOutputStream libraries were used to test the System.out.println statements. Mockito framework is also added to mock services.

## Code Coverage
Jacoco is used for code coverage for java. Coverage report can be found in `/target/site/jacoco/index.html`. Screenshot attached below.

![Code Coverage](/images/coverage_report.png?raw=true "Code Coverage")

## Blackjack Program Guide

1. After running the above command, game will start with 3 players.
2. Deck is shuffled.
3. Each player along with the dealer will get the first card.
4. Dealer will have his card face down.
5. After the first round, each of the players can play their hand one by one.
6. Player will have an option to 'hit' or 'stand'.
7. If a player total hand count more than 21, he is busted.
8. After all the players are done with their hand, dealer will proceed with his hand.
9. Dealer is dealt with cards based on a certain strategy that can be configured.
10. Dealer will hit until his total hand count is less than 17.
11. Dealer can stand if his total count is between 17 and 21 inclusive.
12. Dealer is busted if he is over 21.
13. Winners are calculated based on below business logic.
    1. If a player is busted, dealer wins.
    2. If dealer is busted, player will win.
    3. If a player ties with the dealer, dealer wins.
    4. Between dealer and a player whoever is closer to 21 without going over it, he will be the winner.




