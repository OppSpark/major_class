n, E = map(int, input().split())

g = [[] for _ in range(n)]

for _ in range(E):
    A, B, C = map(int, input().split())
    g[A - 1].append((B - 1, C))
    g[B - 1].append((A - 1, C))

include = [False] * n
D = [float('inf')] * n
D[0] = 0
connected_to = [-1] * n

for _ in range(n):
    m = -1
    min_value = float('inf')
    for j in range(n):
        if not include[j] and D[j] < min_value:
            min_value = D[j]
            m = j
    include[m] = True

    for w, wt in g[m]:
        if not include[w] and wt < D[w]:
            D[w] = wt
            connected_to[w] = m


mst_cost = 0
for i in range(1, n):
    mst_cost += D[i]
print(mst_cost)
