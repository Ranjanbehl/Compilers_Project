; Symbol table GLOBAL
; Function: PTR to PTR to VOID cons([PTR to VOID, PTR to VOID])
; Function: PTR to VOID car([PTR to PTR to VOID])
; Function: PTR to VOID cdr([PTR to PTR to VOID])
; Function: INT main([])

; Symbol table main
; name head type PTR to PTR to VOID location -4
; name curr type PTR to PTR to VOID location -8

; Symbol table cons
; name second type PTR to VOID location 12
; name first type PTR to VOID location 16
; name cell type PTR to PTR to VOID location -4

; Symbol table car
; name cell type PTR to PTR to VOID location 12

; Symbol table cdr
; name cell type PTR to PTR to VOID location 12

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
SW t15, 0(sp)
ADDI sp, sp, -4
SW t16, 0(sp)
ADDI sp, sp, -4
SW t17, 0(sp)
ADDI sp, sp, -4
SW t18, 0(sp)
ADDI sp, sp, -4
LI t1, 2
SW t1, 0(sp)
ADDI sp, sp, -4
LI t2, 4
SW t2, 0(sp)
ADDI sp, sp, -4
LI t3, 6
SW t3, 0(sp)
ADDI sp, sp, -4
LI t4, 8
SW t4, 0(sp)
ADDI sp, sp, -4
LI t5, 10
SW t5, 0(sp)
ADDI sp, sp, -4
LI t6, 0
SW t6, 0(sp)
ADDI sp, sp, -4
ADDI sp, sp, -4
SW ra, 0(sp)
ADDI sp, sp, -4
JR func_cons
ADDI sp, sp, 4
LW ra, 0(sp)
ADDI sp, sp, 4
LW t7, 0(sp)
ADDI sp, sp, 8
SW t7, 0(sp)
ADDI sp, sp, -4
ADDI sp, sp, -4
SW ra, 0(sp)
ADDI sp, sp, -4
JR func_cons
ADDI sp, sp, 4
LW ra, 0(sp)
ADDI sp, sp, 4
LW t8, 0(sp)
ADDI sp, sp, 8
SW t8, 0(sp)
ADDI sp, sp, -4
ADDI sp, sp, -4
SW ra, 0(sp)
ADDI sp, sp, -4
JR func_cons
ADDI sp, sp, 4
LW ra, 0(sp)
ADDI sp, sp, 4
LW t9, 0(sp)
ADDI sp, sp, 8
SW t9, 0(sp)
ADDI sp, sp, -4
ADDI sp, sp, -4
SW ra, 0(sp)
ADDI sp, sp, -4
JR func_cons
ADDI sp, sp, 4
LW ra, 0(sp)
ADDI sp, sp, 4
LW t10, 0(sp)
ADDI sp, sp, 8
SW t10, 0(sp)
ADDI sp, sp, -4
ADDI sp, sp, -4
SW ra, 0(sp)
ADDI sp, sp, -4
JR func_cons
ADDI sp, sp, 4
LW ra, 0(sp)
ADDI sp, sp, 4
LW t11, 0(sp)
ADDI sp, sp, 8
SW t11, -4(fp)
LW t12, -4(fp)
SW t12, -8(fp)
loop_1:
LW t14, -8(fp)
LI t13, 0
BEQ t14, t13, out_1
LW t15, -8(fp)
SW t15, 0(sp)
ADDI sp, sp, -4
ADDI sp, sp, -4
SW ra, 0(sp)
ADDI sp, sp, -4
JR func_car
ADDI sp, sp, 4
LW ra, 0(sp)
ADDI sp, sp, 4
LW t16, 0(sp)
ADDI sp, sp, 4
PUTI t16
LW t17, -8(fp)
SW t17, 0(sp)
ADDI sp, sp, -4
ADDI sp, sp, -4
SW ra, 0(sp)
ADDI sp, sp, -4
JR func_cdr
ADDI sp, sp, 4
LW ra, 0(sp)
ADDI sp, sp, 4
LW t18, 0(sp)
ADDI sp, sp, 4
SW t18, -8(fp)
J loop_1
out_1:
func_ret_main:
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

func_cons:
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
LI t1, 8
MALLOC t2, t1
SW t2, -4(fp)
LW t6, -4(fp)
LI t3, 0
LI t4, 4
MUL t5, t3, t4
ADD t7, t6, t5
LW t8, 16(fp)
SW t8, 0(t7)
LW t12, -4(fp)
LI t9, 1
LI t10, 4
MUL t11, t9, t10
ADD t13, t12, t11
LW t14, 12(fp)
SW t14, 0(t13)
LW t15, -4(fp)
SW t15, 8(fp)
J func_ret_cons
func_ret_cons:
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

func_car:
SW fp, 0(sp)
MV fp, sp
ADDI sp, sp, -4
ADDI sp, sp, -0
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
LW t4, 12(fp)
LI t1, 0
LI t2, 4
MUL t3, t1, t2
ADD t5, t4, t3
LW t6, 0(t5)
SW t6, 8(fp)
J func_ret_car
func_ret_car:
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

func_cdr:
SW fp, 0(sp)
MV fp, sp
ADDI sp, sp, -4
ADDI sp, sp, -0
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
LW t4, 12(fp)
LI t1, 1
LI t2, 4
MUL t3, t1, t2
ADD t5, t4, t3
LW t6, 0(t5)
SW t6, 8(fp)
J func_ret_cdr
func_ret_cdr:
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
