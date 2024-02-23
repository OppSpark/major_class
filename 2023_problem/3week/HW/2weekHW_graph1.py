#BFS
graph1 = [[1,2,3], [0,3],[0,3],[0,1,2]]
n = len(graph1)
visited = [False for _ in range(n+1)]

def bfs(v):
    queue = []
    visited[v] = True
    queue.append(v)
    while len(queue) != 0:
        u = queue.pop(0)
        print(u, " ", end="")
        for w in graph1[u]:
            if not visited[w] :
                visited[w] = True
                queue.append(w)
#DFS
def dfs(v):
    visited[v] = True

    print(v, " ", end="")

    for w in graph1[v]:
        if not visited[w]:
            dfs(w)

print("DFS 방문 순서 : ")
visited = [False for _ in range(n+1)]
for i in range(n):
    if not visited[i]:
        dfs(i)

print()

print("BFS 방문 순서 : ")
visited = [False for _ in range(n+1)]
for i in range(n) :
    if not visited[i] :
        bfs(i)