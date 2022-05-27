; Symbol table GLOBAL
; name a type INT location 0x20000000
; name b type INT location 0x20000004
; name s type STRING location 0x10000000 value "Hello world\n"
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
;
;Start of BB
LI x4, 10
MV x5, x4
LI x6, 5
MV x7, x6
DIV x9, x5, x7
PUTI x9
LA x3, 0x10000000
PUTS x3
LI x10, 0
MV x11, x10
;Saving registers at end of BB
LA x3, 0x20000000
SW x5, 0(x3)
LA x3, 0x20000004
SW x7, 0(x3)
SW x11, 8(fp)
J func_ret_main
;End of BB
;
func_ret_main:
;Restore registers
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
0x10000000 "Hello world\n"
