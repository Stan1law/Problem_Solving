# Problem: To-Do List Manager
# Objective: Create a program that allows users to manage a simple to-do list. The user should be able to add tasks, remove tasks, and view the current list of tasks.

# Instructions:

# Add a Task:

# The user should be able to add a task to the to-do list.
# Remove a Task:

# The user should be able to remove a task from the to-do list by specifying the task number.
# View All Tasks:

# The user should be able to view all the current tasks in the to-do list.
# Exit:

# The program should allow the user to exit.


def to_do_list():
    tasks = []

    while True:
        print("To-Do List Manager")
        print("1. Add a Task")
        print("2. Remove a Task")
        print("3. View All Tasks")
        print("4. Exit")

        choice = input("Enter your choice: ")

        if choice == "1":
            task = input("Enter the task: ")
            tasks.append(task)
            print("Task added successfully!")

        elif choice == "2":
            task_number = int(input("Enter the task number to remove: "))
            if task_number > 0 and task_number <= len(tasks):
                del tasks[task_number - 1]
                print("Task removed successfully!")
            else:
                print("Invalid task number!")

        elif choice == "3":
            if len(tasks) == 0:
                print("No tasks found!")
            else:
                print("Current tasks:")
                for i, task in enumerate(tasks):
                    print(f"{i+1}. {task}")

        elif choice == "4":
            print("Exiting...")
            break

        else:
            print("Invalid choice!")


to_do_list()
