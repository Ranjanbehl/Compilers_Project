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

; generating code to print ; name val type STRING location 0x10000000 value "Enter x value to evaluate: "
; generating code to print ; name degreePrompt type STRING location 0x10000004 value "Enter a degree: "
; generating code to print ; name prompt type STRING location 0x10000008 value "Enter coefficient: "
.section .text
;Current temp: null
;IR Code: 
MV fp, sp
JR func_main
HALT

func_main:
SW fp, 0(sp)
MV fp, sp
ADDI sp, sp, -4
ADDI sp, sp, -4
SW t1, 0(sp)
ADDI sp, sp, -4
SW t2, 0(sp)
ADDI sp, sp, -4
SW t3, 0(sp)
ADDI sp, sp, -4
SW t4, 0(sp)
ADDI sp, sp, -4
SW t5, 0(sp)
ADDI sp, sp, -4
SW t6, 0(sp)
ADDI sp, sp, -4
SW t7, 0(sp)
ADDI sp, sp, -4
SW t8, 0(sp)
ADDI sp, sp, -4
SW t9, 0(sp)
ADDI sp, sp, -4
SW t10, 0(sp)
ADDI sp, sp, -4
SW t11, 0(sp)
ADDI sp, sp, -4
SW t12, 0(sp)
ADDI sp, sp, -4
SW t13, 0(sp)
ADDI sp, sp, -4
SW t14, 0(sp)
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
LA t1, 0x20000000
FIMM.S f1, 0.0
FSW f1, 0(t1)
LI t2, 0
SW t2, -4(fp)
LA t3, 0x10000000
PUTS t3
GETF f2
LA t4, 0x20000004
FSW f2, 0(t4)
LA t5, 0x10000004
PUTS t5
GETI t6
LA t7, 0x20000008
SW t6, 0(t7)
LA t12, 0x20000000
LA t8, 0x20000000
FLW f3, 0(t8)
FSW f3, 0(sp)
ADDI sp, sp, -4
LA t9, 0x20000004
FLW f4, 0(t9)
FSW f4, 0(sp)
ADDI sp, sp, -4
LA t10, 0x20000008
LW t11, 0(t10)
SW t11, 0(sp)
ADDI sp, sp, -4
ADDI sp, sp, -4
SW ra, 0(sp)
ADDI sp, sp, -4
JR func_poly
ADDI sp, sp, 4
LW ra, 0(sp)
ADDI sp, sp, 4
FLW f5, 0(sp)
ADDI sp, sp, 12
FSW f5, 0(t12)
LA t13, 0x20000000
FLW f6, 0(t13)
PUTF f6
LI t14, 0
SW t14, 8(fp)
J func_ret_main
func_ret_main:
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
LW t14, 0(sp)
ADDI sp, sp, 4
LW t13, 0(sp)
ADDI sp, sp, 4
LW t12, 0(sp)
ADDI sp, sp, 4
LW t11, 0(sp)
ADDI sp, sp, 4
LW t10, 0(sp)
ADDI sp, sp, 4
LW t9, 0(sp)
ADDI sp, sp, 4
LW t8, 0(sp)
ADDI sp, sp, 4
LW t7, 0(sp)
ADDI sp, sp, 4
LW t6, 0(sp)
ADDI sp, sp, 4
LW t5, 0(sp)
ADDI sp, sp, 4
LW t4, 0(sp)
ADDI sp, sp, 4
LW t3, 0(sp)
ADDI sp, sp, 4
LW t2, 0(sp)
ADDI sp, sp, 4
LW t1, 0(sp)
MV sp, fp
LW fp, 0(fp)
RET

func_poly:
SW fp, 0(sp)
MV fp, sp
ADDI sp, sp, -4
ADDI sp, sp, -4
SW t1, 0(sp)
ADDI sp, sp, -4
SW t2, 0(sp)
ADDI sp, sp, -4
SW t3, 0(sp)
ADDI sp, sp, -4
SW t4, 0(sp)
ADDI sp, sp, -4
SW t5, 0(sp)
ADDI sp, sp, -4
SW t6, 0(sp)
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
FSW f7, 0(sp)
ADDI sp, sp, -4
FSW f8, 0(sp)
ADDI sp, sp, -4
FSW f9, 0(sp)
ADDI sp, sp, -4
LW t2, 12(fp)
LI t1, 0
BLE t2, t1, out_1
FLW f1, 20(fp)
FSW f1, 0(sp)
ADDI sp, sp, -4
FLW f2, 16(fp)
FSW f2, 0(sp)
ADDI sp, sp, -4
LW t4, 12(fp)
LI t3, 1
SUB t5, t4, t3
SW t5, 0(sp)
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
FSW f3, 20(fp)
out_1:
LA t6, 0x10000008
PUTS t6
GETF f4
FSW f4, -4(fp)
FLW f5, 16(fp)
FLW f6, 20(fp)
FMUL.S f7, f5, f6
FLW f8, -4(fp)
FADD.S f9, f7, f8
FSW f9, 8(fp)
J func_ret_poly
func_ret_poly:
ADDI sp, sp, 4
FLW f9, 0(sp)
ADDI sp, sp, 4
FLW f8, 0(sp)
ADDI sp, sp, 4
FLW f7, 0(sp)
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
LW t6, 0(sp)
ADDI sp, sp, 4
LW t5, 0(sp)
ADDI sp, sp, 4
LW t4, 0(sp)
ADDI sp, sp, 4
LW t3, 0(sp)
ADDI sp, sp, 4
LW t2, 0(sp)
ADDI sp, sp, 4
LW t1, 0(sp)
MV sp, fp
LW fp, 0(fp)
RET



.section .strings
0x10000000 "Enter x value to evaluate: "
0x10000004 "Enter a degree: "
0x10000008 "Enter coefficient: "
