; Symbol table GLOBAL
; Function: INT mod([INT, INT])
; Function: INT main([])

; Symbol table mod
; name b type INT location 12
; name a type INT location 16
; name q type FLOAT location -4

; Symbol table main
; name x type INT location -4
; name y type INT location -8

.section .text
;Current temp: null
;IR Code: 
MV fp, sp
JR func_main
HALT

func_mod:
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
LW t2, 16(fp)
IMOVF.S f2, t2
LW t1, 12(fp)
IMOVF.S f1, t1
FDIV.S f3, f2, f1
FSW f3, -4(fp)
FLW f4, -4(fp)
PUTF f4
LW t6, 16(fp)
FLW f5, -4(fp)
FMOVI.S t3, f5
LW t4, 12(fp)
MUL t5, t3, t4
SUB t7, t6, t5
SW t7, 8(fp)
J func_ret_mod
func_ret_mod:
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
GETI t1
SW t1, -4(fp)
GETI t2
SW t2, -8(fp)
LW t3, -4(fp)
SW t3, 0(sp)
ADDI sp, sp, -4
LW t4, -8(fp)
SW t4, 0(sp)
ADDI sp, sp, -4
ADDI sp, sp, -4
SW ra, 0(sp)
ADDI sp, sp, -4
JR func_mod
ADDI sp, sp, 4
LW ra, 0(sp)
ADDI sp, sp, 4
LW t5, 0(sp)
ADDI sp, sp, 8
PUTI t5
LI t6, 0
SW t6, 8(fp)
J func_ret_main
func_ret_main:
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
