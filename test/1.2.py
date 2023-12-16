def greatestRecur(L,i):

    if i==len(L)-1:

        return L[i]
    print(L[i])
    return max(L[i],greatestRecur(L,i+1))

L=[5,2,8,3,4,9,2,5,7,7,2,1,4,111,7,8,1,2]
print(greatestRecur(L,0))