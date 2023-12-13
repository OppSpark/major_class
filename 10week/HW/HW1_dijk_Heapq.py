import heapq

v, e = map(int, input().split(" "))
s = int(input())
g_list = [list(map(int, input().split())) for _ in range(e)]

g_keys = range(v)
g_dict = {g_key : [] for g_key in g_keys}

for a in g_list :
    a[0]  -= 1
    a[1] -= 1
    g_dict[a[0]].append((a[1], a[2]))

def dijkstra2(g, e):
    n = len(g)
    s = e
    distance = [float('inf') for _ in range(n)]
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

    for i in range(n):
        print(distance[i])

dijkstra2(g_dict, s-1)
