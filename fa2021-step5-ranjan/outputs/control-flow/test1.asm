; Symbol table GLOBAL
; name cur type INT location 0x20000000
; Function: INT main([])

; Symbol table main

.section .text
;Current temp: null
;IR Code: 
MV fp, sp
JR func_main
HALT
;
;
;Function: main
func_main:
SW fp, 0(sp)
MV fp, sp
ADDI sp, sp, -4
ADDI sp, sp, -0
;Saving registers
SW x4, 0(sp)
ADDI sp, sp, -4
SW x5, 0(sp)
ADDI sp, sp, -4
SW x6, 0(sp)
ADDI sp, sp, -4
;
;Start of BB
LI x4, 0
MV x5, x4
;Saving registers at end of BB
LA x3, 0x20000000
SW x5, 0(x3)
;End of BB
;Start of BB
loop_1:
LI x4, 10
LA x3, 0x20000000
LW x5, 0(x3)
;Saving registers at end of BB
BGE x5, x4, out_1
;End of BB
;Start of BB
LI x4, 4
LA x3, 0x20000000
LW x5, 0(x3)
ADD x6, x5, x4
MV x5, x6
;Saving registers at end of BB
LA x3, 0x20000000
SW x5, 0(x3)
J loop_1
;End of BB
;Start of BB
out_1:
LA x3, 0x20000000
LW x4, 0(x3)
PUTI x4
LI x5, 0
MV x6, x5
;Saving registers at end of BB
SW x6, 8(fp)
J func_ret_main
;End of BB
;
func_ret_main:
;Restore registers
ADDI sp, sp, 4
LW x6, 0(sp)
ADDI sp, sp, 4
LW x5, 0(sp)
ADDI sp, sp, 4
LW x4, 0(sp)
MV sp, fp
LW fp, 0(fp)
RET
;End of function main
;


.section .strings
