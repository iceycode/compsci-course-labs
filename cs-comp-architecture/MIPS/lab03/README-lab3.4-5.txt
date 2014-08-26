README lab3.4.asm & lab3.5.asm
** QtSpim used to load/initialize .asm files

lab3.4.asm
- stores values in an array of size 10
- same as following loop:
   j = initial value
   for (i = 0; i < 10; i++){
	array[i] = j;
	j++;
   }

lab3.5.asm
- messages prompt user for 2 integers
- if integers are equal, then branches to label Far
	- prints message “Im far away & exits
- if integers differ, branches to label Near
	- prints message “Im nearby & exits

EXAMPLE OUTPUT (lab3.5.asm)
Enter an integer: 9
Enter another integer: 9
I'm far away

Enter an integer: 3
Enter another integer: 4
I'm nearby
