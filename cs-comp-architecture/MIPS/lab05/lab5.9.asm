# this is a program used to test memory alignment for data
	.data 0x10000000
	.align 0
char1: .byte 'a' 	# reserve space for a byte
double1: .double 1.1 	# reserve space for a double
char2: .byte 'b' 	# b is 0x62 in ASCII
half1: .half 0x8001 	# reserve space for a half-word (2 bytes)
char3: .byte 'c' 	# c is 0x63 in ASCII
word1: .word 0x56789abc # reserve space for a word <--- most significant byte at address 0x10000010, least in 0x10000008
char4: .byte 'd' 	# d is 0x64 in ASCII

	.text
	.globl main
main: 
	#lw $t0, word1  # word1 loaded into reg t0 <---original instruction in lab5.3 caused error
	
	
	lui $t0, 0x1000 # t0 <-- 0x1000008 (load base address)
	lwr $t1, 13($t0) # load right-alignged displaced at 1 to low-order
	lwl $t1, 16($t0) # load rest into t1, offset at 16, to high-order
	
	
	#jr $ra # return from main
	
	#exit program ----MARS requires this for proper exit
	li $v0, 10
  	syscall
