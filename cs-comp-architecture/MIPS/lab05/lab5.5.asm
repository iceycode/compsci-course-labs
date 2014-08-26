# this is a program used to test memory alignment for data
	.data 0x10000000
char1: .byte 'a' 	# reserve space for a byte
double1: .double 1.1 	# reserve space for a double
char2: .byte 'b' 	# b is 0x62 in ASCII
half1: .half 0x8001 	# reserve space for a half-word (2 bytes)
char3: .byte 'c' 	# c is 0x63 in ASCII
word1: .word 0x56789abc # reserve space for a word
char4: .byte 'd' 	# d is 0x64 in ASCII
word2: .word 0          # initial size of 0

	.text
	.globl main
main: 
	#load addresses of words to access bytes
	la $a0, word1
	la $a1, word2
	
	#load byte by byte word1 into t0 to t3
	#addi $t0, $a0, -2
	lb $t0, 0($a0) #access 1st byte of content at address a0 of word1
	lb $t1, 1($a0)
	lb $t2, 2($a0)
	lb $t3, 3($a0)

	#load byte by byte word1 into t0 to t3 (using lbu)
	#..loads as unsigned
	lbu $t4, 0($a0)
	lbu $t5, 1($a0)
	lbu $t6, 2($a0)
	lbu $t7, 3($a0)
	
	#load bytes of half1 into t8 and t9
	lh $t8, half1 #signed
	lhu $t9, half1 #unsigned 
	
	#la $s0, word1

	#store bytes loaded in t0 thru t3 in reverse
	sb $t3, 0($a1)
	sb $t2, 1($a1)
	sb $t1, 2($a1)
	sb $t0, 3($a1)
	
	#jr $ra # return from main
	
	#exit program ----MARS requires this for proper exit
	li $v0, 10
  	syscall
