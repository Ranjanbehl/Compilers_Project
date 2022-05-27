Found SHADOW adding FLOAT a
; Symbol table GLOBAL
; name true type STRING location 0x10000000 value "True\n"
; name false type STRING location 0x10000004 value "False\n"
; name a type FLOAT location 0x20000000
; name b type FLOAT location 0x20000004
; Function: INT main([])
; Function: FLOAT foo([INT, FLOAT])

; Symbol table main
; name c type INT location -4
; name d type INT location -8

; Symbol table foo
; name y type FLOAT location 12
; name x type INT location 16
; name d type INT location -4
; name f type FLOAT location -8
; name a type FLOAT location -12

; generating code to print ; name true type STRING location 0x10000000 value "True\n"
; generating code to print ; name false type STRING location 0x10000004 value "False\n"
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
ADDI sp, sp, -8
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
LA t1, 0x20000000
FIMM.S f1, 3.0
FSW f1, 0(t1)
LA t2, 0x20000004
FIMM.S f2, 2.0
FSW f2, 0(t2)
LI t3, 7
SW t3, -4(fp)
LW t5, -4(fp)
LI t4, 2
MUL t6, t5, t4
SW t6, -8(fp)
LA t7, 0x20000000
FLW f3, 0(t7)
LA t8, 0x20000004
FLW f4, 0(t8)
FLT.S t13, f3, f4
BNE t13, x0, else_1
LW t9, -8(fp)
PUTI t9
LA t10, 0x10000000
PUTS t10
J out_1
else_1:
LW t11, -8(fp)
PUTI t11
LA t12, 0x10000004
PUTS t12
out_1:
LI t14, 0
SW t14, 8(fp)
J func_ret_main
func_ret_main:
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

func_foo:
SW fp, 0(sp)
MV fp, sp
ADDI sp, sp, -4
ADDI sp, sp, -12
FSW f1, 0(sp)
ADDI sp, sp, -4
FSW f2, 0(sp)
ADDI sp, sp, -4
FSW f3, 0(sp)
ADDI sp, sp, -4
FLW f2, 12(fp)
FIMM.S f1, 1.0
FADD.S f3, f2, f1
FSW f3, 8(fp)
J func_ret_foo
func_ret_foo:
ADDI sp, sp, 4
FLW f3, 0(sp)
ADDI sp, sp, 4
FLW f2, 0(sp)
ADDI sp, sp, 4
FLW f1, 0(sp)
MV sp, fp
LW fp, 0(fp)
RET



.section .strings
0x10000000 "True\n"
0x10000004 "False\n"
