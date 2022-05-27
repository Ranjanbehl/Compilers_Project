; Symbol table GLOBAL
; name true type STRING location 0x10000000 value "True\n"
; name false type STRING location 0x10000004 value "False\n"
; name a type FLOAT location 0x20000000
; name b type FLOAT location 0x20000004

.section .text
;Current temp: null
;IR Code: 
LA t1, 0x20000000
FIMM.S f1, 3.0
FSW f1, 0(t1)
LA t2, 0x20000004
FIMM.S f2, 2.0
FSW f2, 0(t2)
LA t3, 0x20000000
FLW f3, 0(t3)
LA t4, 0x20000004
FLW f4, 0(t4)
FLT.S t7, f3, f4
BNE t7, x0, else_1
LA t5, 0x10000000
PUTS t5
J out_1
else_1:
LA t6, 0x10000004
PUTS t6
out_1:
LI t8, 0
HALT


.section .strings
0x10000000 "True\n"
0x10000004 "False\n"
