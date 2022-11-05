# Sudoku Validator

## Build the jar:
```
mvn clean install
```

This will generate jar in `target` folder.

## Run the jar:
Sample file to check: `sudoku_test_mix_test.txt`
```
java -cp ./target/sudokuvalidator-1.0-SNAPSHOT.jar io.marianasilvago.SudokuValidatorApp -f "./sudoku_test_mix_test.txt"
```

### Output:
```
Skipping this sudoku board due to parsing error.
Error: PARSE_ERROR, Message: For input string: "aa"
Invalid sudoku board:
2 0 0 0 8 0 3 0 0
0 aa 0 0 7 0 0 8 4
0 3 0 b 0 0 2 0 9
0 0 0 1 0 5 4 0 8
0 dd 0 0 0 0 0 0 0
4 0 2 7 c 6 0 0 0
3 0 1 0 0 7 0 4 0
7 2 0 0 4 0 0 6 0
0 0 4 0 1 0 0 0 3

Skipping this sudoku board due to parsing error.
Error: PARSE_ERROR, Message: Cell value is greater than board length = 9.
Invalid sudoku board:
0 0 3 0 2 0 6 0 0
9 0 0 3 0 5 0 0 1
0 0 1 8 0 6 4 0 0
0 0 8 1 0 2 9 0 0
7 0 0 10 0 0 0 0 8
0 0 6 7 0 8 2 0 0
0 0 2 6 0 9 5 0 0
8 0 0 2 0 3 0 0 9
0 0 5 0 1 0 3 0 0

Skipping this sudoku board due to parsing error.
Error: PARSE_ERROR, Message: Cell value is less than 0.
Invalid sudoku board:
0 0 3 0 2 0 6 0 0
9 0 0 3 0 5 0 0 1
0 0 -1 8 0 6 4 0 0
0 0 8 1 0 2 9 0 0
7 0 0 0 0 0 0 0 8
0 0 6 7 0 8 2 0 0
0 0 2 6 0 9 5 0 0
8 0 0 2 0 3 0 0 9
0 0 5 0 1 0 3 0 0

Skipping this sudoku board due to parsing error.
Error: INVALID_SHAPE_BOARD_ERROR, Message: Sudoku board is not square. It is of shape(8, 9).
Invalid sudoku board:
0 0 3 0 2 0 6 0 0
9 0 0 3 0 5 0 0 1
0 0 1 8 0 6 4 0 0
0 0 8 1 0 2 9 0 0
7 0 0 0 0 0 0 0 8
0 0 6 7 0 8 2 0 0
0 0 2 6 0 9 5 0 0
8 0 0 2 0 3 0 0 9

VALID
Sudoku board is valid. 
Sudoku board:
5 3 4 | 6 7 8 | 9 1 2 
6 7 2 | 1 9 5 | 3 4 8 
1 9 8 | 3 4 2 | 5 6 7 
- - - - - - - - - - - 
8 5 9 | 7 6 1 | 4 2 3 
4 2 6 | 8 5 3 | 7 9 1 
7 1 3 | 9 2 4 | 8 5 6 
- - - - - - - - - - - 
9 6 1 | 5 3 7 | 2 8 4 
2 8 7 | 4 1 9 | 6 3 5 
3 4 5 | 2 8 6 | 1 7 9 


INVALID
Error: INVALID_CELL_VALUE, Message: Invalid value found at cell(4, 5) = 8.
Sudoku board:
5 3 4 | 6 7 8 | 9 1 2 
6 7 2 | 1 9 5 | 3 4 8 
1 9 8 | 3 4 2 | 5 6 7 
- - - - - - - - - - - 
8 5 9 | 7 6 1 | 4 2 3 
4 2 6 | 8 5 8 | 7 9 1 
7 1 3 | 9 2 4 | 8 5 6 
- - - - - - - - - - - 
9 6 1 | 5 3 7 | 2 8 4 
2 8 7 | 4 1 9 | 6 3 5 
3 4 5 | 2 8 6 | 1 7 9 

```