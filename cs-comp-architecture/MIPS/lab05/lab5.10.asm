#lab5.10.asm
#declares the unaligned variables (in this order) ch1 of size byte, word1 of size word, ch2 of size byte
#... word2 of size word
# the initial values of variables are ?a?, 0x89abcdef, ?b? and 0 respectively
# copies the value of word1 into word2
# uses only native instructions

.data
.align 0
	ch1:   .byte 0xa 		# ch1 variable 'a' (ch1 = 1 byte)
	word1: .word 0x89abcdef # word1 var
	ch2:   .byte 0xb 		# ch2 variable
	word2: .word 0		# word2 variable

.text
.globl main

#begin program
main: 

	#load word1
	lui $16, 0x1001     #load word1 address
	lwr $12, 1($16)   #load right part of word1 into $12
	lwl $13, 4($16)   #load 89 into $13
	add $12, $12, $13 # add sig bits in 15 to least 
	
	lui $17, 0x1001 #load word 2 address
	#store word1 in word2
	swr $12, 6($17) #store first 4 at 6
	swl $12, 8($17) #store next two at 100100008
	swl $12, 9($17) #store next two at 100100009

	#exit program 
	ori $2, $0, 10
	#li $v0, 10
  	syscall
	#jr $ra # return from main
	jr $31
