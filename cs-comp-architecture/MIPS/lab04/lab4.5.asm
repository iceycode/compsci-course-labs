.data
msg1: .asciiz "Enter a non-negative integer: "
msg2: .asciiz "Integer was negative, try again"
msg3: .asciiz " is the factorial of the integer you entered"

.text
.globl main

#main method asks user for non-negative integer
main:
		#print 1st message
		li $v0, 4 # system call for print_str
		la $a0, msg1 # address of string to print
		syscall

		# now get an integer from the user
		li $v0, 5 # system call for read_int
		syscall # the integer placed in $v0
		addu $t0, $v0, $0 # move the number in $t0

		addu $t0, $v0, $0 # move the number in $t0
		bltz $t0, Negative # branch if less then 0

		add $sp, $sp, -8 # creating room on stack
		sw $t0, 0($sp) # save t0 on the stack (push)
		move $a0, $t0   # move to a0

		jal Factorial     #jump to factorial

		#move $t0, $v0    #store factorial in t0 for printing
		#li $v0, 1 # system call for print_int
		#move $a0, $t0    # move for printing
		#syscall
				
		add $a0, $0, $v0    # put number into a0 for syscall
		addi $v0, $0, 1     # system call for print_int
		syscall

		#print message following factorial
		li $v0, 4 # system call for print_str
		la $a0, msg3 # address of string to print
		syscall

		
		lw $ra, 0($sp) 		# pop the address off the stack
		addi $sp, $sp, 8	# restore stack pointer to original address

		jr $ra

Negative:
		#print message saying negative number entered
		li $v0, 4 			# system call for print_str
		la $a0, msg2 		# address of string to print
		syscall

		jal main			#return to main

# This procedure computes the factorial of a non-negative integer
# The parameter (an integer) received in $a0
# The result (a 32 bit integer) is returned in $v0
# The procedure uses none of the registers $s0 - $s7 so no need to save them
# Any parameter that will make the factorial compute a result larger than
# 32 bits will return a wrong result.
Factorial:
		subu $sp, $sp, 4
		sw $ra, 4($sp) 		# save the return address on stack
		beqz $a0, terminate 	# test for termination
		subu $sp, $sp, 4 	# do not terminate yet
		sw $a0, 4($sp) 		# save the parameter
		sub $a0, $a0, 1 	# will call with a smaller argument
		jal Factorial

# after the termination condition is reached these lines
# will be executed
		lw $t0, 4($sp)   # the argument I have saved on stack
		mul $v0, $v0, $t0 # do the multiplication
		lw $ra, 8($sp)    # prepare to return
		addu $sp, $sp, 8 # I’ve popped 2 words (an address and
		jr $ra 			 # .. an argument)
terminate:
		li $v0, 1 			# 0! = 1 is the return value
		lw $ra, 4($sp) 		# get the return address
		addu $sp, $sp, 4	# adjust the stack pointer
		jr $ra 				# return
