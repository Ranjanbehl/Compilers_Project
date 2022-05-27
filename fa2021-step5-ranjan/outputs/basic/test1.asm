; Symbol table GLOBAL
; name cur type INT location 0x20000000
; Function: INT main([])

; Symbol table main

.section .text
;Current temp: null
;IR Code: 
MV fp, sp
JR func_main
HALT
;
;
;Function: main
func_main:
SW fp, 0(sp)
MV fp, sp
ADDI sp, sp, -4
ADDI sp, sp, -0
;Saving registers
SW x4, 0(sp)
ADDI sp, sp, -4
SW x5, 0(sp)
ADDI sp, sp, -4
SW x6, 0(sp)
ADDI sp, sp, -4
SW x7, 0(sp)
ADDI sp, sp, -4
SW x9, 0(sp)
ADDI sp, sp, -4
SW x10, 0(sp)
ADDI sp, sp, -4
;
;Start of BB
LI x4, 0
MV x5, x4
LI x6, 4
ADD x7, x5, x6
MV x5, x7
PUTI x5
LI x9, 0
MV x10, x9
;Saving registers at end of BB
LA x3, 0x20000000
SW x5, 0(x3)
SW x10, 8(fp)
J func_ret_main
;End of BB
;
func_ret_main:
;Restore registers
ADDI sp, sp, 4
LW x10, 0(sp)
ADDI sp, sp, 4
LW x9, 0(sp)
ADDI sp, sp, 4
LW x7, 0(sp)
ADDI sp, sp, 4
LW x6, 0(sp)
ADDI sp, sp, 4
LW x5, 0(sp)
ADDI sp, sp, 4
LW x4, 0(sp)
MV sp, fp
LW fp, 0(fp)
RET
;End of function main
;


.section .strings
