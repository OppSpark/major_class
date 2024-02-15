# 가장 가까운 두 좌표 찾기

"""
라인 스위핑은 어떤 문제가 하나의 포인터를 가지고,어느 한쪽에서 다른 한쪽으로 쓱 훑으면서 답을 찾는 알고리즘입니다.
이 알고리즘은 다양한 방법으로 사용될 여지가 있어 특정한 어떤 구조가 있거나 루틴이 있는 것이 아닌,문제해결 컨셉 중 하나로 보통 다양한 자료구조와 함께 쓰입니다.
라인 스위핑은 스위핑 문제 중 하나로 1차원에서 사용되는 라인들이 주어질 때 이들의 길이 합을 구하는 문제이다.

라인 스위핑은 막대의 시작지점 O(nlogn)정렬 =>
다음 시작지점이 이전 끝 지점보다 작으면 끝지점을 갱신합니다. =>
다음 시작지점이 이전 끝 지점보다 크면 끝지점까지 출력 값을 갱신하고 시작지점을 변경합니다. =>
모든 막대를 검사하면, 남은 길이까지 출력 값을 갱신하고 출력합니다.
"""

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
    pair = None

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
                pair = (points[i], val)

        st.add(points[i])

    return pair


p = len(a)

print(closestPair(a,p))
