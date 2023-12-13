def arr(a):
    return a if a >= 0 else -a

N = int(input())
cnt = 0
que = [0] * 20
check = 0

def search(num):
    global cnt
    global check
    if num == N + 1:
        cnt += 1
    for i in range(1, N + 1):
        que[num - 1] = i
        check = 1
        for j in range(1, num):
            if i == que[j - 1] or arr(i - que[j - 1]) == num - j:
                check = 0
        if check:
            search(num + 1)

search(1)
print(cnt)

