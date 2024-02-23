n = 8
s = 0
g = [[]] * n

g[0] = [[1, 3], [3, 5], [4, 6]]
g[1] = [[2, 3], [3, 1], [5, 4]]
g[2] = [[1, 7]]
g[3] = [[4, 4], [5, 1]]
g[4] = [[5, 8], [6, 1]]
g[5] = [[2, 6], [7, 10]]
g[6] = [[5, 9], [7, 1]]
g[7] = []

included = [False for _ in range(n)]
distance = [float('inf') for _ in range(n)]
distance[s] = 0
previous = [-1 for _ in range(n)]
previous[s] = 0

for k in range(n):
    m = -1
    min_value = float('inf')
    for j in range(n):
        if not included[j] and distance[j] < min_value:
            min_value = distance[j]
            m = j
    included[m] = True
    print(f'm(정점) : {m}, min_calue(최소거리) : {min_value}')
    print(f'included : {included}')

    for w, wt in g[m]:
        if not included[w] and distance[m] + wt < distance[w]:
            distance[w] = distance[m] + wt
            previous[w] = m
        print(f'distance : {distance}')
        print(f'previous : {previous}')
        print('=' * 60)

print('정점', s, '으로부터 최단 거리')
for i in range(n):
    if distance[i] == float('inf'):
        print(s, "와", i, "사이에 경로 없음")
    else:
        print(f"[{s},{i}] = {distance[i]}")

print("\n 정점 ", s,"로 부터 최단 경로 : ")
for i in range(n):
    back = i
    print(back != s)
    while back != s:
        print(" <- ",previous[back], end = " ")
        back = previous[back]
print()