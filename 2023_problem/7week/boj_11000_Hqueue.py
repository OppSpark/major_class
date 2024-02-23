#우선순위큐를 이용한 문제 풀이
#시간복잡도를 O(nlogN) 으로 풀 수 있다.
import heapq
cnt = int(input())

a = []
b = []
for i in range(cnt) :
    start, end = map(int, input().split())
    a.append([start, end])

n = len(a)
a.sort(key=lambda key : key [0])

heapq.heappush(b, a[0][1])

k = 1  #강의실 수

for i in range(1, n):  #강의실이 사용중이면
    if a[i][0] < b[0] :
        heapq.heappush(b, a[i][1])
        k += 1 #강의실을 추가
    else: #강의실이 비었을 경우
        heapq.heappop(b)
        heapq.heappush(b, a[i][1])
print (k)