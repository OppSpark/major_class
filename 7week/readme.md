[Greedy20231017.ipynb](https://prod-files-secure.s3.us-west-2.amazonaws.com/4e6fe536-1497-4feb-83c3-30b51c65762e/88a051bf-9ff3-4565-b750-e5d3f87795f2/Greedy20231017.ipynb)

<aside>
💡 욕심내어 풀어보기

</aside>

그리디 알고리즘

- 최적화(Optimization) 문제 : 최솟값 OR 최댓값을 찾는 문제
- 욕심내어 해결하는 것 : 알고리즘이 수행하는 과정에서 항상 작은 것 OR  큰 것을 선택하는 방법

테스크 스케쥴링

- 테스크 스케줄링 문제는 주어지는 조건에 따라 매우 다양함
- 일반적으로 테스크 스케쥴링은 각 테스크가 수행시간이 겹치지 않게 테스크를 할당하는 법

인터벌 스케쥴링 (구간 스케쥴링)

- N개의 테스크와 1개의 프로세스가 있을 때 수행 시간이 겹치지 않게 어떤 테스크를 선택하면 가장 많은 테스크를 수행할 수 있을까?
- 단, 각 태스크는 시작과 종료 시각을 가진다.

<aside>
💡 예제 문제

</aside>

![!\[Untitled\](https://prod-files-secure.s3.us-west-2.amazonaws.com/4e6fe536-1497-4feb-83c3-30b51c65762e/b8dde49b-cce4-436c-be17-e1c6d9695ae8/Untitled.png)](1.png)

- 미팅 시간이 가장 짧은 기준으로 선정하는 방법
    1. 토론회
    2. 독서회
    3. 사진회
    
    가장 짧은 기준으로 선정  // 3개의 동아리만 선정됨
    
- 미팅 시간이 가장 긴 기준으로 선정하는 방법
    1. 지역 봉사회
    2. 문학회
    
    가장 긴 기준으로 선정   // 2개의 동아리만 선정됨
    
- 가장 빨리 종료하는 기준
    1. 서예회
    2. 바둑회
    3. 독서회
    4. 사진회
    
    최적의 해
    

Eariest Finish Time First 알고리즘

1. 종료 시각으로 정렬한다.
2. 가장 일찍 종료하는 테스크를 선택한다.
3. 다음 테스크의 시작 시간이 직전에 선택된 테ㅡ크의 종료 시간 이전이면 포기하고 이후면 선택한다.

https://colab.research.google.com/drive/17gAm74v5mXpZvpUtPxfwctVPyA0AAflV?hl=ko#scrollTo=bjdqFNXq8C4I

```python
a = [['지역 봉사회', 8, 13],['서예회', 9, 11],['토론회', 10, 12],['바둑회', 11, 14],['문학회', 13, 16],['독서회', 14, 15],['사진회', 15, 17]]

a.sort(key=lambda t : t[2])

sol = [a[0]]
t1 = 0

for i in range(1, len(a)):
  if a[i][1] >= a[t1][2]:
    sol.append(a[t1])
    t1 = i

print("선택된 동아리는 :", sol)
```

정렬 시가은 nLogN 이

Operator 정렬 함수

<aside>
💡 구간 분할

</aside>

Interval Partitioning (구간 분할)

n개으 테스크가 있을 때,  최소의 프로세스를 사용하여 수행시가이 겹치지 않게 모든 테스크를 

/ 정리 필요함 /

<aside>
💡 문제

</aside>

![!\[Untitled\](https://prod-files-secure.s3.us-west-2.amazonaws.com/4e6fe536-1497-4feb-83c3-30b51c65762e/bff3ba10-cbb5-443b-88c2-c9eef18d3e9f/Untitled.png)](2.png)

시작 시간이 가장 빠른 것 부터 정렬

- 가자 이른 시작으로 정렬를 했더니 미팅룸의 수 가 3개로 가장 적었다.
    1. 동아리들을 시작 시각으로 정렬한다.
    2. 첫 동아리를 미팅룸 1에 배정한다.
    3. 다음 동아리를 기준 미팅룸에 배정하고 배정할 수 없으면 새 미팅룸에 배정한다.

```python
a = [['문학회', 9.0, 11.0], ['지역봉사회', 9.0, 12.5], ['서예회', 13.0, 14.5],
     ['바둑회', 14.0, 17.0], ['미술회', 11.0, 14.0], ['사진회', 9.0, 11.0],
     ['음악회', 15.0, 16.5], ['창조회', 15.0, 16.5], ['독서회', 11.0, 12.5],
     ['토론회', 13.0, 14.5]]

n = len(a)
a.sort(key=lambda key : key [1])

solution = [[a[0]]]
finish_time = [a[0][2]]

k = 0

for i in range(1, n):
  flag = False
  for j in range(k + 1):
    if a [i][1] >= finish_time[j]:
      solution[j].append(a[i])
      finish_time[j] = a[i][2]
      flag = True
      break
  
  if not flag:
    k += 1
    solution.append(a[i])
    finish_time.append(a[i][2])

for i in range(k + 1):
  print("미팅룸", i + 1, " : ", solution[i])
```

수행시간 O(nLog) + O(dn)