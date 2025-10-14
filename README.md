( Group A ) Project name:
Banking System 

Members:
Alina Moughal, Phi Huynh, Ashraf Kizito, Alioune Mbaye, Fox Zhang.  

Roles: 
Project Manager-Alina, Coder-Phi Huynh, Tester-Alioune Mbaye, Frontend Developer-Fox Zhang, Systems Analyst-Ashraf Kizito. 

Project description:
Our group project focuses on developing a Banking System using IntelliJ- JAVA. The system is designed to allow users to create and manage bank accounts, perform deposits and withdrawals, check balances, and maintain transaction records. It demonstrates the use of object-oriented programming principles. The project’s main goal is to simulate a real-world banking operation, but in simpler terms. Showing how, as a group, we work together to develop a successful running program.

Pseudocode:
START {

  PROMPT user to enter a password
  READ password

  IF isValidPassword(password) {
    DISPLAY "Password is strong."
  } ELSE {
    DISPLAY "Password does not meet the required conditions."
  }

} END


FUNCTION isValidPassword(password) {

  IF length of password < 8 {
    RETURN false
  }

  SET hasDigit = false
  SET hasSpecialChar = false
  SET specialCharacters = "!@#$%^&*()_+-=[]{};:'\"\\|,.<>?/"

  FOR each character in password {
    IF character is a digit {
      SET hasDigit = true
    }
    IF character is in specialCharacters {
      SET hasSpecialChar = true
    }
    IF hasDigit AND hasSpecialChar {
      RETURN true
    }
  }

  RETURN false

} END FUNCTION

