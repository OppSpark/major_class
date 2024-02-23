#합치 최대 K가 되는숫자문제
S= [0, 3, 4, 5, 6]
K = 13 
n = len(S)-1
T =[[0 for _ in range(K+1)] for _ in range(n+1)]

for i in range(1, n+1): # S를 의미
    for j in range(K+1): # K를 의미
        if S[i] > j:
            T[i][j] = T[i-1][j] #S[i]를 트럭에 못넣음
        else:
            T[i][j] = max(T[i -1][j], T[i-1][j-S[i]]) #S[i] 포함 여부 결정 
print("T[", n ,",", K,"] = ",T[n][K])


