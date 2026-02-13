Complete Selenium Automation Project
📌 Overview

This project demonstrates a complete end-to-end Selenium WebDriver automation workflow using Java.
It covers real-world automation scenarios including login, cart operations, checkout process, screenshots, window handling, alerts, iframes, and advanced user interactions.

The automation runs against:

https://www.saucedemo.com/
 (E-commerce demo site)

https://demoqa.com/
 (Alert & Frame handling practice site)

🚀 Technologies Used

Java

Selenium WebDriver

ChromeDriver

WebDriverWait (Explicit Wait)

ChromeOptions

Actions Class

Java File Handling (Screenshot Utility)

🔥 Features Implemented
1️⃣ Browser Configuration

Launch Chrome in Incognito mode

Disable browser notifications

Start browser maximized

Apply implicit wait

2️⃣ E-Commerce Flow Automation

Login with valid credentials

Validate successful login

Add product to cart

Navigate to cart page

Complete checkout process

Validate order confirmation message

Capture screenshots at key steps

3️⃣ Screenshot Utility

Screenshots are automatically saved to:

Desktop/

File naming format:
StepName_yyyyMMdd_HHmmss.png

Example:
LoginSuccess_20260214_153020.png

4️⃣ Actions Class Usage

Hover and click on dynamic menu elements

5️⃣ Window Handling

Open new tab using JavaScript

Switch between parent and child window

Close child window

Switch back to parent window

6️⃣ Alert Handling

Trigger JavaScript alert

Wait until alert is present

Accept alert

7️⃣ IFrame Handling

Switch to iframe

Capture text inside iframe

Switch back to default content

🛠 How to Run the Project
Install Selenium
Download ChromeDriver

Download ChromeDriver matching your Chrome browser version.

If required, set system property:

Run the project 
Execution Flow:

Launch browser

Login to SauceDemo

Add product to cart

Complete checkout

Open DemoQA in new tab

Handle alert

Handle iframe

Close browser

🖥 Expected Console Output
Login Successful
Order Completed
Frame Text: This is a sample page
Execution Completed Successfully

📚 Concepts Covered

WebDriver Initialization

Locators (ID, Name, CSS Selector, XPath, ClassName)

Implicit Wait

Explicit Wait

Actions Class

Window Handling

Alert Handling

IFrame Handling

Screenshot Capture

Exception Handling (Try-Catch-Finally)

🎯 Project Purpose

This project is ideal for:

Selenium beginners

QA Automation practice

Interview preparation

Resume demonstration project

Understanding real-time automation scenarios

👨‍💻 Author

Sudarshan
QA Automation



