; Symbol table GLOBAL
; name a type INT location 0x20000000
; name b type INT location 0x20000004
; name s type STRING location 0x10000000 value "Enter a number "
; name found type STRING location 0x10000004 value "Found!\n"

.section .text
;Current temp: null
;IR Code: 
LA t1, 0x10000000
PUTS t1
LA t2, 0x20000000
GETI t3
SW t3, 0(t2)
LA t8, 0x20000004
LI t4, 2
LA t5, 0x20000000
LW t6, 0(t5)
MUL t7, t4, t6
SW t7, 0(t8)
loop_1:
LA t10, 0x20000004
LW t11, 0(t10)
LI t9, 0
BLE t11, t9, out_2
LA t12, 0x20000004
LW t13, 0(t12)
PUTI t13
LA t14, 0x20000004
LW t15, 0(t14)
LA t16, 0x20000000
LW t17, 0(t16)
BNE t15, t17, out_1
LA t18, 0x10000004
PUTS t18
out_1:
LA t23, 0x20000004
LA t20, 0x20000004
LW t21, 0(t20)
LI t19, 1
SUB t22, t21, t19
SW t22, 0(t23)
J loop_1
out_2:
LI t24, 0
HALT


.section .strings
0x10000000 "Enter a number "
0x10000004 "Found!\n"
