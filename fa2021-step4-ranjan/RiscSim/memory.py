class Memory(dict) :
    #initialize memory by making clear what the valid segments are: .globals, .stack, .heap, .text, .strings
    #IMPORTANT: memory is not byte addressable -- can only be addressed at word granularity -- means we do not have to actually manage byte mapping
    #           and we don't have to worry about endianness
    #IMPORTANT: we do not actually allow reading/writing to the text space, but Memory keeps track of the address range since it's part of the memory configuration
    def __init__(self, globs = (0x20000000, 0x30000000), 
                       stack = (0x30000000, 0x40000000), 
                       heap = (0x40000000, 0x80000000), 
                       text = (0x00000000, 0x10000000), 
                       strings = (0x1000000, 0x20000000)) :
        super().__init__()
        self.globs = globs
        self.stack = stack
        self.heap = heap
        self.text = text
        self.strings = strings

    def __getitem__(self, key) :
        self.__validateAddress(key)
        return super().__getitem__(key)

    def __setitem__(self, key, value) :
        self.__validateAddress(key)
        super().__setitem__(key, value)

    def __missing__(self, key) :
        assert False, "Reading from uninitialized memory location: " + hex(key)

    def __validateAddress(self, key) :
        #key needs to be an integer
        assert(type(key) == int), "Can only address memory with integers"

        #key needs to be a multiple of 4
        assert(key % 0x4 == 0), "Memory must be addressed at byte granularity"

        #key needs to be in a segment
        valid = False
        for s in [self.globs, self.stack, self.heap, self.strings] :
            if (key >= s[0] and key < s[1]) :
                valid = True
        assert valid == True, "Address not in a mapped segment"


if __name__ == '__main__' :

    memory = Memory()        
    
    memory[0x20100000] = 80
    print(memory[0x20100000])
    print(memory[0x10100004]) #should fail