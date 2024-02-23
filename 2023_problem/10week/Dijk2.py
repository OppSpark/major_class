

v, e = map(int, input().split(" "))
s = int(input())
g_list = [list(map(int, input().split())) for _ in range(e)]

g_keys = range(v)
g_dict = {g_key : [] for g_key in g_keys}

for a in g_list :
    a[0]  -= 1
    a[1] -= 1
    g_dict[a[0]].append(a[1:])


def dijkstra2(g, e):
    n = len(g)
    s = e
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

    if m >= 0:
        for w, wt in g.get[m]:
            if not included[w] and distance[m] + wt < distance[w]:
                distance[w] = distance[m] + wt
                previous[w] = m

    for i in range(n):
        print(distance[i])


dijkstra2(g_dict, s-1)

