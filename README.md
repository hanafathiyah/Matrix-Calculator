# Tubes Aljabar Linear & Geometri 1

This is our first project that maintained by 3 people :
* Hana Fathiyah - 13520047
* Bayu Samudra - 13520128
* Febryola Kurnia Putri - 13520140

# What is This Project About?
we made this project in order to fill the requirements of Linear and Geometric Algebra class in ITB
informatic engineering. this project consist of several features:

* Linear equation
* Determinan
* Matrix Inverse
* Polynomial Interpolation
* Bilinier Regression

Note : All the features above can read and write test cases either in file or konsol.

# The Process
This Project was made under several conditions:
* Using Java SE Runtime Environment (JDK 17 version and JRE)
* Created using intelliJ idea (new version)

# Project Structure
tubes.algeo/
├── bin/                                                  # Contains java byte code (.class)
├── docs/                                                 # Contains file pdf of this project (.pdf)
├── src/tubes/algeo                                       # Contains source code (.java)                              
      ├── lib/                                            # Contains all library matrix needed in this program
              ├── error/                               # Interface of Matrix
                    ├── InterpolasiException
                    ├── Regresi Exception
              ├── type                             # Useful functions for Matrice
                    ├── Type
                    ├── Type
                    ├── Type
              
              ├── Type
              
              ├── Type
              
              ├── util                          # Matrice Builder
              ├── MatrixOperation                         # Interface of MatrixOperation
      ├── menu/                                        # Contains operations of every calculations
              ├── Crammer                                 # Operates Cramer's Rule
              ├── Gauss                                   # Operates Gaussian Elimination
              ├── GaussJordan                             # Operates Gauss-Jordan Elimination
              ├── GaussMethod                             # Interface of Gauss, GaussJordan, and InverseGaussJordan
              ├── InverseGaussJordan                      # Operates Inverse using Gauss-Jordan Elimination
              ├── InverseSPL                              # Operates Inverse using Adjoint
              ├── SolutionExaminer                        # Gives output of Linear Equation System after using one of those calculations
              ├── Solutions                               # Linear Equation System types, including single solution, multiple solution, and no solution
              ├── SPLMethods                              # Interface of Crammer and InverseSPL
      ├── App                                             # Contains MatrixTrait
              ├── MatrixTrait                             # Matrice types, including square matrice (N x N), zero matrice (0 for all elements), and identity matrice
      ├── utils/                                          # Contains menus, Base26, and NUtils
              ├── menu/                                   # Contains menus and the interface
                    ├── menus/                            # Contains menus
                           ├── main/                      # Contains main menus
                                  ├── DMenu               # Main menu for Determinant
                                  ├── InputMenu           # Menu for input (choose between input from console or file)
                                  ├── IntMenu             # Menu for Polynomial Interpolation
                                  ├── InversMenu          # Main menu for Inverse
                                  ├── MainMenu            # Main menu
                                  ├── SPLMenu             # Main menu for Linear Equation System
                           ├── sub/                       # Contains sub menus
                                  ├── AdjMenu             # Sub menu of InversMenu (Adjoint)
                                  ├── CramMenu            # Sub menu of Linear Equation System (Cramer's Rule)
                                  ├── DEKMenu             # Sub menu of Determinant (Cofactor Expansion)
                                  ├── DRBMenu             # Sub menu of Determinant (Line Reduction)
                                  ├── GaussMenu           # Sub menu of Linear Equation System (Gaussian Elimination, Gauss-Jordan Elimination, and Inverse)
                    ├── XMenu                             # Interface and functions for menus
             ├── Base26                                   # To change integer to string
             ├── NUtils                                   # Functions for better precision
     ├── MtrxMain                                         # To start main menu
├── test/tubes/algeo                                               # Contains all test cases given


# How to build and run
Make sure you have installed maven in your computer.

After that, to run this app, please run:
```shell
mvn package assembly:single
java -jar bin/tubes-algeo.jar
```
or you can run makefile:
```shell
make
```
