# JavaProjects

The Java I wrote while learning object-oriented programming, in June 2025.

One project, under `Student_Registrstion/`: a class XII science result system.
A student takes three optional courses (Physics, Chemistry, and Maths or
Biology) and two compulsory ones, each split into theory and lab components
with different weightings, and the program grades the total into Honours,
First, Second, Third or Failed.

| File | What it does |
|---|---|
| `Student.java` | The base class: a student's identity and enrolment |
| `ScienceStudent.java` | Extends `Student` with the science stream's subjects and grading |
| `Subject.java` | One subject, its theory and lab marks, and their weighting |
| `ResultManagement.java` | The entry point: enters five records, then reports the highest percentage and looks a student up by roll number |

The point of the exercise was the relationship between the classes. A
`ScienceStudent` *is a* `Student`, a `Student` *has* `Subject`s, and getting
that distinction right is most of what the code is for. The marks rules are
the interesting part: Physics, Chemistry and Biology are 70 theory plus 30
lab, Maths is 100 theory with no lab at all, and the compulsory courses are
60 plus 40. Encoding that without a pile of special cases in `main` was the
real problem.

## Running it

```bash
git clone https://github.com/adarshcod30/JavaProjects.git
cd JavaProjects/Student_Registrstion
javac *.java && java ResultManagement
```

JDK 17 or newer. There is no package declaration, so compiling in place works.
The directory name carries a typo I made in 2025 and have left alone, because
renaming it would break anything pointing here.

## Why this is still public

It is beginner code. Keeping it visible is the same discipline the rest of the
account runs on: publish the thing that can be checked, including the part
that is not impressive.

---

Part of four early repositories kept public as a record of where this started:
[First-repo](https://github.com/adarshcod30/First-repo) ·
[SecondRepo](https://github.com/adarshcod30/SecondRepo) ·
[JavaProjects](https://github.com/adarshcod30/JavaProjects) ·
[PythonProjects](https://github.com/adarshcod30/PythonProjects)
