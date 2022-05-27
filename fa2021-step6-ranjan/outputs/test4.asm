; Symbol table GLOBAL
; Function: INT main([])

; Symbol table main
; name x type PTR location -4
; name size type INT location -8
; name i type INT location -12

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
LI t1, 10
SW t1, -8(fp)
LW t3, -8(fp)
LI t2, 4
MUL t4, t3, t2
MALLOC t5, t4
SW t5, -4(fp)
LI t6, 0
SW t6, -12(fp)
loop_1:
LW t7, -12(fp)
LW t8, -8(fp)
BGE t7, t8, out_1
LW t12, -4(fp)
LW t10, -12(fp)
LI t9, 4
MUL t11, t10, t9
ADD t13, t12, t11
LW t14, -12(fp)
SW t14, 0(t13)
LW t16, -12(fp)
LI t15, 1
ADD t17, t16, t15
SW t17, -12(fp)
J loop_1
out_1:
LI t18, 0
SW t18, -12(fp)
loop_2:
LW t19, -12(fp)
LW t20, -8(fp)
BGE t19, t20, out_2
LW t24, -4(fp)
LW t22, -12(fp)
LI t21, 4
MUL t23, t22, t21
ADD t25, t24, t23
LW t29, -4(fp)
LW t27, -12(fp)
LI t26, 4
MUL t28, t27, t26
ADD t30, t29, t28
LW t36, 0(t30)
LW t34, -4(fp)
LW t32, -12(fp)
LI t31, 4
MUL t33, t32, t31
ADD t35, t34, t33
LW t37, 0(t35)
MUL t38, t36, t37
SW t38, 0(t25)
LW t40, -12(fp)
LI t39, 1
ADD t41, t40, t39
SW t41, -12(fp)
J loop_2
out_2:
LI t42, 0
SW t42, -12(fp)
loop_3:
LW t43, -12(fp)
LW t44, -8(fp)
BGE t43, t44, out_3
LW t48, -4(fp)
LW t46, -12(fp)
LI t45, 4
MUL t47, t46, t45
ADD t49, t48, t47
LW t50, 0(t49)
PUTI t50
LW t52, -12(fp)
LI t51, 1
ADD t53, t52, t51
SW t53, -12(fp)
J loop_3
out_3:
LW t54, -4(fp)
FREE t54
LI t55, 0
SW t55, 8(fp)
J func_ret_main
func_ret_main:
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
