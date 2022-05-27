numIntRegisters = 64 #TODO: make this a configurable number, at least 32
numFloatRegisters = 64 #TODO: make this a configurable number, at least 32
numRegisters = numIntRegisters + numFloatRegisters

class Register :
    def __init__(self) :
        self.value = None
        self.name = None
        self.type = None

    def read(self) :
        return self.value

    def write(self, value) :
        if (self.name == 'x0') :
            pass
        elif (type(value) != self.type) :
            raise(TypeError('Writing data of type ' + str(type(value)) + ' to register ' + self.name + ' which holds type ' + str(self.type)))
        else :
            self.value = value

    def __repr__(self) :
        return 'Register ' + self.name

    def __str__(self) :
        return str(self.value)

class IRegister(Register) :
    def __init__(self, name) :
        super().__init__()
        self.value = 0
        self.name = name
        self.type = int

class FRegister(Register) :
    def __init__(self, name) :
        super().__init__()
        self.value = 0.0
        self.name = name
        self.type = float


if __name__ == '__main__' :
    print(numRegisters)
    print(registerFile)

    registerFile['t3'].write(4)
    print(registerFile['x28']) #should print 4

    registerFile['f3'].write(5.0)
    print(registerFile['ft3']) #should print 5.0