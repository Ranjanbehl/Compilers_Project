; Symbol table GLOBAL
; name i type INT location 0x20000000
; name j type INT location 0x20000004
; name max type INT location 0x20000008
; name val type INT location 0x2000000c
; name is type STRING location 0x10000000 value "i: "
; name js type STRING location 0x10000004 value "j: "
; name newline type STRING location 0x10000008 value "\n"
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
GETI x6
LI x7, 0
MV x9, x7
;Saving registers at end of BB
LA x3, 0x2000000c
SW x5, 0(x3)
LA x3, 0x20000008
SW x6, 0(x3)
LA x3, 0x20000000
SW x9, 0(x3)
;End of BB
;Start of BB
loop_2:
LA x3, 0x20000000
LW x4, 0(x3)
LA x3, 0x20000008
LW x5, 0(x3)
;Saving registers at end of BB
BGE x4, x5, out_2
;End of BB
;Start of BB
LA x3, 0x10000000
PUTS x3
LA x3, 0x20000000
LW x4, 0(x3)
PUTI x4
LA x3, 0x10000008
PUTS x3
MV x5, x4
;Saving registers at end of BB
LA x3, 0x20000004
SW x5, 0(x3)
;End of BB
;Start of BB
loop_1:
LA x3, 0x20000004
LW x4, 0(x3)
LA x3, 0x20000008
LW x5, 0(x3)
;Saving registers at end of BB
BGE x4, x5, out_1
;End of BB
;Start of BB
LA x3, 0x10000004
PUTS x3
LA x3, 0x20000004
LW x4, 0(x3)
PUTI x4
LA x3, 0x10000008
PUTS x3
LI x5, 1
LA x3, 0x2000000c
LW x6, 0(x3)
ADD x7, x6, x5
MV x6, x7
LI x9, 1
ADD x10, x4, x9
MV x4, x10
;Saving registers at end of BB
LA x3, 0x20000004
SW x4, 0(x3)
LA x3, 0x2000000c
SW x6, 0(x3)
J loop_1
;End of BB
;Start of BB
out_1:
LI x4, 1
LA x3, 0x20000000
LW x5, 0(x3)
ADD x6, x5, x4
MV x5, x6
;Saving registers at end of BB
LA x3, 0x20000000
SW x5, 0(x3)
J loop_2
;End of BB
;Start of BB
out_2:
LA x3, 0x2000000c
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
0x10000000 "i: "
0x10000004 "j: "
0x10000008 "\n"
