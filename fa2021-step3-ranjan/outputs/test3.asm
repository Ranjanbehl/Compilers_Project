; Symbol table GLOBAL
; name a type INT location 0x20000000
; name b type INT location 0x20000004
; name c type INT location 0x20000008
; name d type INT location 0x2000000c
; name prompt type STRING location 0x10000000 value "enter a number "
; name output1 type STRING location 0x10000004 value "a less than b"
; name output2 type STRING location 0x10000008 value " and less than c \n"
; name output3 type STRING location 0x1000000c value " but not less than c \n"
; name output4 type STRING location 0x10000010 value "a greater than or equal to b"

.section .text
;Current temp: null
;IR Code: 
LA t1, 0x10000000
PUTS t1
LA t2, 0x20000000
GETI t3
SW t3, 0(t2)
LA t4, 0x10000000
PUTS t4
LA t5, 0x20000004
GETI t6
SW t6, 0(t5)
LA t7, 0x10000000
PUTS t7
LA t8, 0x20000008
GETI t9
SW t9, 0(t8)
LA t10, 0x20000000
LW t11, 0(t10)
LA t12, 0x20000004
LW t13, 0(t12)
BGE t11, t13, else_3
LA t14, 0x10000004
PUTS t14
LA t15, 0x20000000
LW t16, 0(t15)
LA t17, 0x20000008
LW t18, 0(t17)
BGE t16, t18, else_1
LA t19, 0x10000008
PUTS t19
J out_1
else_1:
LA t20, 0x1000000c
PUTS t20
out_1:
J out_3
else_3:
LA t21, 0x10000010
PUTS t21
LA t22, 0x20000000
LW t23, 0(t22)
LA t24, 0x20000008
LW t25, 0(t24)
BGE t23, t25, else_2
LA t26, 0x10000008
PUTS t26
J out_2
else_2:
LA t27, 0x1000000c
PUTS t27
out_2:
out_3:
LI t28, 0
HALT


.section .strings
0x10000000 "enter a number "
0x10000004 "a less than b"
0x10000008 " and less than c \n"
0x1000000c " but not less than c \n"
0x10000010 "a greater than or equal to b"
