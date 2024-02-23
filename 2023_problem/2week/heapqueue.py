import heapq

a = [124,2,85,35,84,21,78,643,8,4,8531,21312]

print("정렬 전 값 ", a)

heapq.heapify(a)


print("힙 :  ", a)

s = []

while a:
    s.append(heapq.heappop(a))


print("정렬 후 값 : ", s)


