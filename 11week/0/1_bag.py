#백준 배낭 문제
memo=[]
def f(n,M):
    if memo[n][M] != -1 :
        return memo[n][M]
    if n==0 or M==0:
        return 0
    if M<w[n-1]: 
        memo[n][M]=f(n-1,M)
    else: memo[n][M]=max( f(n-1,M), p[n-1]+f(n-1,M-w[n-1]) ) 
    return memo[n][M]

cnt , M = map(int,input().split())

w,p =[],[]
for i in range(cnt):
    a, b = list(map(int,input().split()))
    w.append(a)
    p.append(b)

for i in range(len(w)+1): 
    memo.append([-1]*(M+1))

print(f(len(w),M))