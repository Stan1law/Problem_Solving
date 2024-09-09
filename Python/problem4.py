# Problem: Palindrome Checker
# Objective: Create a program that checks if a given string is a palindrome.

# Instructions:

# Prompt the user to enter a string.
# The program should check if the string is a palindrome—a word, phrase, or sequence that reads the same backward as forward (ignoring spaces, punctuation, and case).
# If the string is a palindrome, the program should print a message saying so; otherwise, it should say that the string is not a palindrome.
# The program should continue to prompt the user for strings until they choose to exit.


def is_palindrome():
    input_str = input("Enter a string: ").strip()

    if input_str == input_str[::-1]:
        print("The", input_str, "is a palindrome.")
    else:
        print("The", input_str, "is not a palindrome.")


is_palindrome(input)
while True:
    play_again = input("Do you want to input another string? (y/n) ")

    if play_again.lower() == "y":
        is_palindrome()
    else:
        print("Goodbye!")
        break
