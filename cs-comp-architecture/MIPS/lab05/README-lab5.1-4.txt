README lab5.1-4
** used MARS to create, load/initialize files

lab5.1
- data place in memory
- 4 chars, 1 word, 1 double, 1 half = 18 bytes total

lab5.2
- same data, but in different order (4 chars comes after each other)
- do not waste space (chars come 1 after another

lab5.3
- same data as 5.1
- added .align 0 before char1 & loaded word1 in main
- causes error due to unaligned address

lab5.4
- same data as 5.1
- added 0x400001 after .text 0x400001
- caused an Invalid instruction address error