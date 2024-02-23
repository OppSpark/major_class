import heapq

N = int(input()) 
M = int(input())

g_dict = {i: [] for i in range(N)}

for _ in range(M):
    u, v, w = map(int, input().split())
    u -= 1
    v -= 1
    g_dict[u].append((v, w))

start, end = map(int, input().split())
start -= 1
end -= 1

def dijkstra(g, s, e):
    n = len(g)
    distance = [float('inf')] * n
    distance[s] = 0
    queue = [(0, s)]

    while queue:
        current_distance, m = heapq.heappop(queue)

        if distance[m] < current_distance:
            continue

        for w, wt in g.get(m, []):
            new_distance = current_distance + wt
            if new_distance < distance[w]:
                distance[w] = new_distance
                heapq.heappush(queue, (new_distance, w))

    return distance[e]

print(dijkstra(g_dict, start, end))
