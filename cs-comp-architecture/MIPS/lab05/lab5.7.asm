.data 0x10000000
word1: .word 0x89abcdef #word1 stored at address 0x10000000

.text
.globl main

main: 
	lui $s0, 0x1000 # s0 <-- word1 (stored at 0x100000000) <--base address stored in s0
	lwl $t0, 0($s0) # load left-justified 0 thru 3
	lwl $t1, 1($s0) # load left-justified 4 thru 7
	lwl $t2, 2($s0) # load into t2 from address 10000002
	lwl $t3, 3($s0) # laod into t3 from address 10000003
	
	#exit program ----MARS requires this for proper exit
	li $v0, 10
  	syscall
	jr $ra # return from main
	
	#jr $ra #exit program