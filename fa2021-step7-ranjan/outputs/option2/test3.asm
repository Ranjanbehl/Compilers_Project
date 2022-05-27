; Symbol table GLOBAL
; Function: INT main([])

; Symbol table main
; name x type INT location -4
; name y type FLOAT location -8

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
FIMM.S f1, 2.3
FSW f1, -8(fp)
LI t1, 2
IMOVF.S f2, t1
FLW f3, -8(fp)
FMUL.S f4, f2, f3
LI t2, 2
IMOVF.S f5, t2
FMUL.S f6, f4, f5
FMOVI.S t3, f6
SW t3, -4(fp)
LW t4, -4(fp)
PUTI t4
LI t5, 2
IMOVF.S f7, t5
FLW f8, -8(fp)
FMUL.S f9, f7, f8
FMOVI.S t6, f9
LI t7, 2
MUL t8, t6, t7
SW t8, -4(fp)
LW t9, -4(fp)
PUTI t9
LI t10, 0
SW t10, 8(fp)
J func_ret_main
func_ret_main:
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



.section .strings
