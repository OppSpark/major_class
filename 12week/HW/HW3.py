N, M = map(int, input().split())
m = [0] + list(map(int, input().split()))
c = [0] + list(map(int, input().split()))
dp = [[0 for _ in range(sum(c)+1)] for _ in range(N+1)]
result = sum(c)

for i in range(1, N+1):
    for j in range(sum(c)+1):
        if j < c[i]:
            dp[i][j] = dp[i-1][j]
        else:
            dp[i][j] = max(dp[i-1][j], dp[i-1][j-c[i]] + m[i])
        if dp[i][j] >= M:
            result = min(result, j)

print(result)
