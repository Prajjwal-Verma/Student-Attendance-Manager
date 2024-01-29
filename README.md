# Student Attendance Manager - Android Project

Welcome to the Student Attendance Manager Android project repository! This project is designed to help you manage attendance for students using an Android application. The attendance data is stored in a local MySQL database.

## Installation

To set up this project in Android Studio, follow these steps:

1. **Clone the Repository:**
   Clone this repository to your local machine using the following command:

   ```
   git clone https://github.com/your-username/student-attendance-manager.git
   ```

2. **Open in Android Studio:**
   - Launch Android Studio.
   - Choose "Open an existing Android Studio project."
   - Navigate to the directory where you cloned the repository and select the project folder (`student-attendance-manager`).

3. **Set Up MySQL Database:**
   - Make sure you have a MySQL server installed locally or remotely.
   - Create a MySQL database named `student_attendance`.
   - Import the SQL file provided (`student_attendance.sql`) into your MySQL database. This file contains the necessary tables and initial data for the project.

4. **Configure MySQL Connection:**
   - Open the `DatabaseHelper.java` file located in `app/src/main/java/com/example/studentattendancemanager/utils/`.
   - Modify the `DB_NAME`, `DB_USER`, and `DB_PASSWORD` variables to match your MySQL database credentials.

5. **Build and Run:**
   - After configuring the database connection, you can build and run the project on an Android emulator or a physical device.
   - Select the appropriate target device and click on the "Run" button in Android Studio.

## Features

- **Attendance Management**: Easily record and manage student attendance.
- **Local MySQL Storage**: Utilizes a local MySQL database for storing attendance data.
- **User-Friendly Interface**: Intuitive user interface for efficient navigation and interaction.

## Contributing

Contributions are welcome! If you find any issues or would like to enhance the project, feel free to open a GitHub issue or create a pull request with your proposed changes.

## License

This project is licensed under the [MIT License](LICENSE).

---

Feel free to reach out if you encounter any problems during installation or have any questions about the project!
