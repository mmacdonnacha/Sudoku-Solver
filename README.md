# Sudoku Solver

A Java based sudoku solver that uses logic instead of brute force to solve.

**Techniques used**
- Level 0
  - Naked Single 
    - If a cell has a single candidate, that candidate solves the cell.
  - Unique  
    - If you find a candidate for a particular number in a single cell of a row, column or box, the candidate must solve the cell.
  - CleanUp 
    - When you solve a cell the number solves it cannot be a candidate anywhere else in any of the row, column or box to which the cell belongs.

- Level 1
  - Naked Pair 
    -  If two cells in the same row ,column or box only ontain the same two candidates, it means that one of those candidates will solve one of the two cells and the other candidate will solve the other cell. Therefore you can remove the same candidates from all other cells of the unit.
  