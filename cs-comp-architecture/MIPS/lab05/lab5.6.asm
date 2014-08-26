.data

msg1: .asciiz "Enter last 4 digits of SSN: "    #user prompt
msg2: .asciiz "If the bytes were layed in reverse order the number would be: "
user1: .word 0 #initial value set to 0
reverse: .word 0 # holds reverse

.text
.globl main

main:
	add $sp, $sp, -4 # creating room on stack
	sw $ra, 0($sp) # save $ra to the stack (push)
	
	#print message
	li $v0, 4 # system call for print_str
	la $a0, msg1 # address of string to print
	syscall
	# now get an integer from the user
	li $v0, 5 # system call for read_int
	syscall # the integer placed in $v0
	add $t1, $v0, $0 # move the number in $t0
	sw $t1, user1 # store in user1
	
	# load vars
	la $a0, user1
	la $a1, reverse
	
	jal Reverse_bytes # call ?test? with no parameters

	#print message with bytes reversed
	li $v0, 4 # system call for print_str
	la $a0, msg2 # address of string to print
	syscall	
	#print reversed 
	#add $a0, $0, $a1    # put number into a0 for syscall
	li $v0, 1 # system call for print_str
	lw $a0, reverse
	syscall
	

	lw $ra, 0($sp) # pop the address off the stack
	addi $sp, $sp, 4 # restore stack pointer to original address
	
	#exit program ----MARS requires this for proper exit
	li $v0, 10
  	syscall
	jr $ra # return from main
	
	#jr $ra # return from main

# The procedure ?test? does not call any other procedure. Therefore $ra
# does not need to be saved. Since ?test? uses no registers there is
# no need to save any registers.
Reverse_bytes:

	lb $t0, 0($a0) #access 1st byte of content at address a0 of word1
	lb $t1, 1($a0)
	lb $t2, 2($a0)
	lb $t3, 3($a0)
	
	#store bytes loaded in t0 thru t3 in reverse
	sb $t3, 0($a1)
	sb $t2, 1($a1)
	sb $t1, 2($a1)
	sb $t0, 3($a1)
	
	jr $ra    #return from precedure