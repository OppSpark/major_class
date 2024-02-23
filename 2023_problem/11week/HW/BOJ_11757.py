import sys

# 무한대를 나타내는 값
INF = float('inf')

# n m을 입력받는다.
n, m = map(int, sys.stdin.readline().split())
bus = []

#노선 정보를  a b c를 입력 받는다.
for _ in range(m):
    a, b, c = map(int, sys.stdin.readline().split())
    bus.append((a, b, c))

# 최단 거리를 저장할 리스트 dist를 무한대로 초기화한다.
#(아직 어떤 도시로 가는 경로도 알지 못하기 때문)
dist = [INF]*(n+1)
dist[1] = 0  # 시작 도시인 1번 도시까지의 거리는 0이다.

# 벨만-포드 알고리즘
def bf(start):
    dist[start] = 0  # 시작 도시까지의 거리는 0
    # 모든 도시에 대해 n번 반복
    # n번 반복하는 이유는 최악의 경우 모든 도시를 순회하는 경로를 고려하기 때문
    for i in range(n):
        # 모든 버스 노선에 대해 반복한다.
        for j in range(m):
            cur = bus[j][0]  # 현재 도시
            next_node = bus[j][1]  # 다음 도시
            cost = bus[j][2]  # 현재 도시에서 다음 도시로 가는데 필요한 시간
            #최단 거리가 '무한대'가 아니고, 다음 도시까지의 거리가 '현재 도시까지의 거리 + 현재 도시에서 다음 도시로 가는데 필요한 시간 보다 크면 값을 갱신합니다.
            if dist[cur] != INF and dist[next_node] > dist[cur] + cost:
                dist[next_node] = dist[cur] + cost
                # n번째 라운드에서도 값이 갱신된다면 음수 순환이 존재
                if i == n - 1:
                    return True
    return False

# 벨만-포드 알고리즘을 실행하여 음수를 확인하는 문장
negative_cycle = bf(1)

# 음수가 있으면ㄴ -1을 출력
if negative_cycle:
    print(-1)
else:
    # 1번 도시에서 출발해 2번 도시, 3번 도시, N번 도시로 가는 가장 빠른 시간을 출력한다.
    for i in range(2, n+1):
        # 해당 도시로 가는 경로가 없다면 대신 -1을 출력합니다.
        if dist[i] == INF:
            print(-1)
        else:
            print(dist[i])
