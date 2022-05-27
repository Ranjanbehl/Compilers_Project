; Symbol table GLOBAL
; Function: PTR to PTR to VOID cons([PTR to VOID, PTR to VOID])
; Function: PTR to VOID car([PTR to PTR to VOID])
; Function: PTR to VOID cdr([PTR to PTR to VOID])
; Function: INT main([])

; Symbol table main
; name head type PTR to PTR to VOID location -4
; name curr type PTR to PTR to VOID location -8
; name data type PTR to INT location -12
; name i type INT location -16

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
ADDI sp, sp, -16
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
SW t24, 0(sp)
ADDI sp, sp, -4
SW t25, 0(sp)
ADDI sp, sp, -4
SW t26, 0(sp)
ADDI sp, sp, -4
SW t27, 0(sp)
ADDI sp, sp, -4
SW t28, 0(sp)
ADDI sp, sp, -4
SW t29, 0(sp)
ADDI sp, sp, -4
SW t30, 0(sp)
ADDI sp, sp, -4
SW t31, 0(sp)
ADDI sp, sp, -4
SW t32, 0(sp)
ADDI sp, sp, -4
SW t33, 0(sp)
ADDI sp, sp, -4
SW t34, 0(sp)
ADDI sp, sp, -4
SW t35, 0(sp)
ADDI sp, sp, -4
SW t36, 0(sp)
ADDI sp, sp, -4
SW t37, 0(sp)
ADDI sp, sp, -4
SW t38, 0(sp)
ADDI sp, sp, -4
SW t39, 0(sp)
ADDI sp, sp, -4
SW t40, 0(sp)
ADDI sp, sp, -4
SW t41, 0(sp)
ADDI sp, sp, -4
SW t42, 0(sp)
ADDI sp, sp, -4
SW t43, 0(sp)
ADDI sp, sp, -4
SW t44, 0(sp)
ADDI sp, sp, -4
SW t45, 0(sp)
ADDI sp, sp, -4
SW t46, 0(sp)
ADDI sp, sp, -4
SW t47, 0(sp)
ADDI sp, sp, -4
SW t48, 0(sp)
ADDI sp, sp, -4
SW t49, 0(sp)
ADDI sp, sp, -4
SW t50, 0(sp)
ADDI sp, sp, -4
SW t51, 0(sp)
ADDI sp, sp, -4
SW t52, 0(sp)
ADDI sp, sp, -4
SW t53, 0(sp)
ADDI sp, sp, -4
SW t54, 0(sp)
ADDI sp, sp, -4
SW t55, 0(sp)
ADDI sp, sp, -4
SW t56, 0(sp)
ADDI sp, sp, -4
SW t57, 0(sp)
ADDI sp, sp, -4
SW t58, 0(sp)
ADDI sp, sp, -4
SW t59, 0(sp)
ADDI sp, sp, -4
LI t1, 4
LI t2, 5
MUL t3, t1, t2
MALLOC t4, t3
SW t4, -12(fp)
LI t5, 1
SW t5, -16(fp)
loop_1:
LW t7, -16(fp)
LI t6, 6
BGE t7, t6, out_1
LW t13, -12(fp)
LW t9, -16(fp)
LI t8, 1
SUB t10, t9, t8
LI t11, 4
MUL t12, t10, t11
ADD t14, t13, t12
LI t15, 2
LW t16, -16(fp)
MUL t17, t15, t16
SW t17, 0(t14)
LW t19, -16(fp)
LI t18, 1
ADD t20, t19, t18
SW t20, -16(fp)
J loop_1
out_1:
LW t24, -12(fp)
LI t21, 0
LI t22, 4
MUL t23, t21, t22
ADD t25, t24, t23
SW t25, 0(sp)
ADDI sp, sp, -4
LW t29, -12(fp)
LI t26, 1
LI t27, 4
MUL t28, t26, t27
ADD t30, t29, t28
SW t30, 0(sp)
ADDI sp, sp, -4
LW t34, -12(fp)
LI t31, 2
LI t32, 4
MUL t33, t31, t32
ADD t35, t34, t33
SW t35, 0(sp)
ADDI sp, sp, -4
LW t39, -12(fp)
LI t36, 3
LI t37, 4
MUL t38, t36, t37
ADD t40, t39, t38
SW t40, 0(sp)
ADDI sp, sp, -4
LW t44, -12(fp)
LI t41, 4
LI t42, 4
MUL t43, t41, t42
ADD t45, t44, t43
SW t45, 0(sp)
ADDI sp, sp, -4
LI t46, 0
SW t46, 0(sp)
ADDI sp, sp, -4
ADDI sp, sp, -4
SW ra, 0(sp)
ADDI sp, sp, -4
JR func_cons
ADDI sp, sp, 4
LW ra, 0(sp)
ADDI sp, sp, 4
LW t47, 0(sp)
ADDI sp, sp, 8
SW t47, 0(sp)
ADDI sp, sp, -4
ADDI sp, sp, -4
SW ra, 0(sp)
ADDI sp, sp, -4
JR func_cons
ADDI sp, sp, 4
LW ra, 0(sp)
ADDI sp, sp, 4
LW t48, 0(sp)
ADDI sp, sp, 8
SW t48, 0(sp)
ADDI sp, sp, -4
ADDI sp, sp, -4
SW ra, 0(sp)
ADDI sp, sp, -4
JR func_cons
ADDI sp, sp, 4
LW ra, 0(sp)
ADDI sp, sp, 4
LW t49, 0(sp)
ADDI sp, sp, 8
SW t49, 0(sp)
ADDI sp, sp, -4
ADDI sp, sp, -4
SW ra, 0(sp)
ADDI sp, sp, -4
JR func_cons
ADDI sp, sp, 4
LW ra, 0(sp)
ADDI sp, sp, 4
LW t50, 0(sp)
ADDI sp, sp, 8
SW t50, 0(sp)
ADDI sp, sp, -4
ADDI sp, sp, -4
SW ra, 0(sp)
ADDI sp, sp, -4
JR func_cons
ADDI sp, sp, 4
LW ra, 0(sp)
ADDI sp, sp, 4
LW t51, 0(sp)
ADDI sp, sp, 8
SW t51, -4(fp)
LW t52, -4(fp)
SW t52, -8(fp)
loop_2:
LW t54, -8(fp)
LI t53, 0
BEQ t54, t53, out_2
LW t55, -8(fp)
SW t55, 0(sp)
ADDI sp, sp, -4
ADDI sp, sp, -4
SW ra, 0(sp)
ADDI sp, sp, -4
JR func_car
ADDI sp, sp, 4
LW ra, 0(sp)
ADDI sp, sp, 4
LW t56, 0(sp)
ADDI sp, sp, 4
LW t57, 0(t56)
PUTI t57
LW t58, -8(fp)
SW t58, 0(sp)
ADDI sp, sp, -4
ADDI sp, sp, -4
SW ra, 0(sp)
ADDI sp, sp, -4
JR func_cdr
ADDI sp, sp, 4
LW ra, 0(sp)
ADDI sp, sp, 4
LW t59, 0(sp)
ADDI sp, sp, 4
SW t59, -8(fp)
J loop_2
out_2:
func_ret_main:
ADDI sp, sp, 4
LW t59, 0(sp)
ADDI sp, sp, 4
LW t58, 0(sp)
ADDI sp, sp, 4
LW t57, 0(sp)
ADDI sp, sp, 4
LW t56, 0(sp)
ADDI sp, sp, 4
LW t55, 0(sp)
ADDI sp, sp, 4
LW t54, 0(sp)
ADDI sp, sp, 4
LW t53, 0(sp)
ADDI sp, sp, 4
LW t52, 0(sp)
ADDI sp, sp, 4
LW t51, 0(sp)
ADDI sp, sp, 4
LW t50, 0(sp)
ADDI sp, sp, 4
LW t49, 0(sp)
ADDI sp, sp, 4
LW t48, 0(sp)
ADDI sp, sp, 4
LW t47, 0(sp)
ADDI sp, sp, 4
LW t46, 0(sp)
ADDI sp, sp, 4
LW t45, 0(sp)
ADDI sp, sp, 4
LW t44, 0(sp)
ADDI sp, sp, 4
LW t43, 0(sp)
ADDI sp, sp, 4
LW t42, 0(sp)
ADDI sp, sp, 4
LW t41, 0(sp)
ADDI sp, sp, 4
LW t40, 0(sp)
ADDI sp, sp, 4
LW t39, 0(sp)
ADDI sp, sp, 4
LW t38, 0(sp)
ADDI sp, sp, 4
LW t37, 0(sp)
ADDI sp, sp, 4
LW t36, 0(sp)
ADDI sp, sp, 4
LW t35, 0(sp)
ADDI sp, sp, 4
LW t34, 0(sp)
ADDI sp, sp, 4
LW t33, 0(sp)
ADDI sp, sp, 4
LW t32, 0(sp)
ADDI sp, sp, 4
LW t31, 0(sp)
ADDI sp, sp, 4
LW t30, 0(sp)
ADDI sp, sp, 4
LW t29, 0(sp)
ADDI sp, sp, 4
LW t28, 0(sp)
ADDI sp, sp, 4
LW t27, 0(sp)
ADDI sp, sp, 4
LW t26, 0(sp)
ADDI sp, sp, 4
LW t25, 0(sp)
ADDI sp, sp, 4
LW t24, 0(sp)
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
