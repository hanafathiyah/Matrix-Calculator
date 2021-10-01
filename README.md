# Tubes Aljabar Linear & Geometri 1

This is our first project that maintained by 3 people :
* Hana Fathiyah - 13520047
* Bayu Samudra - 13520128
* Febryola Kurnia Putri - 13520140

## What is This Project About?
we made this project in order to fill the requirements of Linear and Geometric Algebra class in ITB
informatic engineering. this project consist of several features:

* Linear equation
* Determinan
* Matrix Inverse
* Polynomial Interpolation
* Bilinier Regression

Note : All the features above can read and write test cases either in file or console.

## The Process
This Project was made under several conditions:
* Using Java SE Runtime Environment (JDK 17 version and JRE)
* Using Maven 3.8.2 to automate build the program
* Created using intelliJ idea (new version)

## Folder Structure
* github: contains workflow
* idea: contains file xml (.xml)
* bin: contains java byte code (.class)
* doc: contains pdf file of this project (.pdf)
* src/tubes/algeo: contains source code (.java)
* test: contains file testing (.java)

## How to build
Make sure you have installed maven and JDK in your computer.

After that, to run this app, please run:
```shell
mvn package assembly:single
```
or simply you can run makefile:
```shell
make build
```

## How to run
To run this program, you can run this command:
* Windows
```powershell
./run.bat
```

* Linux/Mac OS
```bash
./run.sh
```

* Makefile : This command will build and run the program
```bash
make
```

* Jar file
```bash
java -jar bin/tubes-algeo.jar
```
