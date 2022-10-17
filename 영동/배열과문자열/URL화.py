# 문자열에 들어있는 모든 공백을 %20로 바꿔주는 메서드
# 유니코드에서 공백 = %20

def convertSpaceToUnicode(string, length):
    sentence = ''
    for i in string:
        if i == ' ':
            sentence += '%20'
        else:
            sentence += i
    return sentence

print(convertSpaceToUnicode('Mr John Smith', 13))

