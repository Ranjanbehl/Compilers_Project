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
GETI t1
SW t1, -4(fp)
GETI t2
SW t2, -8(fp)
LW t3, -4(fp)
SW t3, 0(sp)
ADDI sp, sp, -4
LW t4, -8(fp)
SW t4, 0(sp)
ADDI sp, sp, -4
ADDI sp, sp, -4
SW ra, 0(sp)
ADDI sp, sp, -4
JR func_foo
ADDI sp, sp, 4
LW ra, 0(sp)
ADDI sp, sp, 4
LW t5, 0(sp)
ADDI sp, sp, 8
SW t5, -12(fp)
LW t6, -4(fp)
SW t6, 0(sp)
ADDI sp, sp, -4
LW t7, -8(fp)
SW t7, 0(sp)
ADDI sp, sp, -4
ADDI sp, sp, -4
SW ra, 0(sp)
ADDI sp, sp, -4
JR func_bar
ADDI sp, sp, 4
LW ra, 0(sp)
ADDI sp, sp, 4
LW t8, 0(sp)
ADDI sp, sp, 8
SW t8, -16(fp)
LW t9, -12(fp)
PUTI t9
LW t10, -16(fp)
PUTI t10
LI t11, 0
SW t11, 8(fp)
J func_ret_main
func_ret_main:
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

func_foo:
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
LW t1, 16(fp)
LW t2, 12(fp)
ADD t3, t1, t2
SW t3, 8(fp)
J func_ret_foo
func_ret_foo:
ADDI sp, sp, 4
LW t3, 0(sp)
ADDI sp, sp, 4
LW t2, 0(sp)
ADDI sp, sp, 4
LW t1, 0(sp)
MV sp, fp
LW fp, 0(fp)
RET

func_bar:
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
LW t1, 16(fp)
LW t2, 12(fp)
SUB t3, t1, t2
SW t3, 8(fp)
J func_ret_bar
func_ret_bar:
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
