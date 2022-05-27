; Symbol table GLOBAL
; Function: INT main([])

; Symbol table main
; name x type INT location -4
; name y type FLOAT location -8
; name z type FLOAT location -12

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
ADDI sp, sp, -12
SW t1, 0(sp)
ADDI sp, sp, -4
SW t2, 0(sp)
ADDI sp, sp, -4
SW t3, 0(sp)
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
LI t1, 2
SW t1, -4(fp)
FIMM.S f1, 3.5
FSW f1, -8(fp)
LW t2, -4(fp)
IMOVF.S f2, t2
FLW f3, -8(fp)
FADD.S f4, f2, f3
FSW f4, -12(fp)
FLW f5, -12(fp)
PUTF f5
LI t3, 0
SW t3, 8(fp)
J func_ret_main
func_ret_main:
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
LW t3, 0(sp)
ADDI sp, sp, 4
LW t2, 0(sp)
ADDI sp, sp, 4
LW t1, 0(sp)
MV sp, fp
LW fp, 0(fp)
RET



.section .strings
