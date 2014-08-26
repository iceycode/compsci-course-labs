.data 0x10010000
# 1 variable of size word (first SSN number)
# for loop increments var1 as long as i < 100
# i incremented by 1 every time
var1:   .word 3

.text       #code section   
.globl main # starting point global

#main method begins
main: 
	lw $s0, var1 # load var1 into t0

	ori $s1, $0, 100 # set max in for-loop
	lw $s2, var1 # set i to var1

	#beginning of for loop	
LOOP:	bge $s2, $s1, DONE # begin loop, finish when 100
	#begin for-loop body
	addi $s0, $s0, 1 # add 1 to var1
	j INCREMENT # increment s2

INCREMENT: addi $s2, $s2, 1 # increment s2
	   j LOOP # jump back into loop

DONE: 
	jr $ra # return from main