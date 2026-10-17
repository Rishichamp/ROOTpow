# Power and Root Calculator Android App

[![build](https://github.com/Rishichamp/ROOTpow/actions/workflows/build.yml/badge.svg)](https://github.com/Rishichamp/ROOTpow/actions/workflows/build.yml)

This Android application calculates **power and root values** based on user input.

The app allows users to compute:

- **Power (a^b)**
- **Root (b-th root of a)**

The project is built using **Java and Android Studio** and demonstrates how Android UI components like **EditText, Button, Spinner, and TextView** can be used to perform mathematical calculations.

---

## Purpose

This project was created as a learning exercise to understand how to build an **Android calculator application that performs power and root operations**.

It demonstrates:

- Taking numeric input from users
- Using a **Spinner dropdown menu** for selecting operations
- Performing mathematical computations using Java
- Displaying results dynamically in the Android interface

---

## Features

- Power calculation (a^b)
- Root calculation (b-th root of a)
- Simple and clean user interface
- Operation selection using **Spinner**
- Result displayed instantly
- Input validation for empty fields

---

## Technologies Used

- Java
- Android Studio
- Android SDK
- XML Layouts
- Spinner (Dropdown UI Component)

---

## Project Structure

Main components of the project:

- `MainActivity.java` → Handles user input, spinner selection, and power/root calculations  
- `activity_main.xml` → Defines the user interface layout  
- `strings.xml` → Contains spinner options for power and root operations  

---

## How the App Works

1. The user enters two numbers.
2. The user selects an operation from the **Spinner dropdown**.
3. The user presses the **Calculate button**.
4. The app performs the selected operation.

Supported operations:

- Power → `a^b`
- Root → `b-th root of a`

Example:

```
Input: a = 8 , b = 3
Operation: Root
Output: Answer = 2.00
```

---

## Screenshots

<p align="center">
  <img src="rootpow_1.png" width="200">
  <img src="rootpow_2.png" width="200">
  <img src="rootpow_3.png" width="200">
</p>

---

## 2026 update

- **Tooling:** upgraded from Gradle 7.3 / AGP 7.2 (which don't run on the JDK 21 in current Android Studio) to Gradle 8.11.1, AGP 8.7.3, compileSdk 35 / targetSdk 34, Java 17 and current AndroidX libraries.
- Typing just "." crashed the app; now it shows an error.
- `Math.pow(-8, 1/3)` is NaN in Java, so odd roots of negative numbers failed; the cube root of -8 is now -2.
- A root of degree 0, even roots of negatives and overflowing powers now show clear messages instead of NaN/Infinity.
- The empty-field message was set on a hidden view, so it never appeared; the button reads **Calculate**.
- **Tests:** 5 unit tests and 4 on-device UI tests, all passing on an Android 11 emulator, plus a 2,000-event monkey stress test with no crashes. GitHub Actions builds, unit-tests and lints the app on every push.

## Author

Rishi Singh
