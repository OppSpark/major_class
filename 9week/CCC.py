def f(coin,money):
    if money==0:
        return 0
    if money<0: 
        return float('inf') 
    count=float('inf')
    for i in range(len(coin)):
        count=min(count,1+f(coin,money-coin[i])) 
    return count

print(f([5,10],15))