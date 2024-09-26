# Italotreno Automation Project

## Overview

This project aims to automate the ticket booking process on the Italotreno website using Selenium and TestNG in IntelliJ with Java. The automation suite ensures efficient testing and validation of the booking process while overcoming challenges posed by the website's detection of automated software.

## Features

- **Automated Booking**: Simulates the entire booking process from searching for trains to completing a reservation.
- **Cross-Browser Testing**: Utilizes an XML configuration to run tests on multiple browsers.
- **Page Object Model**: Implements the Page Object Model (POM) design pattern for better code organization and maintainability.
- **Error Handling**: Includes mechanisms to handle errors arising from bot detection on the Italotreno site.

## Technologies Used

- **Java**: Programming language used for automation scripts.
- **Selenium**: Framework for automating web applications.
- **TestNG**: Testing framework for running and managing tests.
- **IntelliJ IDEA**: Integrated Development Environment (IDE) for Java development.
- **Page Object Model (POM)**: Design pattern used for creating object-oriented tests.

## Installation

To run this project locally, follow these steps:

1. Clone the repository:
   ```bash
   git clone https://github.com/jphm95/Italotreno_Automated_Test.git

2. Navigate to the project directory:
    ```bash
   cd Italotreno_Automated_Test

3. Open the project in your prefered IDE.
   
4. Ensure you have the necessary dependencies installed (Selenium, TestNG). You can use Maven to manage dependencies.

5. Run the tests using TestNG.

## Challenges and Solutions

- **Bot Detection:**: The Italotreno website has mechanisms to detect automated scripts. This project includes custom code to mimic human behavior, helping to avoid detection.
- **Dynamic Elements:**: Handling dynamically loaded elements was challenging. Explicit waits were implemented to ensure elements are fully loaded before interaction.

## Future Work


- ** **: Enhance the test suite with more edge cases and scenarios.
- ** **: Integrate additional features like user login and payment processing.
- ** **: Creation of Assertions
- ** **: Data Provider using Excel Files
- ** **: Screenshots 


