W = [5, 4, 6, 3]
V = [10, 40 ,30 ,50]
K = 10
n = len(W)
T = [[0 for _ in range(K-1)] for _ in range(n+1)]

for i in range(n):
    for j in range(K+1):
        if W[i] > j:
            T[i][j] = T[i-1][j]
        else:
            T[i][j] = max(T[i-1][j], V[i] + T[i-1][j-W[i]])
print("최대 가치 : ", T[n-1][K]) 
