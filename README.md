# Code-Challenge
You are developing an application (preferably in Java/C++/C#) that will allow a client to access student information in a database.  The “database” will be in a FILE.  Data in the file shall be in the following CSV format:

`Class, Professor, Student ID`

where

`Class = History, Chemistry, Physics, Mathematics [ONLY 4 types]`  
`Professor = “a string”`  
`Student ID = “an integer”`  

The application shall be used to retrieve the following information:
- The list of class sections being taught (I.e., unique Class/Professor pairs)
- The list of classes being taken by each student
- How many students are registered for each Class?  List them.
- How many students take more than one Class?  List them.
- How many professors teach more than one Class?

## Additional Requirements:

- Your code should either be in an IDE project or be buildable from the command line with one command.  If submitted as an IDE project, the only steps should be to load the project and run it.  No dependencies should have to be manually downloaded, etc.  For command line builds, tell us the command to build the app and the command to run it.  For both IDE projects and command line projects, it shouldn’t be required to change Windows-style paths to Unix-style paths or vice-versa.
- UI is not required
- The "file" can be updated with new information (additions and/or deletions). (You are not required to provide functionality to edit the file.)
- Include unit tests that validate the code you have written (you should strive for 90%+ coverage)
- Make sure there is ample error handling.

## Sample Data – CSV Format

```
Chemistry, Joseph, 1234
Chemistry, Jane, 3455
History, Jane, 3455
Mathematics, Doe, 56767
Physics, Smith, 999
Physics, Einstein, 2834
History, Smith, 323
History, Smith, 999
Chemistry, Jane, 999
Physics, Smith, 323
Mathematics, Einstein, 3455
```

## Sample Answers

```
Class Sections Taught:
    Chemistry, Joseph
    Chemistry, Jane
    History, Jane
    Mathematics, Doe
    Physics, Smith
    Physics, Einstein
    History, Smith
    Mathematics, Einstein

Classes Taken By Each Student:
    1234:  Chemistry
    3455:  Chemistry, History, Mathematics
    56767: Mathematics
    999:   Physics, History, Chemistry
    2834:  Physics
    323:   History, Physics

How many students are registered for each class?
    Chemistry: 3
    History: 3
    Mathematics: 2
    Physics: 3

How many students take more than one class?
    3: 3455, 999, 323

How many professors teach more than one class?
    3: Jane, Smith, Einstein
```
