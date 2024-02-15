<aside>
💡 허프만 코딩

</aside>

허프만 코딩

- 파일 압축 - 파일의 크기를 줄이는 방법
- 파일의 크기를 줄이고, 필요시 원래의 파일로 변환할 수 있다.
    - 메모리 공간을 적게 사용
    - 파일 전송 시간 단축

빈도수에 따라 코드 길이를 정한다.

Prefix - free 속성

- 어떤 코드도 다른 코드의 앞부분과 같으면 안된다.
- 코드가 Prefix - free  속석을 가지러면 이진트리의 내부노드에 문자가 있으면 안된다.
- 즉 문자(복호화 할 것)는 이파리에만 있어야한다.

허프만 트리 알고리즘

- 압축할 파일을 스캔하여 각 문자의 빈도수를 계산한다.
- 문자마다 문자와 비도수를 가진 이파리 노드를 만든다.
- 빈도수가 ㄱ가장 적은 두 노드의 부모를 만들어 빈도수의 합을 저장한다.
- 노드가 하나만 남으면 남은 두 노드를 허프만 트리의 루트로 변환
- 아니면 자식이 된 노드들을 제외하고 3번으로 간다

![스크린샷 2023-11-14 09.27.22.png](https://prod-files-secure.s3.us-west-2.amazonaws.com/4e6fe536-1497-4feb-83c3-30b51c65762e/521af943-0d15-4f33-bf92-66e03010321a/%E1%84%89%E1%85%B3%E1%84%8F%E1%85%B3%E1%84%85%E1%85%B5%E1%86%AB%E1%84%89%E1%85%A3%E1%86%BA_2023-11-14_09.27.22.png)

책 참고

O(nLogN)

<aside>
💡 작은 것부터 풀어보기

</aside>

작은 문제란 원래 주어진 문제와 가은 문제이며, 작은 문제를 부분 문제라고 한다. 작은 문제의 입력은 원래 문제의 일부분이다.

<aside>
💡 가장 긴 증가 순서

</aside>

숫자가 일 열로 나열되었을 때 가장 긴 증가순서를 찾기

- 증가 순서는 숫자들이 반드시 이웃 해야만 하는 것은 아님
- 나열된 숫자 중 증가순서를 이루지 않은 숫자를 지우면 된다.
- [5,2,8,6,4,6,1,9,3] 에서 증가순서를 만들어 보면
- [5,8,9], [5,6,9], [2,8,9], [2,6,9], [2,4,6,9] 등이 된다.

나누어서 해결하기 

- 책 p.191

욕심내어 풀어보기

- 책 p.191 ~ 192

![스크린샷 2023-11-14 10.13.54.png](https://prod-files-secure.s3.us-west-2.amazonaws.com/4e6fe536-1497-4feb-83c3-30b51c65762e/4a11036d-e0ab-4ae1-8772-a1386fb0cc61/%E1%84%89%E1%85%B3%E1%84%8F%E1%85%B3%E1%84%85%E1%85%B5%E1%86%AB%E1%84%89%E1%85%A3%E1%86%BA_2023-11-14_10.13.54.png)

```python
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

getLongestIncreasingSeq([5,2,8,6,4,6,1,9,3])
```

알고리즘의 첫 단계에서는 그래프를 만드는데 이때 간선의 수는 최대 n(n-1/)2

시간 복잡도는 O(n^2)

<aside>
💡 벨먼 포드 알고리즘

</aside>

- 책 P.198

1. D를 무한대로 초기화한다. 단 D[s] = 0  s는 출발점
2. 다음을 n - 1회 수행한다.
    1. 각 간선 <i, j> 에 대해서
    2. if D[j] > (D[i] + 간선  <i ,j> 에 대해서 간선 완화를한다.
    3. 간선 <i ,j> 에 대해 간선 환화는 다음과 같이 수행함