; Symbol table GLOBAL
; name a type INT location 0x20000000
; name b type INT location 0x20000004
; name c type INT location 0x20000008
; name d type INT location 0x2000000c
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
SW x11, 0(sp)
ADDI sp, sp, -4
SW x12, 0(sp)
ADDI sp, sp, -4
SW x13, 0(sp)
ADDI sp, sp, -4
SW x14, 0(sp)
ADDI sp, sp, -4
SW x15, 0(sp)
ADDI sp, sp, -4
;
;Start of BB
LI x4, 2
NEG x5, x4
MV x6, x5
LI x7, 5
MV x9, x7
MUL x10, x6, x9
MV x11, x10
PUTI x11
NEG x12, x11
MV x13, x12
PUTI x13
LI x14, 0
MV x15, x14
;Saving registers at end of BB
LA x3, 0x20000000
SW x6, 0(x3)
LA x3, 0x20000004
SW x9, 0(x3)
LA x3, 0x20000008
SW x11, 0(x3)
LA x3, 0x2000000c
SW x13, 0(x3)
SW x15, 8(fp)
J func_ret_main
;End of BB
;
func_ret_main:
;Restore registers
ADDI sp, sp, 4
LW x15, 0(sp)
ADDI sp, sp, 4
LW x14, 0(sp)
ADDI sp, sp, 4
LW x13, 0(sp)
ADDI sp, sp, 4
LW x12, 0(sp)
ADDI sp, sp, 4
LW x11, 0(sp)
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
