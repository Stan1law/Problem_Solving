def addition(num1, num2):
    return num1 + num2


def Subtraction(num1, num2):
    return num1 - num2


def Multiplication(num1, num2):
    return num1 * num2


def Division(num1, num2):
    return num1 / num2


def main():
    print("Select operation: ")
    print("1. Addition")
    print("2. Subtraction")
    print("3. Multiplication")
    print("4. Division")

    operator = input("Enter your operator: ")

    num1 = int(input("Enter the first number: "))
    num2 = int(input("Enter the second number: "))

    if operator == "1":
        print(addition(num1, num2))
    elif operator == "2":
        print(Subtraction(num1, num2))
    elif operator == "3":
        print(Multiplication(num1, num2))
    elif operator == "4":
        if num2 == 0:
            print("Cannot divide by zero")
        else:
            print(Division(num1, num2))


main()
