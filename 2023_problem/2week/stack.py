stack = []
def push(item) :
    stack.append(item)

def pop() :

    if len(stack) != 0 :
        item = stack.pop(-1)
        return None



push(input())
print(stack)
push(input())
print(stack)
push(input())
print(stack)

pop()
print(stack)
pop()
print(stack)
pop()
print(stack)






