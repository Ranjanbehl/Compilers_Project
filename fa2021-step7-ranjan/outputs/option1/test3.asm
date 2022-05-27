; Symbol table GLOBAL
; Function: INT main([])

; Symbol table main
; name cell1 type PTR to PTR to VOID location -4
; name cell2 type PTR to PTR to VOID location -8
; name curr type PTR to PTR to VOID location -12
; name d type PTR to INT location -16

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
SW t60, 0(sp)
ADDI sp, sp, -4
SW t61, 0(sp)
ADDI sp, sp, -4
SW t62, 0(sp)
ADDI sp, sp, -4
SW t63, 0(sp)
ADDI sp, sp, -4
LI t1, 8
MALLOC t2, t1
SW t2, -4(fp)
LW t6, -4(fp)
LI t3, 0
LI t4, 4
MUL t5, t3, t4
ADD t7, t6, t5
LI t8, 4
MALLOC t9, t8
SW t9, 0(t7)
LI t10, 8
MALLOC t11, t10
SW t11, -8(fp)
LW t15, -8(fp)
LI t12, 0
LI t13, 4
MUL t14, t12, t13
ADD t16, t15, t14
LI t17, 4
MALLOC t18, t17
SW t18, 0(t16)
LW t22, -4(fp)
LI t19, 0
LI t20, 4
MUL t21, t19, t20
ADD t23, t22, t21
LW t24, 0(t23)
SW t24, -16(fp)
LW t25, -16(fp)
LI t26, 8
SW t26, 0(t25)
LW t30, -4(fp)
LI t27, 1
LI t28, 4
MUL t29, t27, t28
ADD t31, t30, t29
LW t32, -8(fp)
SW t32, 0(t31)
LW t36, -8(fp)
LI t33, 0
LI t34, 4
MUL t35, t33, t34
ADD t37, t36, t35
LW t38, 0(t37)
SW t38, -16(fp)
LW t39, -16(fp)
LI t40, 10
SW t40, 0(t39)
LW t44, -8(fp)
LI t41, 1
LI t42, 4
MUL t43, t41, t42
ADD t45, t44, t43
LI t46, 0
SW t46, 0(t45)
LW t47, -4(fp)
SW t47, -12(fp)
loop_1:
LW t49, -12(fp)
LI t48, 0
BEQ t49, t48, out_1
LW t53, -12(fp)
LI t50, 0
LI t51, 4
MUL t52, t50, t51
ADD t54, t53, t52
LW t55, 0(t54)
SW t55, -16(fp)
LW t56, -16(fp)
LW t57, 0(t56)
PUTI t57
LW t61, -12(fp)
LI t58, 1
LI t59, 4
MUL t60, t58, t59
ADD t62, t61, t60
LW t63, 0(t62)
SW t63, -12(fp)
J loop_1
out_1:
func_ret_main:
ADDI sp, sp, 4
LW t63, 0(sp)
ADDI sp, sp, 4
LW t62, 0(sp)
ADDI sp, sp, 4
LW t61, 0(sp)
ADDI sp, sp, 4
LW t60, 0(sp)
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



.section .strings
