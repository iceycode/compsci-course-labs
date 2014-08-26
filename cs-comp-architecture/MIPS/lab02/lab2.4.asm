# bare machine code of lab 2.2
.data 0x10010000 # load data at memory location 0x10010000
# 4 variables of size .word (4 bytes)
var1: .word 34    # var1
var2: .word 48   # var2

# variables ext1 & ext2
.extern ext1 4 # data stored as global variable of size 4 bytes
.extern ext2 4 # ext2 variable

.text       #code section   
.globl main # starting point global

# main user code begins
main: 
	#copy var1 to ext2
	lw $t1, var1 # loads var1
	lw $t2, var2 # loads var2
	
	la $t3, ext1 # load address of ext1
	sw $t2, ext1 # store var2 to ext1
	move $t3, $t2 # copy var2 into ext1
	
	la $t4, ext2 # load address of ext2
	sw $t1, ext2 # store var1 to ext2
	move $t4, $t1 # copy var1 into ext2
	

#end program
	jr $ra # return from main

	
	