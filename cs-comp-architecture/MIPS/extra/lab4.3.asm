.data
#user prompts to enter integers to be stored in registers
msg1: .asciiz "Enter an integer: "
msg2: .asciiz "Enter another integer: "
msg3: .asciiz "The largest value is: "

.text
.globl main

main:
	# print 1st message
	li $v0, 4 # system call for print_str
	la $a0, msg1 # address of string to print
	syscall

	# now get an integer from the user
	li $v0, 5 # system call for read_int
	syscall # the integer placed in $v0
	addu $s0, $v0, $0 # move the number in $s0 register (saved across calls)

	# print 2nd message
	li $v0, 4 # system call for print_str
	la $a0, msg2 # address of string to print
	syscall

	# now get an integer from the user
	li $v0, 5 			# system call for read_int
	syscall 			# the integer placed in $v0
	addu $s1, $v0, $0 	# move the number in $s1 register (saved across calls)
	
	# print 3rd message
	li $v0, 4 # system call for print_str
	la $a0, msg3 # address of string to print
	syscall

	addi $sp, $sp, -4 	# creating room on stack
	sw $ra, 0($sp) 		# save $ra to the stack (push)

	jal Largest 		# jump to largest procedure

	lw $ra, 0($sp) 		# pop the address off the stack
	addi $sp, $sp, 4 	# restore stack pointer to original address

	jr $ra 				# return from main

# Largest procedure - takes 2 integers from user input
# returns the largest value user entered
Largest:

	bge $s0, $s1, L1 	#if s0 > s1, branch to Print
	jal L2			# go to PrintL2 if t1 larger

	jr $ra 				# return from this procedure

L1: 
	add $a0, $0, $s0    	# put number into a0 for syscall
	addi $v0, $0, 1     	# system call for print_int
	syscall

	jr $ra 				# return from this procedure

L2:
	add $a0, $0, $s1   	# put number into a0 for syscall (a0-3 reserved)
	addi $v0, $0, 1     	# system call for print_int
	syscall

	jr $ra 				# return from this procedure
