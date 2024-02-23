# N: 물건의 종류의 수, M: 가방의 최대 무게
N, M = map(int, input().split())

# dp[j]: 무게가 j일때의 최대 만족도
dp = [0]*(M+1)

# 각 물건에 대해 반복
for _ in range(N):
    # V: 물건의 무게, C: 만족도, K: 물건의 개수
    V, C, K = map(int, input().split())
    
    # 물건의 개수만큼 반복
    for _ in range(K):
        # 가방의 무게를 V부터 M까지 역순으로 반복
        for j in range(M, V-1, -1):
            # dp[j]는 현재 무게 j에서의 최대를 의마함
            # dp[j-V] + C는 물건을 하나 추가했을 때의 값
            # dp[j]와 dp[j-V] + C 중 큰 값을 dp[j]에 저장
            dp[j] = max(dp[j], dp[j-V] + C)

print(dp[M])
