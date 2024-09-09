def DollarToPesos(dollar):
    exchangeRate = 58.50
    return dollar * exchangeRate


def inch_to_cm(inches):
    return inches * 2.54


def Fahren_to_Cel(Fahrenheit):
    return (Fahrenheit - 32) * 5 / 9


UserChoice = input(
    "Enter a number to perform a program that you want: \n1 to convert dollars to pesos,\n2 to convert inches to cm,\n3 to convert Fahrenheit to Celsius\n"
)

if UserChoice == "1":
    amountInDollars = float(input("Enter the amount in dollars: "))
    amountInPesos = DollarToPesos(amountInDollars)
    print("%.2f dollars is equal to %.2f pesos." % (amountInDollars, amountInPesos))

elif UserChoice == "2":
    amountInInches = float(input("Enter the amount in inches: "))
    amountInCm = inch_to_cm(amountInInches)
    print("%.2f inches is equal to %.2f cm." % (amountInInches, amountInCm))

elif UserChoice == "3":
    amountInFahrenheit = float(input("Enter the amount in Fahrenheit: "))
    amountInCelsius = Fahren_to_Cel(amountInFahrenheit)
    print(
        "%.2f degrees Fahrenheit is equal to %.2f degrees Celsius."
        % (amountInFahrenheit, amountInCelsius)
    )
