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
	addu $t0, $v0, $0 # move the number in $t0

	# print 2nd message
	li $v0, 4 # system call for print_str
	la $a0, msg2 # address of string to print
	syscall

	# now get an integer from the user
	li $v0, 5 			# system call for read_int
	syscall 			# the integer placed in $v0
	addu $t1, $v0, $0 	# move the number in $t1
	
	# print 3rd message
	li $v0, 4 # system call for print_str
	la $a0, msg3 # address of string to print
	syscall

	addi $sp, $sp, -12 	# creating room on stack
	sw $ra, 0($sp) 		# save $ra to the stack (push)

	sw $t0, 4($sp) 		# store t0 into stack
	sw $t1, 8($sp) 	# store t1 into stack

	jal Largest 		# jump to largest procedure

	lw $ra, 0($sp) 		# pop the address off the stack
	addi $sp, $sp, 12 	# restore stack pointer to original address

	jr $ra 				# return from main

# Largest procedure - takes 2 integers from user input
# returns the largest value user entered
Largest:

	#addi $sp, $sp, -8 	# allocate space for 2 values-ra, num1 & num2

	bge $t0, $t1, L1 #if t0 > t1, branch to Print
	jal L2		# go to PrintL2 if t1 larger

	jr $ra 				# return from this procedure

L1: 
	lw $t0, 4($sp) 		# pop address off stack
	add $a0, $0, $t0    # put number into a0 for syscall
	addi $v0, $0, 1     # system call for print_int
	syscall

	jr $ra 				# return from this procedure

L2:
	lw $t0, 8($sp) 		# pop address off stack
	add $a0, $0, $t0    # put number into a0 for syscall (a0-3 reserved)
	addi $v0, $0, 1     # system call for print_int
	syscall

	jr $ra 				# return from this procedure
