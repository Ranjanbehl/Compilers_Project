; Symbol table GLOBAL
; name a type INT location 0x20000000
; name b type INT location 0x20000004
; name s type STRING location 0x10000000 value "Enter a number "
; name found type STRING location 0x10000004 value "Found!\n"
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
;
;Start of BB
LA x3, 0x10000000
PUTS x3
GETI x4
LI x5, 2
MUL x6, x5, x4
MV x7, x6
;Saving registers at end of BB
LA x3, 0x20000000
SW x4, 0(x3)
LA x3, 0x20000004
SW x7, 0(x3)
;End of BB
;Start of BB
loop_1:
LI x4, 0
LA x3, 0x20000004
LW x5, 0(x3)
;Saving registers at end of BB
BLE x5, x4, out_2
;End of BB
;Start of BB
LA x3, 0x20000004
LW x4, 0(x3)
PUTI x4
LA x3, 0x20000000
LW x5, 0(x3)
;Saving registers at end of BB
BNE x4, x5, out_1
;End of BB
;Start of BB
LA x3, 0x10000004
PUTS x3
;Saving registers at end of BB
;End of BB
;Start of BB
out_1:
LI x4, 1
LA x3, 0x20000004
LW x5, 0(x3)
SUB x6, x5, x4
MV x5, x6
;Saving registers at end of BB
LA x3, 0x20000004
SW x5, 0(x3)
J loop_1
;End of BB
;Start of BB
out_2:
LI x4, 0
MV x5, x4
;Saving registers at end of BB
SW x5, 8(fp)
J func_ret_main
;End of BB
;
func_ret_main:
;Restore registers
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
0x10000000 "Enter a number "
0x10000004 "Found!\n"
