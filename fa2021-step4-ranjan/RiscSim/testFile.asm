.section .text
l0:
    ADDI t1, t0, 30
    ADDI t2, t0, 20
    BGE t1, t2, l2
    SUB t3, t1, t2
    PUTI t3
    LUI t4, 0x10000
    PUTS t4
    JR f0
    J l1
    HALT

l1:
    PUTS t4
    JR f0
    PUTS t4
    HALT

l2:
    LUI t6, 0x10002
    PUTS t6
    HALT

f0:
    LUI t5, 0x10001
    PUTS t5
    RET

.section .strings
    0x10000000 "Hello world\n"
    0x10001000 "In function\n"
    0x10002000 "Took branch\n"