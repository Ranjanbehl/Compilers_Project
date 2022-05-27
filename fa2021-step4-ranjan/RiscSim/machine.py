from memory import Memory
from registers import IRegister
from registers import FRegister
import timingmodel
import program
import config

class Machine :
    def __init__(self, numIntRegisters = 32, numFloatRegisters = 32, timingModel = timingmodel.defaultTimingModel) :
        self.memory = Memory()
        
        self.registerFile = {}
        self.numIntRegisters = numIntRegisters
        self.numFloatRegisters = numFloatRegisters
        self.__createRegisterFile()

        self.timingModel = timingModel()
        # print(self.timingModel)

        self.prog = None

        self.pc = self.memory.text[0]
        self.registerFile['sp'].write(self.memory.text[1] - 4) #initialize the stack pointer

    def __createRegisterFile(self) :
        #initialize integer registers
        for i in range(self.numIntRegisters) :
            name = 'x' + str(i)
            self.registerFile[name] = IRegister(name)

        #Standard integer register aliases
        self.registerFile['zero'] = self.registerFile['x0']
        self.registerFile['ra'] = self.registerFile['x1']
        self.registerFile['sp'] = self.registerFile['x2']
        self.registerFile['gp'] = self.registerFile['x3']
        self.registerFile['tp'] = self.registerFile['x4']
        self.registerFile['t0'] = self.registerFile['x5']
        self.registerFile['t1'] = self.registerFile['x6']
        self.registerFile['t2'] = self.registerFile['x7']
        self.registerFile['s0'] = self.registerFile['x8']
        self.registerFile['fp'] = self.registerFile['x8']
        self.registerFile['s1'] = self.registerFile['x9']
        self.registerFile['a0'] = self.registerFile['x10']
        self.registerFile['a1'] = self.registerFile['x11']
        self.registerFile['a2'] = self.registerFile['x12']
        self.registerFile['a3'] = self.registerFile['x13']
        self.registerFile['a4'] = self.registerFile['x14']
        self.registerFile['a5'] = self.registerFile['x15']
        self.registerFile['a6'] = self.registerFile['x16']
        self.registerFile['a7'] = self.registerFile['x17']
        self.registerFile['s2'] = self.registerFile['x18']
        self.registerFile['s3'] = self.registerFile['x19']
        self.registerFile['s4'] = self.registerFile['x20']
        self.registerFile['s5'] = self.registerFile['x21']
        self.registerFile['s6'] = self.registerFile['x22']
        self.registerFile['s7'] = self.registerFile['x23']
        self.registerFile['s8'] = self.registerFile['x24']
        self.registerFile['s9'] = self.registerFile['x25']
        self.registerFile['s10'] = self.registerFile['x26']
        self.registerFile['s11'] = self.registerFile['x27']
        self.registerFile['t3'] = self.registerFile['x28']
        self.registerFile['t4'] = self.registerFile['x29']
        self.registerFile['t5'] = self.registerFile['x30']
        self.registerFile['t6'] = self.registerFile['x31']

        #alias any extra integer registers
        for i in range(self.numIntRegisters - 32) :
            self.registerFile['t' + str(7 + i)] = self.registerFile['x' + str(32 + i)]

        #initialize floating point registers
        for f in range(self.numFloatRegisters) :
            name = 'f' + str(f)
            self.registerFile[name] = FRegister(name)    

        #standard floating point register aliases
        for i in range(0, 8) :
            self.registerFile['ft' + str(i)] = self.registerFile['f' + str(i)]

        self.registerFile['fs0'] = self.registerFile['f8']
        self.registerFile['fs1'] = self.registerFile['f9']

        for i in range(0, 8) :
            self.registerFile['fa' + str(i)] = self.registerFile['f1' + str(i)]

        for i in range(2, 12) :
            self.registerFile['fs' + str(i)] = self.registerFile['f' + str(16 + i)]

        for i in range(8, 12) :
            self.registerFile['ft' + str(i)] = self.registerFile['f' + str(20 + i)]

        #alias any extra floating point registers
        for f in range(self.numFloatRegisters - 32) :
            self.registerFile['ft' + str(12 + f)] = self.registerFile['f' + str(32 + f)]

    def execProgram(self, p) :
        self.prog = p
        self.pc = self.memory.text[0]
        while (self.pc != -1) :
            # print(self.pc)
            inst = p.code[self.pc]
            inst.exec()
        

# machine = Machine(numIntRegisters = 64, numFloatRegisters = 64)

#### TEST ####

if __name__ == '__main__' :
    p = program.Program()
    p.buildCodeFromFile('testFile.asm')

    config.machine.execProgram(p)