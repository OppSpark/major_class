def filtering(A, d):
    A.sort()
    F = [A[0]]
    rep_num = A[0]
    for j in range(1, len(A)):
        if A[j] > (rep_num * (1 +d)):
            F.append(A[j])
            rep_num = A[j]
    return F

S = [-1, 1110, 1008, 1250,1006]
K = 2500
n = len(S)
epsilon = 0.4
delta = epsilon / (2 * n)
T = [[0]for _ in range(n)]

for i in range(1, n):
    T[i] = list(set(T[i-1]) | set([x +S[i] for x in T[i - 1]]))
    T[i] = filtering(T[i],delta)
    T[i] = [x for x in T[i]  if x <= K]

print("마지막 숫자 리스트 : ",T[n-1])
print("근사 해 = ", max(T[n-1]))