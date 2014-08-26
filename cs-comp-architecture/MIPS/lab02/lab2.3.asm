# bare machine code of lab 2.2
.data 0x10010000 # load data at memory location 0x10010000
# 4 variables of size .word (32bit or 4Bytes)
var1: .word 0x0000    # var1
var2: .word 0x10000   # var2
var3: .word 0xabcd    # var3
var4: .word 0x10000001   #var4

# variables first & last size of 8 bits (1 byte)
first: .byte A
last: .byte J

.text       #code section   
.globl main # starting point global

# user code begins
 # swaps values in memory: 
 # v1<—>v4; v2<—>v3
 # first & last stay the same 
main: 
	lui $1, 4097 # loads upper 16 bits
	lw $9, 0($1) # loads lower 16 bits of var1
	lui $1, 4097  # loads upper 16 bits
	lw $10, 12($1) # loads lower 16 bits of var4

	lui $1, 4097 # loads upper 16 bits
	lw $11, 4($1) # loads lower 16 bits of var2
	lui $1, 4097  # loads upper 16 bits
	lw $12, 8($1) # loads lower 16 bits of var3
	
	
	addi $29, $29, -4 # adjust stack pointer for $16 (s0)
	sw $16, 0($29) # save $16 on stack (push)
	
	#swapping var1 with var4
	add $16, $0, $9    #$16 <— $9
	add $9, $0, $10    #$9 <— $10
	add $10, $0, $16  # #10 <—$16

	#swapping var2 with var3
	add $16, $0, $11  #$16 <— $11
	add $11, $0, $12 # $11 <— $12
	add $12, $0, $16 #$16 <— $12

	lw $16, 0($29)   # $16 gets old value back   
	addi $29, $29, 4 # restore sp (pop)
	
	

	lb $13, first # loads byte value first
	lb $14, last  # loads byte value last

#end program
	jr $ra # return from main

	
	