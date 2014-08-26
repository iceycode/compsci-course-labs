.data 0x10010000
# 4 variables of size .word (32bit)
var1:   .word 0x0000 
var2:   .word 0x10000
var3:   .word 0xabcd 
var4:   .word 0x10000001  

# variables first & last
first:  .byte A
last:   .byte J

.text       #code section   
.globl main # starting point global

# user code begins
 # swaps values in memory: 
 # v1<—>v4; v2<—>v3
 # first & last stay the same 
main: 
	la $s0, first # first loaded into t4
	la $s1, last # last loaded into t5

	#swaps addresses var1 & var 4
	lw $t0, var1 # loads var1 into t0
	lw $t1, var4 # loads address var4 into t1
	move $t7, $t0 # moves var1 to t7
	move $t0, $t1 # moves var4 into t0
	move $t1, $t7 # moves var1 into var4

	#swaps values var2 & var3
	lw $t2, var3 # loads var2 into t2
	lw $t3, var2 # loads var3 into t3
	move $t7, $t2 # moves var2 to t7
	move $t2, $t3 # moves var3 into t2
	move $t3, $t7 # moves var2 into var3

	jr $ra # return from main
