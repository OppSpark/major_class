def fibo(n, memo):
    if n in memo :
        return memo[n]
    if n <2 :  # 제귀 호출 하는데 하위  n -1 , n -2 가 음수로 되기 때문
        return n
    memo[n] = fibo(n -1, memo) + fibo(n-2, memo)
    return memo[n]

memo ={} #값을 저장할 딕셔너리
print(fibo(6, memo))

print(fibo(60, memo))