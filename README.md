---

# QR Scanner App

## Overview

The QR Scanner App is an basic Android application that allows users to scan QR codes using the device's camera. Built with Kotlin and leveraging the `journeyapps` barcode scanner library, this app provides a simple interface for scanning and displaying QR code content.

## Features

- Scan QR codes using the device camera
- Display scanned QR code content in the app
- Modern user interface with a floating action button (FAB) for scanning

## Installation

To run the QR Scanner App, follow these steps:

1. **Clone the Repository:**

   ```bash
   git clone [https://github.com/Pradeesh-Saravanan/qrscanner.git](https://github.com/Pradeesh-Saravanan/QR-Scanner-App.git)
   ```

2. **Open the Project:**

   Open the project in Android Studio or your preferred IDE.

3. **Build the Project:**

   Make sure to sync the Gradle files and build the project.

4. **Run the App:**

   Connect an Android device or use an emulator and run the app from Android Studio.

## Permissions

The app requires the following permissions:
- Camera: To scan QR codes

Make sure to grant these permissions when prompted by the app.

## Usage

1. **Open the App:**

   Launch the QR Scanner App on your device.

2. **Scan a QR Code:**

   Tap the floating action button (FAB) to start scanning. Point your device's camera at the QR code.

3. **View Results:**

   The scanned QR code content will be displayed on the screen.

## Dependencies

The app uses the following dependencies:

- **JourneyApps Barcode Scanner:** For QR code scanning
  ```gradle
  implementation 'com.journeyapps:zxing-android-embedded:4.4.0'
  ```

- **Material Components:** For UI elements like the FloatingActionButton and BottomAppBar
  ```gradle
  implementation 'com.google.android.material:material:1.9.0'
  ```

## Contributing

Contributions are welcome! If you have suggestions or improvements, please open an issue or submit a pull request.

1. **Fork the Repository**
2. **Create a Feature Branch**
   ```bash
   git checkout -b feature/new-feature
   ```
3. **Commit Your Changes**
   ```bash
   git commit -am 'Add new feature'
   ```
4. **Push to the Branch**
   ```bash
   git push origin feature/new-feature
   ```
5. **Create a New Pull Request**

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

## Contact

For any questions or feedback, you can reach out to:

- **Email:** pradeeshpradeesh7040@gmail.com
- **GitHub:** [Pradeesh Saravanan](https://github.com/Pradeesh-Saravanan)

---
