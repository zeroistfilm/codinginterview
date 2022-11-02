class bitReverse():
    def __init__(self, num):
        self.bit = self.convertTobit(num)[2:]
        print(self.bit)
        self.zeroPosition = None

        self.getZeroPosition()

    def convertTobit(self, num):
        for i in str(num):
            if i == '0' or i == '1':
                continue
            else:
                return bin(num)
        return '0b' + str(num)

    def getZeroPosition(self):
        zeroPosition=[]
        for i in range(len(self.bit)):
            if self.bit[i] == '0':
                zeroPosition.append(i)

        self.zeroPosition = zeroPosition

    def run(self):

        #   ↓
        # 11011101111
        # <-┴--> 개수 새기

        #       ↓
        # 11011101111
        #    <--┴---> 개수 새기

        oneIsland = []
        tmp=[]
        tmp.append(0)
        for i in self.zeroPosition:
            tmp.append(i+1)
        tmp.append(len(self.bit)+1)

        candidate = tmp[1:-1]
        for i in range(1,len(candidate)+1):
            count = tmp[i+1]-tmp[i-1]-1
            oneIsland.append(count)

        self.maxindex = oneIsland.index(max(oneIsland))+1
        self.maxLength = max(oneIsland)

        print(f"전체 0 중  \"{self.maxindex}\" 번째 위치의 0 값을 1로 바꾸면 \"{self.maxLength}\"의 가장 긴 길이가 나온다")



br = bitReverse(1775)
br.run()

