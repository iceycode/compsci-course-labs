lab5.7-5.10 README
**MARS/QtSpim used to create & load/initialize

labs 5.7-5.8
- lab 5.7 uses lwl instructions to align data
- lab 5.8 uses lwr instruction to align data

lab 5.9
- fixes lab5.3.asm, b/c unaligned word cause error
- uses instruction sequence of lwl & lwr with appropriate displacements

lab 5.10
- stores unaligned words
- uses only native instructions
- uses 3 extra instructions per each