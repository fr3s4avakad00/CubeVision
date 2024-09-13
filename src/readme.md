# **CubeVision**

CubeVision is a colorblindness testing tool designed to assess users' ability to distinguish colors through interactive cube-based tasks. The app educates users on different types of color vision deficiencies and provides an engaging experience.

## **Table of Contents**

- [Introduction](#introduction)
- [Features](#features)
- [Color Vision Deficiencies Covered](#color-vision-deficiencies-covered)
- [Instructions](#instructions)
- [Technology Stack](#technology-stack)
- [Project Structure](#project-structure)
- [How to Run](#how-to-run)
- [Future Enhancements](#future-enhancements)
- [License](#license)

## **Introduction**

CubeVision helps test for various types of colorblindness by providing tasks that challenge the user's ability to differentiate between different color shades using cubes. It serves as an educational tool to promote awareness of color vision deficiencies.

### **Purpose**

CubeVision's goal is to provide users with an interactive experience to assess their color vision and learn more about different types of colorblindness, such as red-green and blue-yellow deficiencies.

## **Features**

- **Interactive Color Vision Test**: Users identify cubes of different colors, focusing on their ability to distinguish subtle differences.
- **Audio Feedback**: The app plays audio feedback for user interactions (e.g., correct or incorrect responses).
- **Informative Panels**:
  - **Protan Vision**: Tests red-green colorblindness.
  - **Deutan Vision**: Tests another form of red-green colorblindness.
  - **Tritan Vision**: Tests blue-yellow colorblindness.

## **Color Vision Deficiencies Covered**

1. **Red-Green Colorblindness**:
   - **Protanopia**: Complete inability to see red tones.
   - **Protanomaly**: Reduced ability to see red tones.
2. **Green-Red Colorblindness**:
   - **Deuteranopia**: Complete inability to see green tones.
   - **Deuteranomaly**: Reduced ability to see green tones.
3. **Blue-Yellow Colorblindness**:
   - **Tritanopia**: Complete inability to see blue tones.
   - **Tritanomaly**: Reduced ability to see blue tones.

## **Instructions**

1. **Start the Test**: From the main menu, select which color vision test to begin (Protan, Deutan, or Tritan).
2. **Identify the Cube**: In each test, identify the cube that looks different from the others and click on it.
3. **Get Feedback**: If your answer is correct, you will hear a sound. Continue through the levels to test various color vision abilities.
4. **Learn More**: Definitions and information about the types of colorblindness are available within the app.

## **Technology Stack**

- **Java**: Core programming language.
- **Java Swing**: Used for creating the graphical user interface (GUI).
- **Audio Integration**: WAV file playback for sound feedback using `soundPlayer.java`.

## **Project Structure**

```
CubeVision/
├── bin/                     # Compiled class files
├── lib/                     # External libraries (if any)
├── src/                     # Source code
│   ├── CubeGame2.java        # Core logic for the game/test
│   ├── DuetanVision.java     # Handles Deutan (green-red) colorblindness test
│   ├── GameLoop.java         # Manages the main game loop
│   ├── main.class            # Compiled main class
│   ├── main.java             # Entry point of the app
│   ├── menu.java             # Main menu logic and layout
│   ├── ProtanVision.java     # Handles Protan (red-green) colorblindness test
│   ├── soundPlayer.java      # Audio feedback handler
│   ├── TritanVision.java     # Handles Tritan (blue-yellow) colorblindness test
│   └── VisionType.java       # Enum or logic that differentiates the vision types
├── Jazz_Cube.wav             # Sound file for audio feedback
├── README.md                 # Project documentation (this file)
```

### **Important Files**:

1. **main.java**: The entry point for the app, launching the main menu and handling navigation.
2. **menu.java**: Manages the main menu layout and interactions.
3. **CubeGame2.java**: Core file handling the colorblindness test logic.
4. **ProtanVision.java, DuetanVision.java, TritanVision.java**: Each of these handles the respective tests for different types of colorblindness.
5. **soundPlayer.java**: Handles the playback of sound effects during the test.
6. **Jazz_Cube.wav**: Audio file used to give feedback during user interaction.

## **How to Run**

1. **Compile the Source Code**: 
   Navigate to the project folder and compile the Java files in the `src` directory:
   ```bash
   javac -d bin/ src/*.java
   ```

2. **Run the Application**: 
   After compiling, go to the `bin` directory and run the main class:
   ```bash
   java main
   ```

3. The main menu will appear, and you can start taking the colorblindness test.

## **Future Enhancements**

- **More Visual Tests**: Adding additional color vision tests for more accuracy.
- **User Progress Tracking**: Store user performance data to track improvement over time.
- **Mobile Version**: Build a version of CubeVision that runs on Android and iOS devices.
- **Improved Accessibility**: Adding more features to make the app easier to use for people with low vision.

## **License**

This project is licensed under the MIT License. Feel free to use, modify, and distribute this project as long as the original license is included.
