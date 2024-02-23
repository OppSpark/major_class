S =[1,4, 7, 13, 26, 64, 125, 260, 550]
K = 85

S = input(int)

S.sort()
Solution = []
i = len(S) - 1
while K > 0:
    if S[i] <= K:
        Solution.append(S[i])
        K -= S[i]
    i -= 1

print(Solution)


