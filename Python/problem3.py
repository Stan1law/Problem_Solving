# Problem: Guessing Game
# Objective: Create a Java program that implements a simple number guessing game.

# Instructions:

# The program should randomly generate a number between 1 and 100.
# The user will try to guess the number.
# After each guess, the program should tell the user whether the guess was too high, too low, or correct.
# The game should continue until the user guesses the correct number.
# After the game ends, the program should display how many attempts it took to guess the correct number.
# Ask the user if they want to play again. If they choose to play again, the game should start over with a new random number.

import random


def guess_number():
    number = random.randint(1, 10)
    attempts = 0

    while True:
        try:
            user_guess = int(input("Guess a number between 1 and 10: "))
            attempts += 1

            if user_guess < number:
                print("Too low!")
            elif user_guess > number:
                print("Too high!")
            else:
                print(
                    f"Congratulations! You guessed the number in {attempts} attempts."
                )
                break
        except ValueError:
            print("Invalid input. Please enter a whole number.")


def play_again():
    play_again = input("Do you want to play again? (y/n) ")
    if play_again.lower() == "y":
        guess_number()
    else:
        print("Goodbye!")


guess_number()
play_again()
