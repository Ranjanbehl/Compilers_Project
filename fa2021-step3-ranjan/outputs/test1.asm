; Symbol table GLOBAL
; name cur type INT location 0x20000000

.section .text
;Current temp: null
;IR Code: 
LA t2, 0x20000000
LI t1, 0
SW t1, 0(t2)
loop_1:
LA t4, 0x20000000
LW t5, 0(t4)
LI t3, 10
BGE t5, t3, out_1
LA t10, 0x20000000
LA t7, 0x20000000
LW t8, 0(t7)
LI t6, 4
ADD t9, t8, t6
SW t9, 0(t10)
J loop_1
out_1:
LA t11, 0x20000000
LW t12, 0(t11)
PUTI t12
LI t13, 0
HALT


.section .strings
