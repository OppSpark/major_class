n = 6
g = [[]] * n


g[0] = [[1, 4], [3, 8], [4, 2]]
g[1] = [[0, 4], [2, 9], [4, 3]]
g[2] = [[1, 9], [3, 2], [5, 1]]
g[3] = [[0, 8], [2, 2], [4, 4], [5, 1]]
g[4] = [[0, 2], [1, 3], [2, 7], [3, 4]]
g[5] = [[2, 1], [3, 1]]



include = [False for _ in range(n)]
D = [float('inf') for _ in range(n)]
D[0] = 0
connected_to = [-1 for _ in range(n)]

#트리 밖에 있는 정점 중에 D[] 값이 가장 작은 정점을 선택
for k in range(n): 
    m = -1
    min_value = float('inf')
    for j in range(n):
        if not include[j] and D[j] < min_value:
            min_value = D[j]
            m = j
    include[m] = True

# 정점 m에 인접하면서 트리에 속하지 않는 점의 D[] 값을 더 작은 값을 갱신
    for w, wt in g[m]: #현재 트리에 마지막으로 속한 정점의 인접리스트르 살펴보기
        if not include[w] and wt < D[w]: #더 작은 D값을 반결하면 갱신
            D[w] = wt
            connected_to[w] = m

print("MST : ",end="")
mst_cost = 0
for i in range(1, n):
    print("(%d, %d)" % (i, connected_to[i]), end="")
    mst_cost += D[i]
print("\n  MST의 가중치는 : ", mst_cost)
    
