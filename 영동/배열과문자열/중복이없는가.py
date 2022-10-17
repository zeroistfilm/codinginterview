#이미 사용된 문자가 있는지 체크
def isDuplicate(s):
    checked={}
    for i in s:
        if i not in checked:
            checked[i]=i
        else:
            return True
    return False

print(isDuplicate(''))