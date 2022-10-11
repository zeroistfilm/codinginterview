# 스택의 가장 작은 값이 위로 오도록 스택을 정렬
from stack import Stack


class Stack3(Stack):
    def __init__(self):
        super().__init__()
        self.tmpStack = Stack()
        self.tmpValue = None

    def sort(self):
        while super().isEmpty():
            data = super().pop()
            if self.tmpValue == None:
                self.tmpValue = data
                continue

            if data <= self.tmpValue:
               self.tmpStack.push(self.tmpValue)
               self.tmpValue = data



s = Stack3()
s.push(10)
s.push(8)
s.push(7)
s.push(11)
s.push(3)
s.push(-1)
s.sort()
print(s.peak())