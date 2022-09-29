# 문자열 편집 3가지
# 삽입, 삭제, 교체
# 두문자가 같게 하기 위해 편집회수가 1회 이내인지


def isLessConvert(count):
    if count <= 1:
        return True
    else:
        return False

def getEditCount(string1, string2):
    # 삽입 삭제
    if len(string1) != len(string2):
        return getWordCount(string1, string2)
    # 교체
    else:
        return getDiffCount(string1, string2)

def getAlphabetIndex(alphabet):
    return ord(alphabet) - ord('a')

def getWordCount(str1, str2):
    # 순서상관없고 알파벳 개수만
    str1Array = [0 for i in range(26)]
    str2Array = [0 for i in range(26)]
    resultArray= [0 for i in range(26)]
    for s in str1:
        str1Array[getAlphabetIndex(s)] += 1
    for s in str2:
        str2Array[getAlphabetIndex(s)] += 1

    for idx in range(26):
        resultArray[idx] = str1Array[idx] - str2Array[idx]
    return sum(resultArray)


def getDiffCount(str1, str2):
    assert len(str1) == len(str2)
    result = []
    for idx in range(len(str1)):
        if str1[idx] == str2[idx]:
            result.append(False)
        else:
            result.append(True)
    return sum(result)


print(isLessConvert(getEditCount("apple", "aple")))
print(isLessConvert(getEditCount("pale", "ple")))
print(isLessConvert(getEditCount("pales", "pale")))
print(isLessConvert(getEditCount("pale", "bale")))
print(isLessConvert(getEditCount("pale", "bake")))
