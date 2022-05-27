; Symbol table GLOBAL
; name welcome type STRING location 0x10000000 value "Compute GCD(x, y) using Euclid's algorithm \n"
; name xprompt type STRING location 0x10000004 value "Enter x: "
; name yprompt type STRING location 0x10000008 value "Enter y: "
; name result type STRING location 0x1000000c value "GCD(x, y) = "
; name x type INT location 0x20000000
; name y type INT location 0x20000004
; name mod type INT location 0x20000008
; name tmp type INT location 0x2000000c
; name prompt type STRING location 0x10000010 value "Enter a number: "

.section .text
;Current temp: null
;IR Code: 
LA t1, 0x10000000
PUTS t1
LA t2, 0x10000004
PUTS t2
LA t3, 0x20000000
GETI t4
SW t4, 0(t3)
LA t5, 0x10000008
PUTS t5
LA t6, 0x20000004
GETI t7
SW t7, 0(t6)
loop_2:
LA t9, 0x20000000
LW t10, 0(t9)
LI t8, 0
BEQ t10, t8, out_3
LA t11, 0x20000000
LW t12, 0(t11)
LA t13, 0x20000004
LW t14, 0(t13)
BGT t12, t14, out_1
LA t15, 0x2000000c
LA t16, 0x20000000
LW t17, 0(t16)
SW t17, 0(t15)
LA t18, 0x20000000
LA t19, 0x20000004
LW t20, 0(t19)
SW t20, 0(t18)
LA t21, 0x20000004
LA t22, 0x2000000c
LW t23, 0(t22)
SW t23, 0(t21)
out_1:
loop_1:
LA t24, 0x20000000
LW t25, 0(t24)
LA t26, 0x20000004
LW t27, 0(t26)
BLT t25, t27, out_2
LA t33, 0x20000000
LA t28, 0x20000000
LW t29, 0(t28)
LA t30, 0x20000004
LW t31, 0(t30)
SUB t32, t29, t31
SW t32, 0(t33)
J loop_1
out_2:
LA t34, 0x20000000
LW t35, 0(t34)
PUTI t35
LA t36, 0x20000004
LW t37, 0(t36)
PUTI t37
J loop_2
out_3:
LA t38, 0x1000000c
PUTS t38
LA t39, 0x20000004
LW t40, 0(t39)
PUTI t40
LI t41, 0
HALT


.section .strings
0x10000000 "Compute GCD(x, y) using Euclid's algorithm \n"
0x10000004 "Enter x: "
0x10000008 "Enter y: "
0x1000000c "GCD(x, y) = "
0x10000010 "Enter a number: "
