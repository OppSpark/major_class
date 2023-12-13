def fibo(n, memo):
    if memo[n]>=0: 
        return memo[n]
    if n<2: 
        memo[n]=n
    else:
        memo[n]=fibo(n-1,memo)+fibo(n-2,memo)
    return memo[n]

n=6 
memo=[-1]*(n+1)
print(fibo(n,memo))
print(memo)
n=600
memo=[-1]*(n+1) 
print(fibo(n,memo))
