; Symbol table GLOBAL
; name querysize type STRING location 0x10000000 value "Enter size: "
; name prompt type STRING location 0x10000004 value "Enter number: "
; name sorting type STRING location 0x10000008 value "Sorting ..."
; Function: VOID swap([PTR, PTR])
; Function: PTR allocarray([INT])
; Function: VOID readarray([PTR, INT])
; Function: VOID printarray([PTR, INT])
; Function: VOID quicksort([PTR, INT, INT])
; Function: INT partition([PTR, INT, INT])
; Function: INT main([])

; Symbol table main
; name f type PTR location -4
; name size type INT location -8

; Symbol table allocarray
; name size type INT location 12
; name i type INT location -4
; name retval type PTR location -8

; Symbol table readarray
; name size type INT location 12
; name f type PTR location 16
; name i type INT location -4
; name x type FLOAT location -8

; Symbol table quicksort
; name hi type INT location 12
; name lo type INT location 16
; name f type PTR location 20
; name p type INT location -4

; Symbol table partition
; name hi type INT location 12
; name lo type INT location 16
; name f type PTR location 20
; name pivot type FLOAT location -4
; name i type INT location -8
; name j type INT location -12

; Symbol table printarray
; name size type INT location 12
; name f type PTR location 16
; name i type INT location -4

; Symbol table swap
; name y type PTR location 12
; name x type PTR location 16
; name tmp type FLOAT location -4

; generating code to print ; name querysize type STRING location 0x10000000 value "Enter size: "
; generating code to print ; name prompt type STRING location 0x10000004 value "Enter number: "
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
ADDI sp, sp, -8
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
LA t1, 0x10000000
PUTS t1
GETI t2
SW t2, -8(fp)
LW t3, -8(fp)
SW t3, 0(sp)
ADDI sp, sp, -4
ADDI sp, sp, -4
SW ra, 0(sp)
ADDI sp, sp, -4
JR func_allocarray
ADDI sp, sp, 4
LW ra, 0(sp)
ADDI sp, sp, 4
LW t4, 0(sp)
ADDI sp, sp, 4
SW t4, -4(fp)
LW t5, -4(fp)
SW t5, 0(sp)
ADDI sp, sp, -4
LW t6, -8(fp)
SW t6, 0(sp)
ADDI sp, sp, -4
ADDI sp, sp, -4
SW ra, 0(sp)
ADDI sp, sp, -4
JR func_readarray
ADDI sp, sp, 4
LW ra, 0(sp)
ADDI sp, sp, 4
ADDI sp, sp, 8
LW t11, -4(fp)
SW t11, 0(sp)
ADDI sp, sp, -4
LI t7, 0
SW t7, 0(sp)
ADDI sp, sp, -4
LW t9, -8(fp)
LI t8, 1
SUB t10, t9, t8
SW t10, 0(sp)
ADDI sp, sp, -4
ADDI sp, sp, -4
SW ra, 0(sp)
ADDI sp, sp, -4
JR func_quicksort
ADDI sp, sp, 4
LW ra, 0(sp)
ADDI sp, sp, 4
ADDI sp, sp, 12
LW t12, -4(fp)
SW t12, 0(sp)
ADDI sp, sp, -4
LW t13, -8(fp)
SW t13, 0(sp)
ADDI sp, sp, -4
ADDI sp, sp, -4
SW ra, 0(sp)
ADDI sp, sp, -4
JR func_printarray
ADDI sp, sp, 4
LW ra, 0(sp)
ADDI sp, sp, 4
ADDI sp, sp, 8
LW t14, -4(fp)
FREE t14
LI t15, 0
SW t15, 8(fp)
J func_ret_main
func_ret_main:
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

func_allocarray:
SW fp, 0(sp)
MV fp, sp
ADDI sp, sp, -4
ADDI sp, sp, -8
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
FSW f1, 0(sp)
ADDI sp, sp, -4
LI t1, 4
LW t2, 12(fp)
MUL t3, t1, t2
MALLOC t4, t3
SW t4, -8(fp)
LI t5, 0
SW t5, -4(fp)
loop_1:
LW t6, -4(fp)
LW t7, 12(fp)
BGE t6, t7, out_1
LW t11, -8(fp)
LW t9, -4(fp)
LI t8, 4
MUL t10, t9, t8
ADD t12, t11, t10
FIMM.S f1, 0.0
FSW f1, 0(t12)
LW t14, -4(fp)
LI t13, 1
ADD t15, t14, t13
SW t15, -4(fp)
J loop_1
out_1:
LW t16, -8(fp)
SW t16, 8(fp)
J func_ret_allocarray
func_ret_allocarray:
ADDI sp, sp, 4
FLW f1, 0(sp)
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

