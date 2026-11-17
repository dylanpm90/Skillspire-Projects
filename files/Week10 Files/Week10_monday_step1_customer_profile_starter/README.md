# Step 1 starter: Customer and Profile (JCC Week 10, Monday)

Lesson: One-to-One, One-to-Many, and Many-to-Many Relationships, Part 2 and Part 10 exercises 1 and 4.
Solution: `../step1_customer_profile` (instructor copy).

## Your task (Part 10, exercise 1)
Fill in the three `// TODO` comments:
- `Customer.java`: TODO 1 and TODO 2, above `private Profile profile;`
- `Profile.java`: TODO 3, above `private Customer customer;`

The imports you need are already at the top of each file.

## Check your work
Run the tests in `CustomerProfileTest`.
- Before you start, both tests fail with an error about the `profile` field. That is expected.
- When all three TODOs are right, both tests pass.

IntelliJ (Windows or Mac): open `pom.xml` as a project and set the Project SDK to JDK 17. Then use the Maven panel (the "m" icon on the right) > Lifecycle > test, or click the green arrow next to `CustomerProfileTest`.
With Maven installed (Git Bash on Windows, or Terminal on Mac): `mvn test`

## Then (Part 10, exercise 4)
Run `removingCustomerAlsoRemovesItsPrivateProfile` and find the `delete` lines in the log. Which table is deleted first, and why?

## Run the demo (optional)
Run `RelationshipsApplication` with the program argument `--spring.profiles.active=demo`. It prints `Customer Ada -> profile ... at 123 Main St`.
