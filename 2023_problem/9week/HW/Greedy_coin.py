def coinChange(money):
    coin.sort(reverse=True)
    S = []
    for i in range(len(coin)):
        quantity = money // coin[i]
        S.append(f"{coin[i]}원, {quantity}개") 
        money = money % coin[i]
    return S

coin = [1, 10, 50, 100, 500, 1000, 5000, 10000, 50000]

print("금액을 입력하세요 : ", end="")
money = int(input())

results = coinChange(money)
for result in results:
    print(result)