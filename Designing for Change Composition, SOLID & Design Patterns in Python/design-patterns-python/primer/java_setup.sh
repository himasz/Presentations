# 1. Check the version
java -version

# 2. No venv: dependencies are declared per
#    project, in pom.xml (Maven) or build.gradle

# 3. Fetch them (JUnit, for example)
mvn dependency:resolve

# 4. Run things
java Hero.java       # run one source file
jshell               # interactive REPL
mvn test             # run all tests
javac *.java         # compiling = type-checking
