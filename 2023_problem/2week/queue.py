queue = []
def push(item) :
    queue.append(item)

def pop() :
    if len(queue) != 0 :
        item = queue.pop(0)
        return None



push(input())
print(queue)
push(input())
print(queue)
push(input())
print(queue)


pop()
print(queue)
pop()
print(queue)
pop()
print(queue)

