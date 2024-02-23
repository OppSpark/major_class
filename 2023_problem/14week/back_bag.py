n = 4
k = 10
p = [54, 40, 30, 10]
w = [3, 4, 6, 5]
maxp = 0
include = [0, 0, 0, 0]
bestset = [0, 0, 0, 0]

def promising(i, weight, profit):
    global maxp
    if weight >= k:
        return False
    else:
        j = i + 1
        bound = profit
        totweight = weight
        while j < n and totweight + w[j] <= k:
            totweight += w[j]
            bound += p[j]
            j += 1
        if j < n:
            bound += (k - totweight) * p[j] / w[j]
        return bound > maxp

def knapsackBT(i, profit, weight):
    global bestset
    global maxp

    if weight <= k and profit > maxp:
        maxp = profit
        bestset = include[:]

    if promising(i, weight, profit):
        include[i + 1] = 1
        knapsackBT(i + 1, profit + p[i + 1], weight + w[i + 1])
        include[i + 1] = 0
        knapsackBT(i + 1, profit, weight)

knapsackBT(-1, 0, 0)
print(maxp)
print(bestset)
