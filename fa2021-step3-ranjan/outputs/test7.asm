; Symbol table GLOBAL
; name welcome type STRING location 0x10000000 value "This is a terrible implementation of (x % y) \n"
; name xprompt type STRING location 0x10000004 value "Enter x: "
; name yprompt type STRING location 0x10000008 value "Enter y: "
; name result type STRING location 0x1000000c value "(x % y) = "
; name x type INT location 0x20000000
; name y type INT location 0x20000004

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
loop_1:
LA t8, 0x20000000
LW t9, 0(t8)
LA t10, 0x20000004
LW t11, 0(t10)
BLE t9, t11, out_1
LA t17, 0x20000000
LA t12, 0x20000000
LW t13, 0(t12)
LA t14, 0x20000004
LW t15, 0(t14)
SUB t16, t13, t15
SW t16, 0(t17)
J loop_1
out_1:
LA t18, 0x1000000c
PUTS t18
LA t19, 0x20000000
LW t20, 0(t19)
PUTI t20
LI t21, 0
HALT


.section .strings
0x10000000 "This is a terrible implementation of (x % y) \n"
0x10000004 "Enter x: "
0x10000008 "Enter y: "
0x1000000c "(x % y) = "
