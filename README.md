# Student Data Entry System (Java + MySQL + JDBC)

## Overview
This project is a Java console-based application to manage student data using JDBC and MySQL.

## Functionalities
- Add Student
- Display All Students
- Search Student by PRN
- Search Student by Name
- Update Student
- Delete Student

## Setup
1. Install MySQL and create the `studentdb` database with the following table:

```sql
CREATE DATABASE IF NOT EXISTS studentdb;
USE studentdb;
CREATE TABLE IF NOT EXISTS students (
    prn VARCHAR(20) PRIMARY KEY,
    name VARCHAR(100),
    department VARCHAR(100)
);
```

2. Update your MySQL username and password in `DBConnection.java`.

3. Compile and run `Main.java` from the `src/` folder.
