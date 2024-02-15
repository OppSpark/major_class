<aside>
💡 최소 비용 신장 트리 (MST)

</aside>

최소 비용 신장 트리

- n개의 점을 가진 그래프의 신장 트리는 n - 1개으 간선을 가진다.
- 두 점 사이 결로는 하나 밖에 없다.

나누어 해결하기

- 그래프를 t1과 t2로 나누고 각각에 대해 MST를 만든다.
- t1과t2를 연결하는 건설들 중에서 가장 가중치가 작은 간선으로 t1과 t2를 연결해 트리를 만든다.

### 크러스컬(Kruskal) 알고리즘

- 간선이 사이클을 만들지 않으면 추가하고 만들면 그 간선을 버린다.
- 

### 프림(Prim) 알고리즘

- 임의점 하나나를 선택해 T(트리)에 넣는다
- 다음을 n - 1회 수행한다
- T(트리) 밖에 있는 점들 중 T에 있는 점과 가장 가까운 점을 추가한다.

수행 시간은 O(n^2)

```python
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

for k in range(n):
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

print("MST : ",end="")
mst_cost = 0
for i in range(1, n):
    print("(%d, %d)" % (i, connected_to[i]), end="")
    mst_cost += D[i]
print("\n  MST의 가중치는 : ", mst_cost)
```