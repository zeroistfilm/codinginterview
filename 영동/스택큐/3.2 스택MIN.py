from stack import Stack

class Stack2(Stack):
    def __init__(self):
        super().__init__()
        self.minStack = Stack()
        self.minValue = None

    def push(self, data):
        if self.minValue == None or self.minValue > data:
            self.minValue = data
            self.minStack.push(data)
        super().push(data)

    def getMinValue(self):
        return self.minValue

    def peak(self):
        return super().peak()


s2 = Stack2()
s2.push(2)
print(s2.getMinValue())
s2.push(3)
print(s2.getMinValue())
s2.push(1)
print(s2.getMinValue())
s2.push(0)
print(s2.getMinValue())
s2.push(-100)
print(s2.getMinValue())

print(s2.peak())