func_readarray:
SW fp, 0(sp)
MV fp, sp
ADDI sp, sp, -4
ADDI sp, sp, -8
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
FSW f1, 0(sp)
ADDI sp, sp, -4
FSW f2, 0(sp)
ADDI sp, sp, -4
LI t1, 0
SW t1, -4(fp)
loop_2:
LW t2, -4(fp)
LW t3, 12(fp)
BGE t2, t3, out_2
LA t4, 0x10000004
PUTS t4
GETF f1
FSW f1, -8(fp)
LW t8, 16(fp)
LW t6, -4(fp)
LI t5, 4
MUL t7, t6, t5
ADD t9, t8, t7
FLW f2, -8(fp)
FSW f2, 0(t9)
LW t11, -4(fp)
LI t10, 1
ADD t12, t11, t10
SW t12, -4(fp)
J loop_2
out_2:
func_ret_readarray:
ADDI sp, sp, 4
FLW f2, 0(sp)
ADDI sp, sp, 4
FLW f1, 0(sp)
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

func_quicksort:
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
LW t1, 16(fp)
LW t2, 12(fp)
BGE t1, t2, out_3
LW t3, 20(fp)
SW t3, 0(sp)
ADDI sp, sp, -4
LW t4, 16(fp)
SW t4, 0(sp)
ADDI sp, sp, -4
LW t5, 12(fp)
SW t5, 0(sp)
ADDI sp, sp, -4
ADDI sp, sp, -4
SW ra, 0(sp)
ADDI sp, sp, -4
JR func_partition
ADDI sp, sp, 4
LW ra, 0(sp)
ADDI sp, sp, 4
LW t6, 0(sp)
ADDI sp, sp, 12
SW t6, -4(fp)
LW t10, 20(fp)
SW t10, 0(sp)
ADDI sp, sp, -4
LW t11, 16(fp)
SW t11, 0(sp)
ADDI sp, sp, -4
LW t8, -4(fp)
LI t7, 1
SUB t9, t8, t7
SW t9, 0(sp)
ADDI sp, sp, -4
ADDI sp, sp, -4
SW ra, 0(sp)
ADDI sp, sp, -4
JR func_quicksort
ADDI sp, sp, 4
LW ra, 0(sp)
ADDI sp, sp, 4
ADDI sp, sp, 12
LW t15, 20(fp)
SW t15, 0(sp)
ADDI sp, sp, -4
LW t13, -4(fp)
LI t12, 1
ADD t14, t13, t12
SW t14, 0(sp)
ADDI sp, sp, -4
LW t16, 12(fp)
SW t16, 0(sp)
ADDI sp, sp, -4
ADDI sp, sp, -4
SW ra, 0(sp)
ADDI sp, sp, -4
JR func_quicksort
ADDI sp, sp, 4
LW ra, 0(sp)
ADDI sp, sp, 4
ADDI sp, sp, 12
out_3:
func_ret_quicksort:
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

