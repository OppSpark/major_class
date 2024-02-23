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

print(makeAdjList([5,2,8,6,4,6,1,9,3]))

print("")

#가장 긴 증가수열 구하기
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
    print(f'length : {length}')
    print(f'length : {previous}')
    k = length.index(max(length))
    seq = [k]
    while previous[k] != -1:
        seq.insert(0, previous[k])
        k = previous[k]
    print(f'seq = {seq}')
    lis = [s[i] for i in seq]
    print(f'가장 긴 증가 순서 : {lis}')

getLongestIncreasingSeq([10,20,10,30,20,50])
