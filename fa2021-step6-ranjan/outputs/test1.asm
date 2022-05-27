; Symbol table GLOBAL
; Function: VOID swap([PTR, PTR])
; Function: INT main([])

; Symbol table main
; name a type INT location -4
; name b type INT location -8

; Symbol table swap
; name y type PTR location 12
; name x type PTR location 16
; name tmp type INT location -4

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
GETI t1
SW t1, -4(fp)
GETI t2
SW t2, -8(fp)
LW t3, -4(fp)
PUTI t3
LW t4, -8(fp)
PUTI t4
ADDI t5, fp, -4
SW t5, 0(sp)
ADDI sp, sp, -4
ADDI t6, fp, -8
SW t6, 0(sp)
ADDI sp, sp, -4
ADDI sp, sp, -4
SW ra, 0(sp)
ADDI sp, sp, -4
JR func_swap
ADDI sp, sp, 4
LW ra, 0(sp)
ADDI sp, sp, 4
ADDI sp, sp, 8
LW t7, -4(fp)
PUTI t7
LW t8, -8(fp)
PUTI t8
LI t9, 0
SW t9, 8(fp)
J func_ret_main
func_ret_main:
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

func_swap:
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
LW t1, 16(fp)
LW t2, 0(t1)
SW t2, -4(fp)
LW t3, 16(fp)
LW t4, 12(fp)
LW t5, 0(t4)
SW t5, 0(t3)
LW t6, 12(fp)
LW t7, -4(fp)
SW t7, 0(t6)
func_ret_swap:
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
