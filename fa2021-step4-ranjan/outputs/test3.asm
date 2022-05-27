; Symbol table GLOBAL
; name factstr type STRING location 0x10000000 value "Enter a number: "
; name outpref type STRING location 0x10000004 value "Factorial of "
; name outsuff type STRING location 0x10000008 value " is "
; name x type INT location 0x20000000
; Function: INT fact([INT])
; Function: INT main([])

; Symbol table main
; name res type INT location -4

; Symbol table fact
; name n type INT location 12

; generating code to print ; name factstr type STRING location 0x10000000 value "Enter a number: "
; generating code to print ; name outpref type STRING location 0x10000004 value "Factorial of "
; generating code to print ; name outsuff type STRING location 0x10000008 value " is "
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
SW t16, 0(sp)
ADDI sp, sp, -4
LA t1, 0x10000000
PUTS t1
GETI t2
LA t3, 0x20000000
SW t2, 0(t3)
LA t5, 0x20000000
LW t6, 0(t5)
LI t4, 2
ADD t7, t6, t4
SW t7, 0(sp)
ADDI sp, sp, -4
ADDI sp, sp, -4
SW ra, 0(sp)
ADDI sp, sp, -4
JR func_fact
ADDI sp, sp, 4
LW ra, 0(sp)
ADDI sp, sp, 4
LW t8, 0(sp)
ADDI sp, sp, 4
SW t8, -4(fp)
LA t9, 0x10000004
PUTS t9
LA t11, 0x20000000
LW t12, 0(t11)
LI t10, 2
ADD t13, t12, t10
PUTI t13
LA t14, 0x10000008
PUTS t14
LW t15, -4(fp)
PUTI t15
LI t16, 0
SW t16, 8(fp)
J func_ret_main
func_ret_main:
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

func_fact:
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
SW t7, 0(sp)
ADDI sp, sp, -4
SW t8, 0(sp)
ADDI sp, sp, -4
SW t9, 0(sp)
ADDI sp, sp, -4
LW t2, 12(fp)
LI t1, 1
BGT t2, t1, else_1
LI t3, 1
SW t3, 8(fp)
J func_ret_fact
J out_1
else_1:
LW t8, 12(fp)
LW t5, 12(fp)
LI t4, 1
SUB t6, t5, t4
SW t6, 0(sp)
ADDI sp, sp, -4
ADDI sp, sp, -4
SW ra, 0(sp)
ADDI sp, sp, -4
JR func_fact
ADDI sp, sp, 4
LW ra, 0(sp)
ADDI sp, sp, 4
LW t7, 0(sp)
ADDI sp, sp, 4
MUL t9, t8, t7
SW t9, 8(fp)
J func_ret_fact
out_1:
func_ret_fact:
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
0x10000000 "Enter a number: "
0x10000004 "Factorial of "
0x10000008 " is "
