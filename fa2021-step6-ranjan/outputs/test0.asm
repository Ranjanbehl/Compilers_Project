Found SHADOW adding INT a
Found SHADOW adding INT b
; Symbol table GLOBAL
; name true type STRING location 0x10000000 value "True\n"
; name false type STRING location 0x10000004 value "False\n"
; name a type FLOAT location 0x20000000
; name b type FLOAT location 0x20000004
; Function: INT main([])

; Symbol table main
; name a type INT location -4
; name b type INT location -8
; name ptr type PTR location -12
; name ptr2 type PTR location -16

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
LI t1, 7
SW t1, -4(fp)
ADDI t2, fp, -4
SW t2, -12(fp)
LW t3, -12(fp)
LI t4, 8
SW t4, 0(t3)
LW t5, -4(fp)
PUTI t5
LW t6, -12(fp)
LW t8, 0(t6)
LI t7, 2
ADD t9, t8, t7
SW t9, -8(fp)
LW t10, -8(fp)
PUTI t10
ADDI t11, fp, -12
SW t11, -16(fp)
LW t12, -16(fp)
LW t13, 0(t12)
LI t14, 9
SW t14, 0(t13)
LW t15, -4(fp)
PUTI t15
LW t16, -16(fp)
ADDI t17, fp, -8
SW t17, 0(t16)
LW t18, -12(fp)
LW t19, 0(t18)
PUTI t19
LI t20, 0
SW t20, 8(fp)
J func_ret_main
func_ret_main:
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
0x10000000 "True\n"
0x10000004 "False\n"
