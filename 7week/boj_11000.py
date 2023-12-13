
#시간복잡도를 O(n^2) 으로 푸는 풀이

cnt = int(input())

a = []

for i in range(cnt) :
    start, end = map(int, input().split())
    a.append([start, end])

n = len(a)
a.sort(key=lambda key : key [0])

finish_time = [a[0][1]]

k = 0

for i in range(1, n):
  flag = False
  for j in range(k + 1):
    if a [i][0] >= finish_time[j]:
      finish_time[j] = a[i][1]
      flag = True
      break

  if not flag:
    k += 1
    finish_time.append(a[i][1])

print (k + 1)