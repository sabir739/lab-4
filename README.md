📘 Java Lab Assignment 4
Student Record Management System With File Handling & Collections
Persistent Storage • Sorting • Iterator • Comparator • RandomAccessFile
📌 Project Overview

This assignment extends the Student Management System by adding persistent storage using file handling in Java. The system loads student records from a file (students.txt) at startup and saves updated records when the program exits.

It uses:

ArrayList / HashMap to store student data

BufferedReader / BufferedWriter for file operations

Comparator for sorting students by marks

Iterator for displaying student records

RandomAccessFile for demonstrating random record reading

File class for showing file properties

The program offers a menu-driven interface to add, view, sort, search, delete, and save student data.

🧱 Key Concepts Implemented
✔ 1. File Handling

Load students from students.txt

Save records on exit

Use BufferedReader, BufferedWriter

Read random positions using RandomAccessFile

Show file metadata using the File class:

file size

absolute path

read/write permissions

✔ 2. Collections API

ArrayList<Student> for flexible list management

HashMap<String, Student> for fast name-based search/delete

Iterator for displaying student entries

Comparator for sorting by marks

✔ 3. Sorting

Sort students by marks (descending)

Sort students by name (alphabetical)

Demonstrates:

Comparator<Student>

Collections.sort()

📂 Project Structure
src/
 ├── FileUtil.java
 ├── Student.java
 ├── StudentManager.java
 └── MainApp.java
students.txt
README.md

▶️ How the Program Works
1. Program Start

Reads file students.txt

Displays loaded records:

Loaded students from file:
Roll No: 101
Name: Ankit
Email: ankit@mail.com
Course: B.Tech
Marks: 85.5
...

2. Menu Options
===== Capstone Student Menu =====
1. Add Student
2. View All Students
3. Search by Name
4. Delete by Name
5. Sort by Marks
6. Save and Exit

3. Example Input
Enter Roll No: 103
Enter Name: Karan
Enter Email: karan@mail.com
Enter Course: BCA
Enter Marks: 76.2

Sorted Output Example
Sorted Student List by Marks:
Roll No: 102
Name: Riya
Email: riya@mail.com
Course: M.Tech
Marks: 91.0

💾 File Format (students.txt)

Each student record is stored as:

rollNo,name,email,course,marks
101,Ankit,ankit@mail.com,B.Tech,85.5
102,Riya,riya@mail.com,M.Tech,91.0


CSV-like formatting for easy parsing.

🎯 Learning Outcomes

By completing this assignment, you will learn to:

Read & write files using Java I/O streams

Persist student data using files

Apply Collections API (List, Map, Iterator)

Implement sorting using Comparator

Use RandomAccessFile for random reads

Display file attributes

Develop modular Java applications

🛠 Technologies Used

Java I/O (BufferedReader, BufferedWriter, File, RandomAccessFile)

Collections Framework (ArrayList, HashMap, Iterator, Comparator)

OOP

📤 Expected Output Screen (Summary)
Loaded students from file:
Roll No: 101
Name: Ankit
Marks: 85.5
Roll No: 102
Name: Riya
Marks: 91.0

===== Capstone Student Menu =====
1. Add Student
2. View All Students
3. Sort by Marks
...

Sorted Student List by Marks:
Roll No: 102
Name: Riya
Marks: 91.0

👨‍💻 Author

Sabir Ali
Java Programming Lab — Assignment 4
