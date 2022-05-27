def parseint(intstr) :
    if (intstr.startswith('0x')) :
        return int(intstr, 16)
    elif (intstr.startswith('0')) :
        return int(intstr, 8)
    else :
        return int(intstr)