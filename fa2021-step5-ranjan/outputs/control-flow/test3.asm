; Symbol table GLOBAL
; name a type INT location 0x20000000
; name b type INT location 0x20000004
; name c type INT location 0x20000008
; name d type INT location 0x2000000c
; name prompt type STRING location 0x10000000 value "enter a number "
; name output1 type STRING location 0x10000004 value "a less than b"
; name output2 type STRING location 0x10000008 value " and less than c \n"
; name output3 type STRING location 0x1000000c value " but not less than c \n"
; name output4 type STRING location 0x10000010 value "a greater than or equal to b"
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
GETI x4
LA x3, 0x10000000
PUTS x3
GETI x5
LA x3, 0x10000000
PUTS x3
GETI x6
;Saving registers at end of BB
LA x3, 0x20000000
SW x4, 0(x3)
LA x3, 0x20000004
SW x5, 0(x3)
LA x3, 0x20000008
SW x6, 0(x3)
BGE x4, x5, else_3
;End of BB
;Start of BB
LA x3, 0x10000004
PUTS x3
LA x3, 0x20000000
LW x4, 0(x3)
LA x3, 0x20000008
LW x5, 0(x3)
;Saving registers at end of BB
BGE x4, x5, else_1
;End of BB
;Start of BB
LA x3, 0x10000008
PUTS x3
;Saving registers at end of BB
J out_1
;End of BB
;Start of BB
else_1:
LA x3, 0x1000000c
PUTS x3
;Saving registers at end of BB
;End of BB
;Start of BB
out_1:
;Saving registers at end of BB
J out_3
;End of BB
;Start of BB
else_3:
LA x3, 0x10000010
PUTS x3
LA x3, 0x20000000
LW x4, 0(x3)
LA x3, 0x20000008
LW x5, 0(x3)
;Saving registers at end of BB
BGE x4, x5, else_2
;End of BB
;Start of BB
LA x3, 0x10000008
PUTS x3
;Saving registers at end of BB
J out_2
;End of BB
;Start of BB
else_2:
LA x3, 0x1000000c
PUTS x3
;Saving registers at end of BB
;End of BB
;Start of BB
out_2:
;Saving registers at end of BB
;End of BB
;Start of BB
out_3:
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
0x10000000 "enter a number "
0x10000004 "a less than b"
0x10000008 " and less than c \n"
0x1000000c " but not less than c \n"
0x10000010 "a greater than or equal to b"
