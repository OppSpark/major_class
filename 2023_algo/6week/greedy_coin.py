def coinChange(coin,money):
    coin.sort(reverse=True)
    count = 0
    S = []

    for i in range(len(coin)):
        quantity = money // coin[i]
        S.append((coin[i], quantity))
        count += quantity
        money = money % coin[i]
    return count, S

coin=[1,5,10,50,100,500]
money=1237
print(coinChange(coin,money))