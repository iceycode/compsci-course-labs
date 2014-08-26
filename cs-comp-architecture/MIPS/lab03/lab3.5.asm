#prompts the user to enter two integers; store them in $t0 and $t1
# .if the two integers are equal, then the program branches to a label called ‘Far’ that is very far away
# (farther than a 16 bit offset can indicate), prints the message “I’m far away” and terminates.
# ,if the two integers are different, then the program prints the message “I’m nearby” and terminates.

.data
#user prompts to enter integers to be stored in registers
msg1: .asciiz "Enter an integer: "
msg2: .asciiz "Enter another integer: "
msg3: .asciiz "I'm far away"
msg4: .asciiz "I'm nearby"

.text
.globl main

main:
	#print 1st message
	li $v0, 4 # system call for print_str
	la $a0, msg1 # address of string to print
	syscall

	# now get an integer from the user
	li $v0, 5 # system call for read_int
	syscall # the integer placed in $v0
	addu $t0, $v0, $0 # move the number in $t0

	#print 2nd message
	li $v0, 4 # system call for print_str
	la $a0, msg2 # address of string to print
	syscall

	# now get an integer from the user
	li $v0, 5 			# system call for read_int
	syscall 			# the integer placed in $v0
	addu $t1, $v0, $0 	# move the number in $t1

	beq $t0, $t1, Far # jump to far if equal
	j Near  			#jump to Near if not equal

Near:
	li $v0, 4 # system call for print_str
	la $a0, msg4 # address of string to print
	syscall

	jr $ra # exit

Far:
	li $v0, 4 # system call for print_str
	la $a0, msg3 # address of string to print
	syscall

	jr $ra # exit
