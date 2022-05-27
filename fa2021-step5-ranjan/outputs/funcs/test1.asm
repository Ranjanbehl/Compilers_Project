; Symbol table GLOBAL
; Function: INT foo([INT, INT])
; Function: INT bar([INT, INT])
; Function: INT main([])

; Symbol table main
; name a type INT location -4
; name b type INT location -8
; name c type INT location -12
; name d type INT location -16

; Symbol table foo
; name y type INT location 12
; name x type INT location 16

; Symbol table bar
; name y type INT location 12
; name x type INT location 16

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
ADDI sp, sp, -16
;Saving registers
SW x4, 0(sp)
ADDI sp, sp, -4
SW x5, 0(sp)
ADDI sp, sp, -4
SW x6, 0(sp)
ADDI sp, sp, -4
SW x7, 0(sp)
ADDI sp, sp, -4
SW x9, 0(sp)
ADDI sp, sp, -4
SW x10, 0(sp)
ADDI sp, sp, -4
SW x11, 0(sp)
ADDI sp, sp, -4
SW x12, 0(sp)
ADDI sp, sp, -4
;
;Start of BB
GETI x4
GETI x5
SW x4, 0(sp)
ADDI sp, sp, -4
SW x5, 0(sp)
ADDI sp, sp, -4
ADDI sp, sp, -4
SW ra, 0(sp)
ADDI sp, sp, -4
JR func_foo
ADDI sp, sp, 4
LW ra, 0(sp)
ADDI sp, sp, 4
LW x6, 0(sp)
ADDI sp, sp, 8
MV x7, x6
SW x4, 0(sp)
ADDI sp, sp, -4
SW x5, 0(sp)
ADDI sp, sp, -4
ADDI sp, sp, -4
SW ra, 0(sp)
ADDI sp, sp, -4
JR func_bar
ADDI sp, sp, 4
LW ra, 0(sp)
ADDI sp, sp, 4
LW x9, 0(sp)
ADDI sp, sp, 8
MV x10, x9
PUTI x7
PUTI x10
LI x11, 0
MV x12, x11
;Saving registers at end of BB
SW x4, -4(fp)
SW x5, -8(fp)
SW x7, -12(fp)
SW x10, -16(fp)
SW x12, 8(fp)
J func_ret_main
;End of BB
;
func_ret_main:
;Restore registers
ADDI sp, sp, 4
LW x12, 0(sp)
ADDI sp, sp, 4
LW x11, 0(sp)
ADDI sp, sp, 4
LW x10, 0(sp)
ADDI sp, sp, 4
LW x9, 0(sp)
ADDI sp, sp, 4
LW x7, 0(sp)
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
;
;Function: foo
func_foo:
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
SW x7, 0(sp)
ADDI sp, sp, -4
;
;Start of BB
LW x4, 16(fp)
LW x5, 12(fp)
ADD x6, x4, x5
MV x7, x6
;Saving registers at end of BB
SW x7, 8(fp)
J func_ret_foo
;End of BB
;
func_ret_foo:
;Restore registers
ADDI sp, sp, 4
LW x7, 0(sp)
ADDI sp, sp, 4
LW x6, 0(sp)
ADDI sp, sp, 4
LW x5, 0(sp)
ADDI sp, sp, 4
LW x4, 0(sp)
MV sp, fp
LW fp, 0(fp)
RET
;End of function foo
;
;
;Function: bar
func_bar:
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
SW x7, 0(sp)
ADDI sp, sp, -4
;
;Start of BB
LW x4, 16(fp)
LW x5, 12(fp)
SUB x6, x4, x5
MV x7, x6
;Saving registers at end of BB
SW x7, 8(fp)
J func_ret_bar
;End of BB
;
func_ret_bar:
;Restore registers
ADDI sp, sp, 4
LW x7, 0(sp)
ADDI sp, sp, 4
LW x6, 0(sp)
ADDI sp, sp, 4
LW x5, 0(sp)
ADDI sp, sp, 4
LW x4, 0(sp)
MV sp, fp
LW fp, 0(fp)
RET
;End of function bar
;


.section .strings
