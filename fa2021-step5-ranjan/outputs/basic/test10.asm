; Symbol table GLOBAL
; name a type FLOAT location 0x20000000
; name b type FLOAT location 0x20000004
; name c type FLOAT location 0x20000008
; name d type FLOAT location 0x2000000c
; name prompt type STRING location 0x10000000 value "Enter a number: "
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
FSW f0, 0(sp)
ADDI sp, sp, -4
FSW f1, 0(sp)
ADDI sp, sp, -4
FSW f2, 0(sp)
ADDI sp, sp, -4
FSW f3, 0(sp)
ADDI sp, sp, -4
FSW f4, 0(sp)
ADDI sp, sp, -4
FSW f5, 0(sp)
ADDI sp, sp, -4
FSW f6, 0(sp)
ADDI sp, sp, -4
;
;Start of BB
FIMM.S f0, 1.3
FMV.S f1, f0
FIMM.S f2, 2.5
FMV.S f3, f2
LA x3, 0x10000000
PUTS x3
GETF f4
FMUL.S f5, f3, f4
FADD.S f6, f1, f5
PUTF f6
LI x4, 0
MV x5, x4
;Saving registers at end of BB
SW x5, 8(fp)
LA x3, 0x20000000
FSW f1, 0(x3)
LA x3, 0x20000004
FSW f3, 0(x3)
LA x3, 0x20000008
FSW f4, 0(x3)
J func_ret_main
;End of BB
;
func_ret_main:
;Restore registers
ADDI sp, sp, 4
FLW f6, 0(sp)
ADDI sp, sp, 4
FLW f5, 0(sp)
ADDI sp, sp, 4
FLW f4, 0(sp)
ADDI sp, sp, 4
FLW f3, 0(sp)
ADDI sp, sp, 4
FLW f2, 0(sp)
ADDI sp, sp, 4
FLW f1, 0(sp)
ADDI sp, sp, 4
FLW f0, 0(sp)
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
0x10000000 "Enter a number: "
