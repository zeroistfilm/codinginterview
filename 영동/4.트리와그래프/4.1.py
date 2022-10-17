# 방향그래프가 주어졌을대 두 노드 사이에 경로가 존재하는지 확인하는 알고리즘
# 파라미터 인접행렬, 시작노드, 종료노드입력, BFS로 탐색


class BFS:
    def __init__(self):
        from collections import deque
        self.map = None
        self.start = None
        self.end = None
        self.curr = None
        self.isVisited = None
        self.quque = deque()
        self.canVisitMap = None

    def setMap(self, map):
        self.map = map

    def setStartNode(self, node):
        self.start = node
        self.quque.append(node)

    def setEndNode(self, node):
        self.end = node

    def search(self):
        self.getIsVisited()
        while len(self.quque) != 0:
            self.curr = self.quque.popleft()
            canVisitList = self.getToGoList(self.curr)
            for ToNode in canVisitList:
                if self.canVisit(self.curr, ToNode):
                    self.checkVisit(self.curr, ToNode)
                else:
                    continue
                self.quque.append(ToNode)
                self.checkCanVisit(ToNode)


    def canVisit(self,curr,to):
        return self.isVisited[curr][to] == False

    def checkCanVisit(self, node):
        self.canVisitMap[self.start][node] = True

    def checkVisit(self, curr, to):
        self.isVisited[curr][to] = True

    def getToGoList(self, node):
        submap = self.map[node]
        canVisitList = []
        for i in range(len(submap)):
            if submap[i] == 1:
                canVisitList.append(i)

        return canVisitList

    def getIsVisited(self):
        assert self.map is not None
        self.isVisited = [[False for _ in range(len(self.map[0]))] for _ in range(len(self.map))]
        self.canVisitMap = [[False for _ in range(len(self.map[0]))] for _ in range(len(self.map))]

    def canGoAtoB(self, A, B):
        return self.map[A][B] == 1

    def canVisitAtoB(self, A, B):
        return not (self.isVisited[A][B] == True)

    def canStartToEnd(self):
        return self.canVisitMap[self.start][self.end]



map = [[0, 1, 0, 0, 1, 1],
       [0, 0, 0, 1, 1, 0],
       [0, 1, 0, 0, 0, 0],
       [0, 0, 1, 0, 1, 0],
       [0, 0, 0, 0, 0, 0],
       [0, 0, 0, 0, 0, 0], ]

bfs = BFS()
bfs.setMap(map)
bfs.setStartNode(2)
bfs.setEndNode(0)
bfs.search()
print(bfs.canStartToEnd())