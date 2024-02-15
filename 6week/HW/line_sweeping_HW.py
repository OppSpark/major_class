# 가장 가까운 두 좌표 찾기

# 라인 스위핑 알고리즘을 이용한
#
#









import sys
import math
import random
# N개의 좌표로 입력 만들기
N = 100
a = []
random. seed(0)
i = 0
while i < N:
    x_coord = random. randint (0, 100)
    y_coord = random. randint(0, 100)
    if [x_coord, y_coord] not in a:
        a. append( [x_coord, y_coord])
        i += 1

print(a)

def closestPair(coordinates, n):

    points = [(coordinates[i][0], coordinates[i][1]) for i in range(n)]
    points.sort()


    d = sys.maxsize


    st = set()
    st.add(points[0])

    for i in range(1, n):
        l = set([p for p in st if p[0] >= points[i][0] - d and p[1] >= points[i][1] - d])
        r = set([p for p in st if p[0] <= points[i][0] + d and p[1] <= points[i][1] + d])
        intersection = l & r
        if len(intersection) == 0:
            continue
        for val in intersection:
            dis = math.pow(points[i][0] - val[0], 2) + math.pow(points[i][1] - val[1], 2)
            if d > dis:
                d = dis
        st.add(points[i])


    return d


p = len(a)

print(closestPair(a,p))
