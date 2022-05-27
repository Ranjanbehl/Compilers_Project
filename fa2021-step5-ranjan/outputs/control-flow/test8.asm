; Symbol table GLOBAL
; name welcome type STRING location 0x10000000 value "Compute GCD(x, y) using Euclid's algorithm \n"
; name xprompt type STRING location 0x10000004 value "Enter x: "
; name yprompt type STRING location 0x10000008 value "Enter y: "
; name result type STRING location 0x1000000c value "GCD(x, y) = "
; name x type INT location 0x20000000
; name y type INT location 0x20000004
; name mod type INT location 0x20000008
; name tmp type INT location 0x2000000c
; name prompt type STRING location 0x10000010 value "Enter a number: "
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
;
;Start of BB
LA x3, 0x10000000
PUTS x3
LA x3, 0x10000004
PUTS x3
GETI x4
LA x3, 0x10000008
PUTS x3
GETI x5
;Saving registers at end of BB
LA x3, 0x20000000
SW x4, 0(x3)
LA x3, 0x20000004
SW x5, 0(x3)
;End of BB
;Start of BB
loop_2:
LI x4, 0
LA x3, 0x20000000
LW x5, 0(x3)
;Saving registers at end of BB
BEQ x5, x4, out_3
;End of BB
;Start of BB
LA x3, 0x20000000
LW x4, 0(x3)
LA x3, 0x20000004
LW x5, 0(x3)
;Saving registers at end of BB
BGT x4, x5, out_1
;End of BB
;Start of BB
LA x3, 0x20000000
LW x4, 0(x3)
MV x5, x4
LA x3, 0x20000004
LW x6, 0(x3)
MV x4, x6
MV x6, x5
;Saving registers at end of BB
LA x3, 0x20000000
SW x4, 0(x3)
LA x3, 0x2000000c
SW x5, 0(x3)
LA x3, 0x20000004
SW x6, 0(x3)
;End of BB
;Start of BB
out_1:
;Saving registers at end of BB
;End of BB
;Start of BB
loop_1:
LA x3, 0x20000000
LW x4, 0(x3)
LA x3, 0x20000004
LW x5, 0(x3)
;Saving registers at end of BB
BLT x4, x5, out_2
;End of BB
;Start of BB
LA x3, 0x20000000
LW x4, 0(x3)
LA x3, 0x20000004
LW x5, 0(x3)
SUB x6, x4, x5
MV x4, x6
;Saving registers at end of BB
LA x3, 0x20000000
SW x4, 0(x3)
J loop_1
;End of BB
;Start of BB
out_2:
LA x3, 0x20000000
LW x4, 0(x3)
PUTI x4
LA x3, 0x20000004
LW x5, 0(x3)
PUTI x5
;Saving registers at end of BB
J loop_2
;End of BB
;Start of BB
out_3:
LA x3, 0x1000000c
PUTS x3
LA x3, 0x20000004
LW x4, 0(x3)
PUTI x4
LI x5, 0
MV x6, x5
;Saving registers at end of BB
SW x6, 8(fp)
J func_ret_main
;End of BB
;
func_ret_main:
;Restore registers
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
0x10000000 "Compute GCD(x, y) using Euclid's algorithm \n"
0x10000004 "Enter x: "
0x10000008 "Enter y: "
0x1000000c "GCD(x, y) = "
0x10000010 "Enter a number: "
