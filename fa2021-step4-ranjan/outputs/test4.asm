; Symbol table GLOBAL
; name curVal type FLOAT location 0x20000000
; name x type FLOAT location 0x20000004
; name degree type INT location 0x20000008
; Function: FLOAT addX([FLOAT, FLOAT])
; name val type STRING location 0x10000000 value "Enter x value to evaluate: "
; name degreePrompt type STRING location 0x10000004 value "Enter a degree: "
; name prompt type STRING location 0x10000008 value "Enter coefficient: "
; Function: INT main([])

; Symbol table main
; name cur type INT location -4

; Symbol table addX
; name x type FLOAT location 12
; name curVal type FLOAT location 16
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
SW t15, 0(sp)
ADDI sp, sp, -4
SW t16, 0(sp)
ADDI sp, sp, -4
SW t17, 0(sp)
ADDI sp, sp, -4
SW t18, 0(sp)
ADDI sp, sp, -4
SW t19, 0(sp)
ADDI sp, sp, -4
SW t20, 0(sp)
ADDI sp, sp, -4
SW t21, 0(sp)
ADDI sp, sp, -4
SW t22, 0(sp)
ADDI sp, sp, -4
SW t23, 0(sp)
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
LA t12, 0x20000008
LA t9, 0x20000008
LW t10, 0(t9)
LI t8, 1
ADD t11, t10, t8
SW t11, 0(t12)
loop_1:
LW t13, -4(fp)
LA t14, 0x20000008
LW t15, 0(t14)
BGE t13, t15, out_1
LW t17, -4(fp)
LI t16, 1
ADD t18, t17, t16
SW t18, -4(fp)
LA t21, 0x20000000
LA t19, 0x20000000
FLW f3, 0(t19)
FSW f3, 0(sp)
ADDI sp, sp, -4
LA t20, 0x20000004
FLW f4, 0(t20)
FSW f4, 0(sp)
ADDI sp, sp, -4
ADDI sp, sp, -4
SW ra, 0(sp)
ADDI sp, sp, -4
JR func_addX
ADDI sp, sp, 4
LW ra, 0(sp)
ADDI sp, sp, 4
FLW f5, 0(sp)
ADDI sp, sp, 8
FSW f5, 0(t21)
J loop_1
out_1:
LA t22, 0x20000000
FLW f6, 0(t22)
PUTF f6
LI t23, 0
SW t23, 8(fp)
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
LW t23, 0(sp)
ADDI sp, sp, 4
LW t22, 0(sp)
ADDI sp, sp, 4
LW t21, 0(sp)
ADDI sp, sp, 4
LW t20, 0(sp)
ADDI sp, sp, 4
LW t19, 0(sp)
ADDI sp, sp, 4
LW t18, 0(sp)
ADDI sp, sp, 4
LW t17, 0(sp)
ADDI sp, sp, 4
LW t16, 0(sp)
ADDI sp, sp, 4
LW t15, 0(sp)
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

func_addX:
SW fp, 0(sp)
MV fp, sp
ADDI sp, sp, -4
ADDI sp, sp, -4
SW t1, 0(sp)
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
LA t1, 0x10000008
PUTS t1
GETF f1
FSW f1, -4(fp)
FLW f2, 12(fp)
FLW f3, 16(fp)
FMUL.S f4, f2, f3
FLW f5, -4(fp)
FADD.S f6, f4, f5
FSW f6, 8(fp)
J func_ret_addX
func_ret_addX:
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
LW t1, 0(sp)
MV sp, fp
LW fp, 0(fp)
RET



.section .strings
0x10000000 "Enter x value to evaluate: "
0x10000004 "Enter a degree: "
0x10000008 "Enter coefficient: "
