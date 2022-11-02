# 정수 a와 b를 2진수로 표현했을 때 a를 b로 바꾸기 위해 뒤집어야 하는 비트 개수


class Bit():
    def __init__(self, A, B):
        self.A = self.convertTobit(A)[2:]
        self.B = self.convertTobit(B)[2:]
        self.matchingLength()

    def convertTobit(self, num):
        for i in str(num):
            if i == '0' or i == '1':
                continue
            else:
                return str(bin(num))
        return '0b' + str(num)

    def matchingLength(self):
        if len(self.A) > len(self.B):
            tmp = ""
            for _ in range(len(self.A) - len(self.B)):
                tmp += "0"
            self.B = tmp + self.B

        elif len(self.A) == len(self.B):
            pass
        elif len(self.A) < len(self.B):
            tmp = ""
            for _ in range(len(self.B) - len(self.A)):
                tmp += "0"
            self.A = tmp + self.A

    def convertAtoB(self):
        print(self)
        count=0
        for idx, val in enumerate(self.A):
            if val != self.B[idx]:
                count+=1

        print(f"{count}번 바꾸면 A는 B가 된다")

    def __str__(self):
        return "A : "+str(self.A) + '\n' \
               "B : "+ str(self.B)


bit = Bit(1100, 321)
bit.convertAtoB()

