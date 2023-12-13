stack = []
stack = list(input())
think = True
for i in range(0,len(stack) -1) :
    if stack[i] != stack[len(stack) -1 -i] :
        think = False
        break


if think :
    print("YES")
    print(stack[0: len(stack) // 2])
else :
    print("NO")
    stack.reverse()
    print(stack)



