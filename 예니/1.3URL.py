# 모든 공백 -> 공백 하나마다 %20으로 바꿔야할지, 연속된 공백이라면 하나로 치는지?
# 하나마다로 구현하긴 했음

def makeUrl(str, length):
    result = ""
    toBeString = "%20"
    asIsString = " "
    for character in str:
        if character == asIsString:
            result += toBeString
        else:
            result += character
    return result
            

str = "Mr John Smith"
str = "wer       werwer wer werwe rwer    "
length = 13
print(makeUrl(str, length))