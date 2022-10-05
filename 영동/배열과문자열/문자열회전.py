def isSubString(s1,s2):
    if s2 in s1:
        return True
    else:
        return False

def isRotate(s1, s2):
    return isSubString(s1+s1,s2)

print(isRotate("waterbottle","erbottlewat"))