# 스택의 가장 작은 값이 위로 오도록 스택을 정렬
from stack import Stack


class Stack3(Stack):
    def __init__(self):
        super().__init__()
        self.tmpStack = Stack()
        self.tmpValue = None
        self.minValue = None

        self.minStack = Stack()


    def push(self, data):
        if self.minValue == None or self.minValue > data:
            self.minValue = data
            self.minStack.push(data)
        super().push(data)

    def getMinValue(self):
        return self.minValue

    def isSorted(self):
        if self.getStack() == sorted(list(self.getStack())):
            return True
        return False


    def sort(self):
        #1. 스택에서 팝
        #2. 임시값과 비교, 꺼낸 값이 임시값과 비교해서 크면, 임시값을 새로운 스택에 넣고, 임시값을 꺼낸값으로 바꾼다
        #3. 임시값과 비교, 꺼낸 값이 임시값보다 작으면, 꺼낸값 새로운 스택에 넣는다.
        #4. 새로운 스택에 있는 값을 모두 원래 스택으로 돌려준다.
        #5. 정렬될 때까지 반복

        while not self.isSorted():
            while not self.isEmpty():
                data = self.pop()
                if self.tmpValue == None:
                    self.tmpValue = data
                    continue

                if data >= self.tmpValue:
                   self.tmpStack.push(self.tmpValue)
                   self.tmpValue = data
                else:
                    self.tmpStack.push(data)

            self.push(self.tmpValue)
            while not self.tmpStack.isEmpty():
                self.push(self.tmpStack.pop())

            self.tmpValue = None
            self.tmpStack=Stack()

s = Stack3()
s.push(-1)
s.push(1)
s.push(-1)
s.push(10)
s.push(8)
s.push(7)
s.push(11)
s.push(3)
s.push(1)
print(s.getStack())
s.sort()
print(s.getStack())
