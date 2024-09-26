def get_grade(prompt):
    while True:
        try:
            grade = float(input(prompt))
            if 0 <= grade <= 100:
                return grade
            else:
                print("Grade must be between 0 and 100")
        except ValueError:
            print("Grade must be a number")


def calculate_average(grades):
    return sum(grades) / len(grades)


def print_results(python_grade, java_grade, php_grade, javascript_grade, average_grade):
    passed_subjects = []
    failed_subjects = []

    if python_grade >= 60:
        passed_subjects.append("Python")
    else:
        failed_subjects.append("Python")

    if java_grade >= 60:
        passed_subjects.append("Java")
    else:
        failed_subjects.append("Java")

    if php_grade >= 60:
        passed_subjects.append("PHP")
    else:
        failed_subjects.append("PHP")

    if javascript_grade >= 60:
        passed_subjects.append("JavaScript")
    else:
        failed_subjects.append("JavaScript")

    if len(passed_subjects) > 1:
        print(
            f"You passed {len(passed_subjects)} subjects: {', '.join(passed_subjects)}"
        )
    elif len(passed_subjects) == 1:
        print(
            f"You failed {len(failed_subjects)} subject: {', '.join(failed_subjects)}"
        )

    if len(failed_subjects) > 1:
        print(
            f"You failed {len(failed_subjects)} subjects: {', '.join(failed_subjects)}"
        )
    elif len(failed_subjects) == 1:
        print(
            f"You failed {len(failed_subjects)} subject: {', '.join(failed_subjects)}"
        )

    print(
        f"Your average grade is: {average_grade:.2f} and you {'passed' if average_grade >= 60 else 'failed'}"
    )


def main():
    python_grade = get_grade("Enter your Python grade: ")
    java_grade = get_grade("Enter your Java grade: ")
    php_grade = get_grade("Enter your PHP grade: ")
    javascript_grade = get_grade("Enter your JavaScript grade: ")

    average_grade = calculate_average(
        [python_grade, java_grade, php_grade, javascript_grade]
    )

    print_results(python_grade, java_grade, php_grade, javascript_grade, average_grade)


if __name__ == "__main__":
    main()
