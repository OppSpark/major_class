n = int(input())
s = list(map(int,input().split()))


def makeAdjList(s):
    result = []
    for i in range(len(s)):
        al = []
        if i > 0:
            for j in range(i):
                if s[i] >s[j]:
                    al.append(j)
        result.append(al)
    return result

def getLongestIncreasingSeq(s):
    n = len(s)
    g = makeAdjList(s)
    previous = [-  1 for _ in range(n)]
    length = [1 for _ in range(n)]
    for i in range(1, n):
        if len(g[i]) > 0: #들어온 간선이 있으면
            max_length = -1 # 최장 길이를 -1 이라고 본다.
            for j in g[i]:
                if length[j] > max_length:
                    max_length = length[j]
                    previous[i] = j
                length[i] = max_length + 1

    k = length.index(max(length))
    seq = [k]
    while previous[k] != -1:
        seq.insert(0, previous[k])
        k = previous[k]

    lis = [s[i] for i in seq]
    print(len(lis))
    
    print(*lis)


getLongestIncreasingSeq(s)