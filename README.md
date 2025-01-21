# HI I´M WILLIAM Android Developer

## Introduction
This README serves as a guide for developers working on the Android application utilizing Hilt, Dagger, MVVM, Retrofit, Paging, Jetpack Compose, Coroutines, and robust testing frameworks. It outlines the project structure, dependencies, and best practices to ensure a seamless development experience.

---

## Table of Contents
1. [Project Overview](#project-overview)
2. [Getting Started](#getting-started)
3. [Project Structure](#project-structure)
4. [Dependencies](#dependencies)
5. [Development Guidelines](#development-guidelines)
6. [Building and Running](#building-and-running)
7. [Testing](#testing)
8. [Contributing](#contributing)
9. [License](#license)

---

## Screenshots Tablet

|<img src="screenshots/Liverpool Tablet.png" width=200/>|<img src="screenshots/Liverpool Tablet2.png" width=200/>|<img src="screenshots/Liverpool Tablet 3.png" width=200/>|
## Screenshots 
|<img src="screenshots/Screenshot_20250121_021721_Liverpool Test Product Search.jpg" width=200/>|<img src="screenshots/Screenshot_20250121_045846_Liverpool Test Product Search.jpg" width=200/>|
## Screenshots Test
|<img src="screenshots/Unit Test.png" width=200/>|

## Project Overview
This project leverages modern Android development tools and frameworks, including:
- **Hilt** for dependency injection.
- **Dagger** for advanced DI scenarios.
- **MVVM** (Model-View-ViewModel) architecture for clean separation of concerns.
- **Retrofit** for network operations.
- **Paging** for efficient data pagination.
- **Jetpack Compose** for modern UI development.
- **Coroutines** for asynchronous programming.
- Testing with **JUnit**, **MockK**, and **Espresso**.
- Common design patterns like Repository, Singleton, and Factory for scalable and maintainable code.

---

## Getting Started
### Prerequisites
- Android Studio (latest stable version)
- Java Development Kit (JDK 11 or higher)
- A physical or virtual Android device (API level 21 or higher)

### Installation Steps
1. Clone the repository:
   ```bash
   git clone <repository_url>
   ```
2. Open the project in Android Studio.
3. Sync the project with Gradle files.
4. Configure an Android device/emulator.

---

## Project Structure
```
project-root
|-- app/                  # Main application module
|   |-- src/main/         # Source files
|   |   |-- java/         # Java/Kotlin source code
|   |   |   |-- di/       # Dependency Injection setup
|   |   |   |-- data/     # Data layer (repositories, models, etc.)
|   |   |   |-- ui/       # View layer (activities, fragments, Compose components, etc.)
|   |   |   |-- viewmodel/ # ViewModel layer
|   |   |-- res/          # Resources (layouts, drawables, etc.)
|   |-- build.gradle      # Module-level Gradle config
|-- build.gradle          # Project-level Gradle config
|-- gradle/               # Gradle wrapper files
|-- settings.gradle       # Gradle settings
```

---

## Dependencies
- **[Hilt](https://developer.android.com/training/dependency-injection/hilt)**: Simplifies dependency injection.
- **[Dagger](https://dagger.dev/)**: Used for advanced DI scenarios.
- **[Retrofit](https://square.github.io/retrofit/)**: REST API client.
- **[Kotlin Coroutines](https://kotlinlang.org/docs/coroutines-overview.html)**: For managing asynchronous tasks.
- **[Paging Library](https://developer.android.com/topic/libraries/architecture/paging)**: Efficient data pagination.
- **[Jetpack Compose](https://developer.android.com/jetpack/compose)**: For building modern UIs.
- **[MockK](https://mockk.io/)**: For mocking in unit tests.
- **[JUnit](https://junit.org/)**: For unit testing.
- **[Espresso](https://developer.android.com/training/testing/espresso)**: For UI testing.
- **[Jetpack Components](https://developer.android.com/jetpack)**: LiveData, ViewModel, Navigation, etc.
- **Gson**: For JSON serialization/deserialization.

---

## Development Guidelines
1. **Architecture:** Follow the MVVM pattern.
2. **Dependency Injection:** Use Hilt for injecting dependencies. Define modules in the `di/` package.
3. **Networking:** Use Retrofit for API calls. Define all API interfaces and Retrofit instances in the `data/` package.
4. **Asynchronous Programming:** Use Kotlin Coroutines for background tasks and LiveData for observing data changes.
5. **UI Development:** Build UI with Jetpack Compose. Use state management for reactive updates.
6. **Pagination:** Implement the Paging Library for loading large datasets efficiently.
7. **Error Handling:** Implement error handling at the repository level and propagate user-friendly messages to the ViewModel.
8. **Code Styling:** Adhere to Kotlin coding conventions and use consistent naming patterns.
9. **Unit Testing:** Write tests for ViewModels, repositories, and use mocked dependencies with MockK.

---

## Building and Running
1. Ensure all dependencies are installed and Gradle is synced.
2. Select the desired build variant (e.g., debug, release).
3. Run the application using:
   - The "Run" button in Android Studio, or
   - Command line:
     ```bash
     ./gradlew assembleDebug
     ```

---

## Testing
1. Run unit tests:
   ```bash
   ./gradlew test
   ```
2. Run instrumentation tests:
   ```bash
   ./gradlew connectedAndroidTest
   ```
3. Use MockK for mocking dependencies in unit tests.
4. Test UI components with Jetpack Compose testing tools and Espresso.

---

## Contributing
1. Fork the repository and create a feature branch.
2. Follow the coding and architectural guidelines.
3. Commit changes with clear messages.
4. Submit a pull request for review.

---

## License
This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

