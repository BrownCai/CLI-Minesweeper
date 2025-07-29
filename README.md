# MineSweeper - Terminal Edition

[简体中文](README_zh.md) | [English](README.md)

## Introduction
This is a terminal-based Minesweeper game implemented in Java. Players must reveal all non-mine squares without triggering any mines to win the game, featuring three difficulty levels and complete game functionality.

## Features
- **Three Difficulty Levels**:
    - Easy (10x10 grid)
    - Normal (15x15 grid)
    - Difficult (20x20 grid)
- **Random Mine Generation**: Each game generates a different number of mines
- **Flagging System**: Mark suspected mine positions
- **Area Expansion**: Automatic expansion of safe adjacent areas
- **Game State Detection**: Real-time win/lose condition checking
- **Clean Interface**: Terminal-friendly display with clear visualization

## Requirements
- Java 8 or higher
- Terminal-supported OS (Windows/Linux/macOS)

## How to Run
1. Compile all Java files:
   ```bash
   javac *.java
   ```
2. Run the main program:
   ```bash
   java main
   ```

## Controls
| Action             | Command |
|--------------------|---------|
| Reveal a cell      | 1       |
| Toggle flag        | 0       |

## Symbol Legend
| Symbol | Meaning              |
|--------|----------------------|
| -      | Hidden cell          |
| #      | Flagged cell         |
| *      | Mine (revealed when game ends) |
| Number | Mine count in adjacent cells |

## Game Rules
1. Select difficulty level to start
2. Enter coordinates to select a cell
3. Choose to reveal (1) or flag (0) the cell
4. Game ends if a mine is revealed
5. Win by revealing all non-mine cells

## Class Overview
| Class             | Description |
|-------------------|-------------|
| `main`            | Entry point, handles user input |
| `MineField`       | Core game logic, manages mine layout and state |
| `marks`           | Tracks cell state (hidden/revealed/flagged) |
| `field`           | Stores mine positions |
| `numberOfMines`   | Stores adjacent mine counts per cell |
| `MineSweeper`     | Not used in core logic (can be ignored) |

## Game Tips
1. Numbers show mine count in surrounding 8 cells
2. Flagging helps track suspected mines
3. Empty cells automatically expand to adjacent safe areas
4. Note row/column boundaries during selection

Enjoy your game! 🚩💣