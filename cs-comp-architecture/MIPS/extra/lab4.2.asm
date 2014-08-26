.text
.globl main

main:
	add $sp, $sp, -4 # creating room on stack
	sw $ra, 0($sp) # save $ra to the stack (push)
	jal test # call ‘test’ with no parameters
	nop # execute this after ‘test’ returns
	lw $ra, 0($sp) # pop the address off the stack
	addi $sp, $sp, 4 # restore stack pointer to original address
	jr $ra # return from main

# The procedure ‘test’ does not call any other procedure. Therefore $ra
# does not need to be saved. Since ‘test’ uses no registers there is
# no need to save any registers.
test:
	nop # this is the procedure named ‘test’
	jr $ra # return from this procedure
