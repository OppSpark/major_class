def ft(Name, Price, Weight, C):
    L = list(zip(Name, Price, Weight))
    S, maxP = [], 0
    L.sort(key=lambda k: k[1] / k[2], reverse = True)
    for n, p, w in L:
        if w > C:
            S.append((n,C/w))
            maxP += C*p/w
            break
        S.append((n, 1))
        C -= w
        maxP += p

    return maxP, S


Name=['A','B','C']
Price=[150,100,150]
Weight=[10,20,5]
Capacity=20
print(ft(Name,Price,Weight,Capacity))