# User Registration Automation

This project automates the user registration form on the demo website `https://demo.wpeverest.com/user-registration/guest-registration-form/` using Selenium WebDriver and Java. The automation script inputs user details such as name, email, phone number, and country, then submits the form and asserts that the registration is successful.

## Steps Automated:
1. Open the registration form page.
2. Input the following fields:
   - First Name
   - Last Name
   - User Email
   - Gender
   - Date of Birth
   - Nationality
   - Phone Number
   - Country (Bangladesh)
   - Agree to Terms and Conditions
3. Click the **Submit** button.
4. Assert that the registration was successful by checking the success message.

## Tools & Libraries:
- **Selenium WebDriver**: For automating web browsers.
- **JUnit 5**: For writing and running tests.
- **Maven**: For managing project dependencies.

