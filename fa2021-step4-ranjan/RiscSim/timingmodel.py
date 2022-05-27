class defaultTimingModel :
    def __init__(self) :
        self.elapsedTime = 0
        pass

    def exec(self, inst) :
        pass

    def cacheExec(self, inst, address) :
        pass

    def getTotalTime(self) :
        return self.elapsedTime

class basicTimingModel(defaultTimingModel) :
    def __init__(self) :
        self.timingMap = {}
        self.__initTimingMap()
        self.elapsedTime = 0

    def exec(self, inst) :
        try :
            self.elapsedTime += self.timingMap[inst.opcode]
        except KeyError :
            self.elapsedTime += 1

    def cacheExec(self, inst, address) :
        self.exec(inst)

    def __initTimingMap(self) :
        self.timingMap['SUB'] = 2
        self.timingMap['MUL'] = 3
        self.timingMap['DIV'] = 4
        self.timingMap['REM'] = 4
        self.timingMap['FADD.S'] = 4
        self.timingMap['FSUB.S'] = 4
        self.timingMap['FMUL.S'] = 5
        self.timingMap['FDIV.S'] = 6
        self.timingMap['FMIN.S'] = 3
        self.timingMap['FMAX.S'] = 3
        self.timingMap['FSQRT.S'] = 10
        self.timingMap['FLT.S'] = 3
        self.timingMap['FLE.S'] = 3
        self.timingMap['FEQ.S'] = 3
        self.timingMap['LW'] = 2
        self.timingMap['FLW'] = 2
        self.timingMap['SW'] = 1
        self.timingMap['FSW'] = 1
        self.timingMap['FIMM.S'] = 2
        self.timingMap['FMOVI.S'] = 4
        self.timingMap['IMOVF.S'] = 4
        self.timingMap['HALT'] = 0



        