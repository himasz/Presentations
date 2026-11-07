# Python for the Lecture: guide examples

One Python file and one Java file per code slide of "Python for the Lecture: A Presenter's Guide".

- Python: `python3 <file>`. Comments starting with `#>` show exactly what that line prints; `#!` shows what `mypy <file>` reports.
- Java: in `java/`, `javac -d out G03Strings.java && java -cp out Main`. Comments starting with `//>` show printed output; `//!` shows the compiler's error for the `//?` line (remove `//? ` to see it).
- `r05_mypy.py` crashes on purpose when run with python3 (AttributeError). That's the point of the slide: mypy finds the bug without running it.
- `t01_pytest_demo.py`: copy it to `test_demo.py` and run `pytest -q test_demo.py` (4 passed). `java/G41JUnit.java` is the JUnit 5 version; it needs JUnit on the classpath (`java/stubs/` holds minimal stand-ins used only to compile-check it).
- `setup.sh`, `java_setup.sh` and `t02_demo.sh` are notes to read, not scripts to execute.
- Part 4 of the guide uses the lecture files one folder up (Python) and in `../java` (Java).

Requires Python 3.10+ and Java 21+.
