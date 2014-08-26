.data 0x10010000
# 3 variables of size .word (32bit)
var1:   .word 3
var2:   .word 4
var3:   .word -2014

.text       #code section   
.globl main # starting point global

#main method including branch (if-else)
main: 
	#loading words into registers
	lw $t1, var1
	lw $t2, var2
	lw $t3, var3

	#beginning of branch if-else	
	slt $t0, $t1, $t2 #if (var1 < var2), $t0 = 1, else $t0 = 0
	bgtz $t0, Else  # jump to Else if $t0 > 0
		#begin if-block (block 1)
		move $t1, $t3 # var1 = var3
		move $t2, $t3 # var2 = var3
		j Exit # exit loop

# branch for else (swap values var1 & var2)
Else:
	move $t5, $t1 # temp = var1
	move $t1, $t2 # var1 = var2
	move $t2, $t5 # var2 = temp
	j Exit

Exit: 
	jr $ra # return from main