import instructions
import re
from util import parseint
import timingmodel
import config

class Program :
    def __init__(self) :
        self.labels = {}
        self.code = {}

    #file format:
    #.section .text
    #<code>
    #.section .strings
    #addr string
    #addr string
    #...
    def buildCode(self, lines) :
        state = 0
        for line in lines :
            l = line.strip()
            if ((l == "") or (l[0] == ';')) : continue
            # print ("line: " + l)
            if (state == 0) :
                if (l == ".section .text") :
                    currAddr = config.machine.memory.text[0]
                    state = 1
            elif (state == 1) :
                if (l == ".section .strings") :
                    currAddr = config.machine.memory.strings[0]
                    state = 2
                else :                    
                    currAddr = self.addInstr(l, currAddr)
            elif (state == 2) :
                self.addString(l)

    def buildCodeFromFile(self, filename) :
        with open(filename, 'r') as f:
            lines = f.readlines()
            self.buildCode(lines)

    def addInstr(self, l, addr) :
        #if it's a label, create an entry in the label dictionary, but don't bump the pointer
        if (l[-1] == ':') :
            #get label name:
            label = re.match(r'(.+):', l)[1]
            self.labels[label] = addr
            return addr
        else :
            #otherwise parse the instruction and add it to the list
            inst = instructions.parseInstruction(l)
            # print ("Adding instruction: " + inst.opcode + " at address " + str(addr))
            self.code[addr] = inst
            return addr + 4

    def addString(self, l) :
        match = re.match(r'(\S+) (.+)', l)
        addr = parseint(match[1])
        string = bytes(match[2][1:-1], 'utf-8').decode('unicode_escape')
        config.machine.memory[addr] = string
                

### TEST ###
if __name__ == '__main__' :
    p = Program()
    p.buildCodeFromFile('testFile.asm')
    print(p.code)

    config.machine.timingModel = timingmodel.basicTimingModel()

    print (p.labels)

    #bad test -- need to build machine simulator
    pc = 0
    while (pc in p.code) :
        print (p.code[pc])
        p.code[pc].exec()
        pc += 4

    print(config.machine.timingModel.getTotalTime())