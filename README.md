# THE GAME OF LIFE

## Overview

The game of life is a cellular automaton invented by the mathematician John Conway.
Is a zero player game since it's evolutions is determined by its initial state.

## Rules

1. Any live cell with fewer than two live neighbours dies, as if by underpopulation.
2. Any live cell with two or three live neighbours lives on to the next generation.
3. Any live cell with more than three live neighbours dies, as if by overpopulation.
4. Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.

These rules, which compare the behaviour of the automaton to real life, can be condensed into the following:

1. Any live cell with two or three live neighbours survives.
2. Any dead cell with three live neighbours becomes a live cell.
3. All other live cells die in the next generation. Similarly, all other dead cells stay dead.

You can find more information of the game of life in [wikipedia](https://en.wikipedia.org/wiki/Conway%27s_Game_of_Life)

## What you should do?

You must implement the game of life using TDD (Test Driven Development). 
Test - Code - Refactor cycles.