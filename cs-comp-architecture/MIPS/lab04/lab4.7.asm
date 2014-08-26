.data
inx: .asciiz "Enter the x variable in Ackermann's function, A(x,y): "
iny: .asciiz "Enter the y variable in Ackermann's function, A(x,y): "

.text
.globl main

#main method
main:   
	addi $sp, $sp, -16   # make room on stack.
   	sw   $ra, 0($sp)   # preserve return address.
   	sw   $s0, 4($sp)   # preserve registers s0 through s2
   	sw   $s1, 8($sp)    
   	sw   $s2, 12($sp)

	#ask for int x
	li $v0, 4 # system call for print_str
	la $a0, inx # address of string to print
	syscall

	# get input from user
	li $v0, 5 # system call for read_int
	syscall # syscall
	addu $t0, $v0, $0 # move the number in $t0
	
	#ask for int y
	li $v0, 4 # system call for print_str
	la $a0, iny # address of string to print
	syscall

	# get input from user
	li $v0, 5 # system call for read_int
	syscall # syscall
	addu $t1, $v0, $0 # move the number in $t1
	
	move $a0, $t0 
	move $a1, $t1
	
	jal Ackermann # jump to Ackermann
	

	lw   $ra, 0($sp)   # restore return address
   	lw   $s0, 4($sp)   # restore registers s0 through s3
   	lw   $s1, 8($sp) # before exiting main
   	lw   $s2, 12($sp)
   	addi   $sp, $sp, 16   # restore stack pointer
	
	#print result
	move $a0, $v0 # move what's stored in v0 to a0 for printing
	li $v0, 1 # system call for print_int
	syscall
	
	#exit program
	li $v0, 10
  	syscall
#start ackermann function using stack
Ackermann:
	addi $sp, $sp, -8 #make room in stack
	sw $s0, 4($sp) # store s0 in stack
	sw $ra, 0($sp) # store return address in stack
	
# if  x == 0 case	
	bne $a0, $0, elseif  # if a0 != 0, elseif
	addi $v0, $a1, 1 # v0 = y + 1
	
	j done  # go to finish to restore stack
	
# x != 0 && y == 0 case
elseif:
	bne $a1, $0, else # branch to else if 
	addi $a0, $a0, -1 # a0 = x-1
	addi $a1, $0, 1 # a1 = 1
	jal Ackermann # answer (a0) = Ackermann(x-1, 1)
	
	j done   # jump to done
# y!=0 && y != 0 case
else:
	add $s0, $a0, $0 # preserve a0 (x) in s0
	
	addi $a1, $a1, -1 # a1 = y-1 
	jal Ackermann # a0 = Ackermann(x, y-1)
	
	addi $a0, $s0, -1 # a0 = x-1
	add $a1, $v0, $0 # a1 = Ackermann(x, y-1)
	jal Ackermann # answer (v0) = Ackermann(x-1, v0)
	
	j done

#epilogue
done: 
	# pops and restores addresses of sp
	lw $s0, 4($sp)
	lw $ra, 0($sp)
	addi $sp, $sp, 8
	
	jr $ra # return to main
