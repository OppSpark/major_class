INF = float('inf')
# graph = [[INF, 1, 2, 4],
#          [INF, 1, 2, 3]]
#
graph = []
v, e = map(int, input().split(" "))

for i in range(v + 1):
    tmp = []
    for _ in range(e + 1):
        tmp.append(INF)
    graph.append(tmp)

graph = [list(map(int, input().split())) for _ in range(e)]


print(e)
print(graph)
n = len(graph)
s = 0
D = [INF for _ in range(n)]
D[s] = 0
previous = [-1 for _ in range(n)]
previous[0] = 0


previous[s] = 0
for k in range(n - 1):
    for i in range(n):
        for j in range(n):
            if graph[i][j] != INF:
                if D[j] > D[i] + graph[i][j]:
                    D[j] = D[i] + graph[i][j]
                    previous[j] = i

print("정점 %1d 로 부터 촤단 거리" % s)
for i in range(n):

    print("[%d, %d] = %3d" % (s, i, D[i]))

print("정점 0 으로부터 최단 경로")
print()
for i in range(n):
    back = i
    while back != 0:
        print("<-", previous[back], end=" ")
        back = previous[back]
    print()
