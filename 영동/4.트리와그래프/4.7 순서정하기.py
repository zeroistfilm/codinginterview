# 프로젝트 리스트와 프로젝트간의 종속관계가 리스트 쌍으로 주어진다.
# 프로젝트를 수행하는 순서를 찾아라
#
from typing import List, Any


class calcProjectOrder:


    def __init__(self, projects, relactions):
        self.projects = projects
        self.relations = relactions

        self.startPointList = []
        self.independentList = []
        self.getAdjacencyMatrix()

        from collections import deque
        self.quque = deque()
        self.order = []
        self.visitNode = [False for _ in range(len(self.projects))]

    def getAdjacencyMatrix(self):
        # 인접행렬 생성
        # 프로젝트가 이름으로 주어지니까 인덱스 매칭을 위해 딕셔너리 사용

        self.projectIdx = {}
        self.projectName = {}
        self.slaveCallCount = [0 for i in range(len(self.projects))]

        for index, project in enumerate(self.projects):
            self.projectIdx[project] = index
            self.projectName[index] = project

        self.adjMat = [[0 for _ in range(len(self.projects))] for _ in range(len(self.projects))]
        for MasterWork, slaveWork in self.relations:
            masterIndex = self.projectIdx[MasterWork]
            slaveIndex = self.projectIdx[slaveWork]
            self.adjMat[masterIndex][slaveIndex] = 1
            self.slaveCallCount[slaveIndex] += 1

    def calc(self):
        self.getStartPointCandidationIndex()
        self.getIndependentProject()
        self.getIsVisited()
        # 독립프로젝트는 별도 실행. 맨 앞에 실행, 사실 위치는 상관 없음
        for idx in self.independentList:
            self.order.append(self.projectName[idx])

        # 프로젝트 순서 구하기
        for startPoint in self.startPointList:
            self.quque.append(startPoint)
            self.order.append(self.projectName[startPoint])

            while len(self.quque) != 0:
                curr = self.quque.popleft()
                self.setVisitNode(curr)
                canVisitList = self.getToGoList(curr)
                for ToNode in canVisitList:
                    if self.canVisit(curr, ToNode):
                        self.setVisit(curr, ToNode)
                        if self.canVisitNode(ToNode):
                            self.setVisitNode(ToNode)
                            self.order.append(self.projectName[ToNode])
                    else:
                        continue
                    self.quque.append(ToNode)

            #print(self.order)

    def getIsVisited(self):
        assert self.adjMat is not None
        self.isVisited = [[False for _ in range(len(self.adjMat[0]))] for _ in range(len(self.adjMat))]
        self.canVisitMap = [[False for _ in range(len(self.adjMat[0]))] for _ in range(len(self.adjMat))]

    def canVisit(self, curr, to):
        return self.isVisited[curr][to] == False

    def setVisitNode(self, node):
        self.visitNode[node] = True

    def canVisitNode(self, node):
        #print(self.visitNode, node, self.visitNode[node])
        return self.visitNode[node] == False

    def setVisit(self, curr, to):
        self.isVisited[curr][to] = True

    def getToGoList(self, node):
        submap = self.adjMat[node]
        canVisitList = []
        for i in range(len(submap)):
            if submap[i] == 1:
                canVisitList.append(i)

        return canVisitList

    def getIndependentProject(self):
        # 독립된 프로젝트는 인접행렬의 값이 0이고 다른 프로젝트로부터 호출되지 않음.
        for idx, row in enumerate(self.adjMat):
            if sum(row) == 0 and self.slaveCallCount[idx] == 0:
                self.independentList.append(idx)

    def getStartPointCandidationIndex(self):
        # 시작 후보를 구합니다.
        # 시작후보는 인접리스트에서 가장 큰 값을 가지는 행이다.

        self.startPointList = []
        canGoCount = [0 for i in range(len(self.projects))]
        for idx, row in enumerate(self.adjMat):
            canGoCount[idx] = sum(row)

        for idx, row in enumerate(self.adjMat):
            if sum(row) == max(canGoCount):
                self.startPointList.append(idx)


projects = ['a', 'b', 'c', 'd', 'e', 'f']
relations = [('a', 'd'),
             ('f', 'b'),
             ('b', 'd'),
             ('f', 'a'),
             ('d', 'c'), ]

cpo = calcProjectOrder(projects, relations)
cpo.calc()
print(cpo.order)
