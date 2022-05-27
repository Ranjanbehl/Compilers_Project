; Symbol table GLOBAL
; name factstr type STRING location 0x10000000 value "Enter a number: "
; name outpref type STRING location 0x10000004 value "Factorial of "
; name outsuff type STRING location 0x10000008 value " is "
; name x type INT location 0x20000000
; Function: INT fact([INT])
; Function: INT main([])

; Symbol table main
; name res type INT location -4

; Symbol table fact
; name n type INT location 12

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
ADDI sp, sp, -4
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
;
;Start of BB
LA x3, 0x10000000
PUTS x3
GETI x4
LI x5, 2
ADD x6, x4, x5
SW x6, 0(sp)
ADDI sp, sp, -4
ADDI sp, sp, -4
SW ra, 0(sp)
ADDI sp, sp, -4
JR func_fact
ADDI sp, sp, 4
LW ra, 0(sp)
ADDI sp, sp, 4
LW x7, 0(sp)
ADDI sp, sp, 4
MV x9, x7
LA x3, 0x10000004
PUTS x3
LI x10, 2
ADD x11, x4, x10
PUTI x11
LA x3, 0x10000008
PUTS x3
PUTI x9
LI x12, 0
MV x13, x12
;Saving registers at end of BB
LA x3, 0x20000000
SW x4, 0(x3)
SW x9, -4(fp)
SW x13, 8(fp)
J func_ret_main
;End of BB
;
func_ret_main:
;Restore registers
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
;
;Function: fact
func_fact:
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
LI x4, 1
LW x5, 12(fp)
;Saving registers at end of BB
BGT x5, x4, else_1
;End of BB
;Start of BB
LI x4, 1
MV x5, x4
;Saving registers at end of BB
SW x5, 8(fp)
J func_ret_fact
;End of BB
;Start of BB
;Saving registers at end of BB
J out_1
;End of BB
;Start of BB
else_1:
LI x4, 1
LW x5, 12(fp)
SUB x6, x5, x4
SW x6, 0(sp)
ADDI sp, sp, -4
ADDI sp, sp, -4
SW ra, 0(sp)
ADDI sp, sp, -4
JR func_fact
ADDI sp, sp, 4
LW ra, 0(sp)
ADDI sp, sp, 4
LW x7, 0(sp)
ADDI sp, sp, 4
MUL x9, x5, x7
MV x10, x9
;Saving registers at end of BB
SW x10, 8(fp)
J func_ret_fact
;End of BB
;Start of BB
out_1:
;Saving registers at end of BB
;End of BB
;
func_ret_fact:
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
;End of function fact
;


.section .strings
0x10000000 "Enter a number: "
0x10000004 "Factorial of "
0x10000008 " is "
