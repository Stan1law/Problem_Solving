# Problem: Banking System
# Objective: Create a simple banking system in python that allows users to create accounts, deposit money, withdraw money, and check their balance.

# Instructions:

# Account Creation:

# The user should be able to create a new bank account with an initial balance.
# Each account should have a unique account number.
# Deposit Money:

# The user should be able to deposit money into their account by providing the account number and the deposit amount.
# Withdraw Money:

# The user should be able to withdraw money from their account by providing the account number and the withdrawal amount.
# The system should check if there are sufficient funds in the account before allowing the withdrawal.
# Check Balance:

# The user should be able to check the balance of their account by providing the account number.
# Exit System:

# Provide an option to exit the banking system.

accounts = {}


def create_account():
    account_number = int(input("Enter account number: "))
    if account_number in accounts:
        print("Account number already exists. Please try again.")
        create_account()
    balance = float(input("Enter initial balance: "))
    accounts[account_number] = balance
    print("Account created successfully!")
    print("Account Number:", account_number)
    print("Balance:", balance)
    main()


def deposit_money():
    account_number = int(input("Enter account number: "))
    if account_number not in accounts:
        print("Account number does not exist. Please try again.")
        deposit_money()
    amount = float(input("Enter amount to deposit: "))
    accounts[account_number] += amount
    print("Money deposited successfully!")
    print("Account Number:", account_number)
    print("Amount Deposited:", amount)
    print("New Balance:", accounts[account_number])
    main()


def withdraw_money():
    account_number = int(input("Enter account number: "))
    if account_number not in accounts:
        print("Account number does not exist. Please try again.")
        withdraw_money()
    amount = float(input("Enter amount to withdraw: "))
    if accounts[account_number] < amount:
        print("Insufficient funds. Please try again.")
        withdraw_money()
    accounts[account_number] -= amount
    print("Money withdrawn successfully!")
    print("Account Number:", account_number)
    print("Amount Withdrawn:", amount)
    print("New Balance:", accounts[account_number])
    main()


def check_balance():
    account_number = int(input("Enter account number: "))
    if account_number not in accounts:
        print("Account number does not exist. Please try again.")
        check_balance()
    else:
        print("Balance:", accounts[account_number])
        main()


def exit_system():
    print("Thank you for using the banking system!")
    exit()


def main():
    while True:
        print("Welcome to the banking system!")
        print("Please choose an option:")
        print("1. Create Account")
        print("2. Deposit Money")
        print("3. Withdraw Money")
        print("4. Check Balance")
        print("5. Exit System")
        option = int(input("Enter option: "))
        if option == 1:
            create_account()
        elif option == 2:
            deposit_money()
        elif option == 3:
            withdraw_money()
        elif option == 4:
            check_balance()
        elif option == 5:
            exit_system()
        else:
            print("Invalid option. Please try again.")


if __name__ == "__main__":
    main()
