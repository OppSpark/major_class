def f(money):
    if money == 0: return 0
    if money < 0 : return float('inf')
    count = float('inf')
    for i in range(len(coin)):
        count = min(count, 1 + f(money - coin[i]))
    return count


coin = [5, 10]
print(f(15))