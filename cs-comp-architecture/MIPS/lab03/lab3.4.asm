# program stores value in an array
.data
my_array: .space 10 # array of size 10 initialized

.text
.globl main

# main procedure
main:
	la $s0, my_array 		# load array address
	li $t0, 3			# load first SSN number (t0 = 3), j
	li $t1, 10			# load 10 into t1
	li $t2, 0			# load counter i as 0 into t2

aLoop: #begin loop

	bge $t2, $t1, Exit  		# if t2 >= t1, Exit loop
	sw $t0, 0($s0)			# store value into array
	addi $t0, $t0, 1		# increment initial value j by 1
	addi $t2, $t2, 1   		# increment pointer t2 by 1
	addi $s0, $s0, 4      		#increment storage pointer

	j aLoop 				# return to loop

Exit: #exit loop
	jr $ra 				# exit program