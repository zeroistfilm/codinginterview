class Stack:
    def __init__(self):
        self.data = None
        self.next = None
        self.top = None

    def pop(self):
        if self.top is None:
            raise Exception('EmptyStackException')
        item = self.top.data
        self.top = self.top.next
        return item

    def push(self, data):
        stackNode = Stack()
        stackNode.data = data
        stackNode.next = self.top
        self.top = stackNode

    def peak(self):
        if self.top is None:
            raise Exception('EmptyStackException')
        return self.top.data

    def isEmpty(self):
        return self.top == None

    def getStack(self):
        tmp=[]
        node = self.top
        while True:
            tmp.append(node.data)

            if node.next==None:
                break
            node = node.next
        return tmp



