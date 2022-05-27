; Symbol table GLOBAL
; name curVal type FLOAT location 0x20000000
; name x type FLOAT location 0x20000004
; name degree type INT location 0x20000008
; Function: FLOAT poly([FLOAT, FLOAT, INT])
; name val type STRING location 0x10000000 value "Enter x value to evaluate: "
; name degreePrompt type STRING location 0x10000004 value "Enter a degree: "
; name prompt type STRING location 0x10000008 value "Enter coefficient: "
; Function: INT main([])

; Symbol table main
; name cur type INT location -4

; Symbol table poly
; name degree type INT location 12
; name x type FLOAT location 16
; name curVal type FLOAT location 20
; name coeff type FLOAT location -4

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
FSW f0, 0(sp)
ADDI sp, sp, -4
FSW f1, 0(sp)
ADDI sp, sp, -4
FSW f2, 0(sp)
ADDI sp, sp, -4
FSW f3, 0(sp)
ADDI sp, sp, -4
;
;Start of BB
FIMM.S f0, 0.0
FMV.S f1, f0
LI x4, 0
MV x5, x4
LA x3, 0x10000000
PUTS x3
GETF f2
LA x3, 0x10000004
PUTS x3
GETI x6
FSW f1, 0(sp)
ADDI sp, sp, -4
FSW f2, 0(sp)
ADDI sp, sp, -4
SW x6, 0(sp)
ADDI sp, sp, -4
ADDI sp, sp, -4
SW ra, 0(sp)
ADDI sp, sp, -4
JR func_poly
ADDI sp, sp, 4
LW ra, 0(sp)
ADDI sp, sp, 4
FLW f3, 0(sp)
ADDI sp, sp, 12
FMV.S f1, f3
PUTF f1
LI x7, 0
MV x9, x7
;Saving registers at end of BB
SW x5, -4(fp)
LA x3, 0x20000008
SW x6, 0(x3)
SW x9, 8(fp)
LA x3, 0x20000000
FSW f1, 0(x3)
LA x3, 0x20000004
FSW f2, 0(x3)
J func_ret_main
;End of BB
;
func_ret_main:
;Restore registers
ADDI sp, sp, 4
FLW f3, 0(sp)
ADDI sp, sp, 4
FLW f2, 0(sp)
ADDI sp, sp, 4
FLW f1, 0(sp)
ADDI sp, sp, 4
FLW f0, 0(sp)
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
;Function: poly
func_poly:
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
;
;Start of BB
LI x4, 0
LW x5, 12(fp)
;Saving registers at end of BB
BLE x5, x4, out_1
;End of BB
;Start of BB
FLW f0, 20(fp)
FSW f0, 0(sp)
ADDI sp, sp, -4
FLW f1, 16(fp)
FSW f1, 0(sp)
ADDI sp, sp, -4
LI x4, 1
LW x5, 12(fp)
SUB x6, x5, x4
SW x6, 0(sp)
ADDI sp, sp, -4
ADDI sp, sp, -4
SW ra, 0(sp)
ADDI sp, sp, -4
JR func_poly
ADDI sp, sp, 4
LW ra, 0(sp)
ADDI sp, sp, 4
FLW f2, 0(sp)
ADDI sp, sp, 12
FMV.S f0, f2
;Saving registers at end of BB
FSW f0, 20(fp)
;End of BB
;Start of BB
out_1:
LA x3, 0x10000008
PUTS x3
GETF f0
FLW f1, 16(fp)
FLW f2, 20(fp)
FMUL.S f3, f1, f2
FADD.S f4, f3, f0
FMV.S f5, f4
;Saving registers at end of BB
FSW f0, -4(fp)
FSW f5, 8(fp)
J func_ret_poly
;End of BB
;
func_ret_poly:
;Restore registers
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
LW x6, 0(sp)
ADDI sp, sp, 4
LW x5, 0(sp)
ADDI sp, sp, 4
LW x4, 0(sp)
MV sp, fp
LW fp, 0(fp)
RET
;End of function poly
;


.section .strings
0x10000000 "Enter x value to evaluate: "
0x10000004 "Enter a degree: "
0x10000008 "Enter coefficient: "
