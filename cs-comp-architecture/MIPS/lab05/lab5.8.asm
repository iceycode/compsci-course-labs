.data 0x10000000
word1: .word 0x89abcdef #word1 stored at address 0x10000000

.text
.globl main

main: 
	lui $s0, 0x1000 # s0 <-- word1 (stored at 0x100000000) <--base address stored in s0
	lwr $t4, 0($s0) # load right-justified bytes at offeset 0 continues thru high order of word
	lwr $t5, 1($s0) # load right-justified 4 thru 7 at offset 1
	lwr $t6, 2($s0) # load into t6 at offset 2
	lwr $t7, 3($s0) # laod into t7 at offset 3
	
	#exit program ----MARS requires this for proper exit
	li $v0, 10
  	syscall
	jr $ra # return from main
	
	#jr $ra #exit program