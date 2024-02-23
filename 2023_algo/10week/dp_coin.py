def f(coin, money, memo):
    if money in memo:
        return memo[money]
    if money == 0:
        return 0
    if money < 0:
        return float('inf')
    
    count = float('inf')
    for i in range(len(coin)):
        count = min(count, 1 + f(coin,money-coin[i],memo))
    memo[money] = count
    return count

D = {}
print(f([5,10],25,D))
print(D)

D = {}
print(f([2, 5,11],99,D))
print(D)