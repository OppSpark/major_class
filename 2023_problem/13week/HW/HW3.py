def backtracking(sum, index):
    global ans
    if sum > B:
        return
    ans = max(ans, sum)
    for i in range(index + 1, N):
        if sum + v[i] > B:
            continue
        backtracking(sum + v[i], i)

if __name__ == "__main__":
    B = int(input())
    N = int(input())
    v = list(map(int, input().split()))

    ans = 0
    v.sort(reverse=True)

    for i in range(N):
        backtracking(v[i], i)

    print(ans)