func_partition:
SW fp, 0(sp)
MV fp, sp
ADDI sp, sp, -4
ADDI sp, sp, -12
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
SW t17, 0(sp)
ADDI sp, sp, -4
SW t18, 0(sp)
ADDI sp, sp, -4
SW t19, 0(sp)
ADDI sp, sp, -4
SW t20, 0(sp)
ADDI sp, sp, -4
SW t21, 0(sp)
ADDI sp, sp, -4
SW t22, 0(sp)
ADDI sp, sp, -4
SW t23, 0(sp)
ADDI sp, sp, -4
SW t24, 0(sp)
ADDI sp, sp, -4
SW t25, 0(sp)
ADDI sp, sp, -4
SW t26, 0(sp)
ADDI sp, sp, -4
SW t27, 0(sp)
ADDI sp, sp, -4
SW t28, 0(sp)
ADDI sp, sp, -4
SW t29, 0(sp)
ADDI sp, sp, -4
SW t30, 0(sp)
ADDI sp, sp, -4
SW t31, 0(sp)
ADDI sp, sp, -4
SW t32, 0(sp)
ADDI sp, sp, -4
SW t33, 0(sp)
ADDI sp, sp, -4
SW t34, 0(sp)
ADDI sp, sp, -4
SW t35, 0(sp)
ADDI sp, sp, -4
SW t36, 0(sp)
ADDI sp, sp, -4
SW t37, 0(sp)
ADDI sp, sp, -4
SW t38, 0(sp)
ADDI sp, sp, -4
SW t39, 0(sp)
ADDI sp, sp, -4
SW t40, 0(sp)
ADDI sp, sp, -4
SW t41, 0(sp)
ADDI sp, sp, -4
SW t42, 0(sp)
ADDI sp, sp, -4
FSW f1, 0(sp)
ADDI sp, sp, -4
FSW f2, 0(sp)
ADDI sp, sp, -4
FSW f3, 0(sp)
ADDI sp, sp, -4
LW t4, 20(fp)
LW t2, 12(fp)
LI t1, 4
MUL t3, t2, t1
ADD t5, t4, t3
FLW f1, 0(t5)
FSW f1, -4(fp)
LW t6, 16(fp)
SW t6, -8(fp)
LW t7, 16(fp)
SW t7, -12(fp)
loop_3:
LW t8, -12(fp)
LW t9, 12(fp)
BGE t8, t9, out_5
LW t13, 20(fp)
LW t11, -12(fp)
LI t10, 4
MUL t12, t11, t10
ADD t14, t13, t12
FLW f2, 0(t14)
FLW f3, -4(fp)
FLT.S t28, f2, f3
BEQ t28, x0, out_4
LW t18, 20(fp)
LW t16, -8(fp)
LI t15, 4
MUL t17, t16, t15
ADD t19, t18, t17
SW t19, 0(sp)
ADDI sp, sp, -4
LW t23, 20(fp)
LW t21, -12(fp)
LI t20, 4
MUL t22, t21, t20
ADD t24, t23, t22
SW t24, 0(sp)
ADDI sp, sp, -4
ADDI sp, sp, -4
SW ra, 0(sp)
ADDI sp, sp, -4
JR func_swap
ADDI sp, sp, 4
LW ra, 0(sp)
ADDI sp, sp, 4
ADDI sp, sp, 8
LW t26, -8(fp)
LI t25, 1
ADD t27, t26, t25
SW t27, -8(fp)
out_4:
LW t30, -12(fp)
LI t29, 1
ADD t31, t30, t29
SW t31, -12(fp)
J loop_3
out_5:
LW t35, 20(fp)
LW t33, -8(fp)
LI t32, 4
MUL t34, t33, t32
ADD t36, t35, t34
SW t36, 0(sp)
ADDI sp, sp, -4
LW t40, 20(fp)
LW t38, 12(fp)
LI t37, 4
MUL t39, t38, t37
ADD t41, t40, t39
SW t41, 0(sp)
ADDI sp, sp, -4
ADDI sp, sp, -4
SW ra, 0(sp)
ADDI sp, sp, -4
JR func_swap
ADDI sp, sp, 4
LW ra, 0(sp)
ADDI sp, sp, 4
ADDI sp, sp, 8
LW t42, -8(fp)
SW t42, 8(fp)
J func_ret_partition
func_ret_partition:
ADDI sp, sp, 4
FLW f3, 0(sp)
ADDI sp, sp, 4
FLW f2, 0(sp)
ADDI sp, sp, 4
FLW f1, 0(sp)
ADDI sp, sp, 4
LW t42, 0(sp)
ADDI sp, sp, 4
LW t41, 0(sp)
ADDI sp, sp, 4
LW t40, 0(sp)
ADDI sp, sp, 4
LW t39, 0(sp)
ADDI sp, sp, 4
LW t38, 0(sp)
ADDI sp, sp, 4
LW t37, 0(sp)
ADDI sp, sp, 4
LW t36, 0(sp)
ADDI sp, sp, 4
LW t35, 0(sp)
ADDI sp, sp, 4
LW t34, 0(sp)
ADDI sp, sp, 4
LW t33, 0(sp)
ADDI sp, sp, 4
LW t32, 0(sp)
ADDI sp, sp, 4
LW t31, 0(sp)
ADDI sp, sp, 4
LW t30, 0(sp)
ADDI sp, sp, 4
LW t29, 0(sp)
ADDI sp, sp, 4
LW t28, 0(sp)
ADDI sp, sp, 4
LW t27, 0(sp)
ADDI sp, sp, 4
LW t26, 0(sp)
ADDI sp, sp, 4
LW t25, 0(sp)
ADDI sp, sp, 4
LW t24, 0(sp)
ADDI sp, sp, 4
LW t23, 0(sp)
ADDI sp, sp, 4
LW t22, 0(sp)
ADDI sp, sp, 4
LW t21, 0(sp)
ADDI sp, sp, 4
LW t20, 0(sp)
ADDI sp, sp, 4
LW t19, 0(sp)
ADDI sp, sp, 4
LW t18, 0(sp)
ADDI sp, sp, 4
LW t17, 0(sp)
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

func_printarray:
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
FSW f1, 0(sp)
ADDI sp, sp, -4
LI t1, 0
SW t1, -4(fp)
loop_4:
LW t2, -4(fp)
LW t3, 12(fp)
BGE t2, t3, out_6
LW t7, 16(fp)
LW t5, -4(fp)
LI t4, 4
MUL t6, t5, t4
ADD t8, t7, t6
FLW f1, 0(t8)
PUTF f1
LW t10, -4(fp)
LI t9, 1
ADD t11, t10, t9
SW t11, -4(fp)
J loop_4
out_6:
func_ret_printarray:
ADDI sp, sp, 4
FLW f1, 0(sp)
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

func_swap:
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
FSW f1, 0(sp)
ADDI sp, sp, -4
FSW f2, 0(sp)
ADDI sp, sp, -4
FSW f3, 0(sp)
ADDI sp, sp, -4
LW t1, 16(fp)
FLW f1, 0(t1)
FSW f1, -4(fp)
LW t2, 16(fp)
LW t3, 12(fp)
FLW f2, 0(t3)
FSW f2, 0(t2)
LW t4, 12(fp)
FLW f3, -4(fp)
FSW f3, 0(t4)
func_ret_swap:
ADDI sp, sp, 4
FLW f3, 0(sp)
ADDI sp, sp, 4
FLW f2, 0(sp)
ADDI sp, sp, 4
FLW f1, 0(sp)
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
0x10000000 "Enter size: "
0x10000004 "Enter number: "
0x10000008 "Sorting ..."
