; Symbol table GLOBAL
; name a type INT location 0x20000000
; name b type FLOAT location 0x20000004
; name c type FLOAT location 0x20000008
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
;
;Start of BB
FIMM.S f0, 2.5
FMV.S f1, f0
FIMM.S f2, 1.0
FADD.S f3, f1, f2
FMV.S f4, f3
LI x4, 2
MV x5, x4
PUTF f4
PUTI x5
MV x6, x5
;Saving registers at end of BB
LA x3, 0x20000000
SW x5, 0(x3)
SW x6, 8(fp)
LA x3, 0x20000004
FSW f1, 0(x3)
LA x3, 0x20000008
FSW f4, 0(x3)
J func_ret_main
;End of BB
;
func_ret_main:
;Restore registers
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
