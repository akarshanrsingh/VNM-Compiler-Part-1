# VNM Compiler — Lexical Scanner

A Java-based lexical scanner developed using **JavaCC (Java Compiler Compiler)** for the Vecs'N'Mats (VNM) programming language as part of **CPS710 — Compilers** at Toronto Metropolitan University.
The project focuses on lexical analysis, token recognition, identifier classification, string processing, and automated testing for a domain-specific language designed to work with vectors and matrices.

## Project Overview

Vecs'N'Mats (VNM) is a domain-specific programming language intended for the creation and manipulation of vectors and matrices.
This project implements **Part I: Scanner**, the lexical analysis component of the VNM interpreter.
The scanner processes source input, identifies valid language tokens, and converts recognized input into structured token objects.
The implementation uses JavaCC to define lexical rules and generate the Java classes responsible for tokenization.

## Key Features

- **Lexical Analysis:** Recognizes operators, keywords, identifiers, numeric literals, and string literals.
- **JavaCC Grammar:** Defines token patterns and lexical rules in `VNM.jj`.
- **Case-Insensitive Keywords:** Recognizes language keywords regardless of capitalization.
- **Typed Identifiers:** Supports distinct identifiers for numbers, booleans, vectors, and matrices.
- **String Processing:** Handles quoted strings and supported escape sequences.
- **Comment Handling:** Ignores single-line comments beginning with `//`.
- **Whitespace Handling:** Skips spaces, tabs, and newlines.
- **Custom Token Classes:** Stores and retrieves token values using specialized Java classes.
- **Automated Testing:** Includes test inputs, expected outputs, and shell scripts for scanner validation.

## Technologies Used
| Technology | Purpose |
| Java       | Scanner implementation and token processing |
| JavaCC     | Lexical grammar definition and scanner generation |
| GNU Make   | Build automation |
| Shell Scripts | Automated testing |
| Git & GitHub | Version control and project management |

## Token Recognition

The VNM scanner recognizes several categories of tokens.

### Operators and Symbols

| Category | Supported Tokens |
| Comparison | `<`, `<=`, `>`, `>=`, `==`, `!=` |
| Membership | `=in`, `!in` |
| Arithmetic | `+`, `-`, `*`, `/` |
| Logical | `&`, `\|`, `!` |
| Assignment | `:=` |
| Delimiters | `(`, `)`, `[`, `]`, `,`, `;` |
| Boolean Literals | `#1`, `#0` |
| Range | ..` |

### Keywords

VNM keywords are case-insensitive.

Supported keywords include: `DO`, `FOR`, `WHILE`, `IF`, `THEN`, `ELIF`, `ELSE`, `FI`, `FUNCTION`, `RETURN`, `END`, `PRINT`, `PRINTLN`, and `VAR`.
For example, `DO`, `do`, and `Do` are recognized as the same keyword.

### Identifiers and Literals

| Token Type | Description |
| IDNUM | Numeric identifiers beginning with `#` followed by a letter |
| IDBOOL| Boolean identifiers beginning with `?` followed by a letter |
| IDVEC | Vector identifiers beginning with `v_` |
| IDMAT | Matrix identifiers beginning with `M_` |
| NUMBER| Integer literals containing one or more digits |
| STRING| Text enclosed in double quotation marks |

### String Escape Sequences

The scanner supports the following escape sequences:

| Sequence | Meaning |
| `\n` | Newline |
| `\t` | Tab |
| `\"` | Double quotation mark |
| `\\` | Backslash |

String tokens store their processed values without the surrounding quotation marks.

## Project Structure
VNM-Compiler/
│
├── VNM.jj
├── VNM.java
├── VNMConstants.java
├── VNMTokenManager.java
│
├── Token.java
├── NumberToken.java
├── StringToken.java
├── IdNumToken.java
├── IdBoolToken.java
├── IdVecToken.java
├── IdMatToken.java
│
├── ParseException.java
├── TokenMgrError.java
├── SimpleCharStream.java
├── TestVNM.java
│
├── tests/
│   ├── comments.in
│   ├── comments.expected
│   ├── identifiers.in
│   ├── identifiers.expected
│   ├── keywords.in
│   ├── keywords.expected
│   ├── numbers.in
│   ├── numbers.expected
│   ├── simpletokens.in
│   ├── simpletokens.expected
│   ├── strings1.in
│   ├── strings1.expected
│   ├── strings2.in
│   ├── strings2.expected
│   ├── strings3.in
│   └── strings3.expected
│
├── makefile
├── runtests
├── t
└── README.md
```

## Implementation Details

### JavaCC Grammar

The `VNM.jj` file contains the lexical specifications for the VNM language.
JavaCC uses these specifications to generate the scanner components responsible for recognizing input tokens.

### Custom Token Classes

Specialized token classes extend the standard token representation to store values associated with different token categories.

These include:

- `NumberToken.java` — Numeric values stored as `Integer`.
- `StringToken.java` — String values with escape sequence processing.
- `IdNumToken.java` — Numeric identifiers.
- `IdBoolToken.java` — Boolean identifiers.
- `IdVecToken.java` — Vector identifiers.
- `IdMatToken.java` — Matrix identifiers.

The token classes provide methods such as `getValue()` and `toString()` to retrieve and represent token values.

## Building and Running

### Prerequisites

Java Development Kit (JDK)
JavaCC
GNU Make
A terminal or development environment capable of running Java applications

### Compile the Project

Navigate to the project directory and execute:
bash
make

The supplied Makefile is intended to automate compilation of the scanner components.

### Run the Scanner

After compiling, execute:
bash
java -classpath . TestVNM
Enter VNM language tokens to test lexical recognition.

Example inputs:
text
DO
while
123
<=
#1

On Unix-like systems, press `Ctrl + D` to send the end-of-file signal and terminate interactive input.

## Testing

The project includes an automated testing framework.

Each test category contains:
.in — Input data supplied to the scanner.
.expected — Expected scanner output.
.out — Output generated during testing.

### Run Automated Tests

On a Unix-like environment, grant execution permission to the testing scripts:
bash
chmod u+x t runtests

Compile the project:
bash
make

Execute the test suite:
bash
./runtests
The test scripts compare the scanner's generated output against the expected results and report differences.

### Test Categories

The included test cases cover:

- Comments and whitespace
- Identifiers
- Keywords
- Numeric literals
- Operators and symbols
- String literals and escape sequences

## Learning Outcomes

This project provides practical experience with:

- Compiler construction fundamentals
- Lexical analysis and tokenization
- Regular-expression-based token definitions
- JavaCC scanner generation
- Object-oriented token representation
- Processing string escape sequences
- Automated software testing
- Build automation using Makefiles

## Project Scope

This repository contains **Part I of the VNM Interpreter project**, focusing on lexical scanning.
It does not represent a complete compiler or interpreter with full parsing, semantic analysis, or program execution.

## Academic Context

**Course:** CPS710 — Compilers  
**Institution:** Toronto Metropolitan University  
**Project:** VNM Interpreter — Part I: Scanner  
**Language:** Java  
**Primary Tool:** JavaCC

*Developed as part of an academic compiler construction project.*
