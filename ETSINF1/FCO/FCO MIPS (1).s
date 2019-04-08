
.globl __start
__start:
		addi $8, $0, 20
		addi $9, $0, -8
		addi $12, $0, 15
		mult $8, $12
		mflo $13
		sub $14, $8, $9
		div $13, $14
		mfhi $10
		mflo $11
.end