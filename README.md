# Scrabble Challenge - this time in Java!

Welcome to the Scrabble challenge!
=================
## About the Project
This project helps us to build up understanding for different concepts, such as Domain Modelling, Testing, Testing Frameworks, Test Driven Development, and we continue to develop our skills in Java. 
This project is completed around 5th week of our training. It is very similar to the first challenge, however, the code is developed in java instead of javascript. Therefore, we had 1 week to understand the java syntax and create this project.
## Built With
1. Using Github [Commit everytime you make a change]
2. Java [IntelliJ Idea]
3. Domain model
4. User story
## Project Review and Roadmap
The main takeaways from this project is to use Java in a professional manner, learning how to write user story and unit test and gain a deeper understanding in java when we create a class and constructor. 
If I can re-do the Project again, I probably would improve on my domain model and find ways to make my code cleaner, also I would finish the Extended Criteria for triple words.
```
|S|C|R|A|B|B|L|E|XX|C|H|A|L|L|E|N|G|E
```
===========================================================
## Learning Objectives
- Build a simple program using functions, loops, and flow control
- Use `git` & GitHub to commit work and open a Pull Request

## Instructions

1. Fork this repository and then clone your copy:
```sh
$ git clone <YOUR GITHUB DETAILS>/scrabble-challenge.git && cd scrabble-challenge
```
2. Run the tests from IntelliJ. There should be a failing test to begin with. You can run your test suite in a few ways:
   1. Right-click on the project and then select `Run all Tests`
   2. Right-click on the `ScrabbleTest` and click `Run ScrabbleTest`
   3. Open the class file `ScrabbleTest` and click the "Play" button to the left of the class declaration

Your first error when running the tests should be this:

![Initial Error](images/InitialError.png)

3. In GitHub, [open a Pull Request](https://docs.github.com/en/github/collaborating-with-issues-and-pull-requests/creating-a-pull-request) from your forked repository to the challenge repository.
4. Implement the criteria below locally and [push your code](https://docs.github.com/en/github/managing-files-in-a-repository/adding-a-file-to-a-repository-using-the-command-line) to your repository! Every push to a branch that has an open Pull Request will update it automatically with your changes.

# Task

Given a word, compute the scrabble score for that word.

##### Letter Values

You'll need these:

| Letter                        | Value  |
| ----                          |  ----  |
| A, E, I, O, U, L, N, R, S, T  |     1  |
| D, G                          |     2  |
| B, C, M, P                    |     3  |
| F, H, V, W, Y                 |     4  |
| K                             |     5  |
| J, X                          |     8  |
| Q, Z                          |     10 |

Example
"cabbage" should be scored as worth 14 points:

- 3 points for C
- 1 point for A, twice
- 3 points for B, twice
- 2 points for G
- 1 point for E

And to total:

```
3 + 2x1 + 2x3 + 2 + 1
= 3 + 2 + 6 + 3
= 14
```

## Acceptance Criteria
## User Story
```
Test 1: check empty word
As an a player
So that I don't enter a empty word
I want the score to return zero
============================================================================
      Scrabble scrabble = new Scrabble("");
      scrabble.score();   // => 0
============================================================================
```
1. I have created a checkLetter method, if the input[letter] is null, then it will be converted to an empty string. Then, when we run the score method, it will return zero because the initial score should be 0.
```
Test 2: check null input
As an a player
So I know I don't enter a nothing
I want to have zero score when my input is null
============================================================================
      scrabble = new Scrabble(null);
      scrabble.score();   // => 0
============================================================================      
```
1. I have created a checkLetter method, if the input[letter] is empty string, Then, when we run the score method, it will return zero because the initial score should be 0.
```
Test 3: check Single letter
As a player
So I know I have entered a single letter
I want to know the score assocaited with that letter
============================================================================
      scrabble = new Scrabble("a");
      scrabble.score(); // => 1
============================================================================      
      scrabble = new Scrabble("f");
      scrabble.score(); // => 4
============================================================================         
```
1. we have used the HashMap which acts like a dictionary, the keys are the letters, and we assign different integer value to them. In this case, letter a would convert to UpperCase then loop through the Hashmap and return the value of according to the scrabble challenge score Table. 
```
Test 4: check lowercase word with correct score
As a player
So I can check I have entered a word
I want a total sum [letters] to return
=============================================================================
      scrabble = new Scrabble("street");
      scrabble.score(); // =>, 6
=============================================================================
      scrabble = new Scrabble("quirky");
      scrabble.score(); // => 22
=============================================================================
```
1. We have created a method called setScoreLetters(String str), we have set the initial score to be 0.
2. Then, we use the for loop and, sum up all the score inside the pointSystem.
3. The pointSystem was created using HashMap which acts like a dictionary, we use [put] to assign different letters with the correct score

```
Test 5: Check UpperCase Letter
As a player
So that I can earn points even the letters are in UpperCase
I would like it to still return a total sum [letters]
=============================================================================
      scrabble = new Scrabble("OXYPHENBUTAZONE");
      scrabble.score(); // => 41
=============================================================================      
```   
1. Because the HashMap only has UpperCase letters, we have to make sure all the letters are converted to UpperCase before we check the HashMap, so the checkLetter() is created and will convert all the letters to UpperCase as long as they are not null or empty.
2. Then when we run the public int score() method, they will run the checkLetter() method first, then they will add them together and return a correct score
```
Test 6a: Check word with Double Score
As a player
So that I can gain double points
I want to be able to enter a double word and earn double points 
=============================================================================
       Scrabble scrabble = new Scrabble("quirky", new Character[]{}, true);
       assertEquals(scrabble.score(), 44);
=============================================================================
```
1. A boolean instance variable is created for doubleWordScore, if it is true, then the score will return double.
2. Also, a new constructor is created, and we will add more parameters associated with the Double word score in the new constructor. Using constructor overloading, we can write different unit tests which will check single word only and double words too.
```
Test6B: Check if Single letter return double word score
As a player
So I can get double points
I want the single letter to return double score
=============================================================================
      Scrabble scrabble = new Scrabble("a", new Character[]{'A'}, false);
      assertEquals(scrabble.score(), 2);
=============================================================================
```   
1. the doubleWord() method will be triggered as long as someone is using the new constructor
```
Test6C: Check returnsScoreForDoubleLetterOnlyOnce
As a player
So I won't get wrong score with duplicated letter
I want the double score on the first letter only

 =============================================================================
       Scrabble scrabble = new Scrabble("aa", new Character[]{'A'},  false);
       assertEquals(scrabble.score(), 3);
=============================================================================
```   
1. if the boolean value is false, then it should only call the doubleWord() method once!


## Domain Model
|  Object  |  Properties                  | Message                              | Context            | Output      |  Done?
|----------|------------|--------------------------------------|--------------------|-------------|--------
| Scrabble | pointsystem @HashMap[letter] | checkLetter ()                       | empty word         | Int [@0]    |  ✅
|  | |                                      | null               | Int [@0]    |  ✅
|  | |                                      | UpperCase letter   | Int         |  ✅
|  | | getScoreForLetter (Character letter) | single letter      | Int         |  ✅
|  | | getScoreForLetters (String str)      | word               | Int         |  ✅
|  | |  setScoreForDoubleWord(ArrayList<Character> letters, int score)                                    | doubleScore letter | Int         |  ✅

## Extended Acceptance Criteria
> Each `Scrabble` method should be no more than 5 lines and contain no more than 5 operations.

> You can play a double or a triple letter.

> You can play a double or a triple word.




