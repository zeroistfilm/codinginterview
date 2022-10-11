from LinkedList import Node, deleteNode

node = Node(1)
node.appendToTail(3)
node.appendToTail(7)
node.appendToTail(8)
node.appendToTail(8)
node.appendToTail(8)
node.appendToTail(8)
node.appendToTail(8)
node.appendToTail(7)
node.appendToTail(7)
node.appendToTail(7)
node.appendToTail(7)
node.appendToTail(3)
node.appendToTail(2)
node.appendToTail(7)
node.appendToTail(10)

checkSet=set()
for data in node.getElement():
    if data not in checkSet:
        checkSet.add(data)
    else:
        deleteNode(node, data)

print(node.getElement())