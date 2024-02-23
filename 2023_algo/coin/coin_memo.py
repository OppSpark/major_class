def f(money):
    if money in memo: return memo[money]
    if money == 0 : return 0
    if money < 0: return float('int')
    count = float('inf')
    for i in range(len(coin)):
        count = min(count, 1 + f(money -coin[i]))
    memo[money] = count
    return count

coin, memo=[5,10], {}
print(f(25))
print(memo)


    