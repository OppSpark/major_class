

#역방향 위상 정렬

adj_list = [[1], [3, 4], [0, 1], [6], [5], [3, 7], [7], [8], []]
n = len(adj_list)  # 그래프 정점 수
visited = [False for _ in range(n)]  # 방문되면 True 로
s = []

def dfs(v):
    visited[v] = True  # 정점 v 방문
    for w in adj_list[v]:  # 정점 v에 인접한 각 정점에 대해
        if not visited[w]:
            dfs(w)  # v에 인접한 방문 안된 정점 w에 대해 순환 호출
    s.append(v)  # v에 인접한 모든 점에 s에 이미 추가되어 있으므로 v를 s에 추가


for i in range(n):
    if not visited[i]:
        dfs(i)
print('dfs : ', s)
s.reverse()
print('위상 정렬 순서 : ', s)