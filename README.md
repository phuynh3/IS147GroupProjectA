( Group A ) Project name:
Banking System 

Members:
Alina Moughal, Phi Huynh, Ashraf Kizito, Alioune Mbaye, Fox Zhang, Jacob Kucinski.  

Roles: 
Project Manager-Alina, Coder-Phi Huynh, Tester-Alioune Mbaye, Frontend Developer-Fox Zhang, Systems Analyst-Ashraf Kizito. 

Project description:
Our group project focuses on developing a Banking System using IntelliJ- JAVA. The system is designed to allow users to create and manage bank accounts, perform deposits and withdrawals, check balances, and maintain transaction records. It demonstrates the use of object-oriented programming principles. The project’s main goal is to simulate a real-world banking operation, but in simpler terms. Showing how, as a group, we work together to develop a successful running program.

Task 2:
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

Task 3: 
Docker is a platform that lets you package applications and their dependencies into lightweight, portable containers. These containers ensure your app runs the same way on any system regardless of the operating system or setup. Everything it needs (like libraries, runtime, and configuration) is bundled inside the container. This makes development, testing, and deployment faster and more consistent.

Task 4: 

 Overview

In this task, we containerized a simple Java application using Docker and automated the build and push process to Docker Hub using GitHub Actions.

Steps Performed

1. Dockerfile Setup
   Created a Dockerfile using the `openjdk:23` base image.
   The file copies Java source files, compiles them, and runs the `HelloWorld` class.

   ```dockerfile
   FROM openjdk:23
   WORKDIR /app
   COPY src/ /app/
   RUN javac *.java
   CMD ["java", "HelloWorld"]
   ```

2. Docker Hub Configuration

   * Logged into Docker Hub.
   * Created a **Personal Access Token** with read/write/delete permissions.
   * Saved credentials for use in GitHub Secrets (`DOCKER_USERNAME` and `DOCKER_PASSWORD`).

3. GitHub Actions Workflow

   * Created a workflow file: `.github/workflows/docker.yml`.
   * Configured it to automatically build and push the Docker image to Docker Hub whenever changes are pushed to the `master` branch.

4. Automation Trigger

   * Committed and pushed changes to GitHub.
   * The GitHub Action built the Docker image and pushed it to Docker Hub automatically.

5. Run Docker Image
   Pulled and ran the image from Docker Hub:

   ```bash
   docker pull your-dockerhub-username/hello-world:latest
   docker run your-dockerhub-username/hello-world:latest
   ```

### Result

Successfully automated the process of building and deploying a Dockerized Java app using GitHub Actions and Docker Hub.

