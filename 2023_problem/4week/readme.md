# 4주차


<aside>
💡 위상 정렬

</aside>

위상 정렬

- 사이클이 없는 방향 그래프에서 정점들이 선형 순서로 나열하는 것이다.

위상 정렬은 순방향 정렬, 역방향 정렬 2가지 가 있음

- 순방향 정렬
    - 진입 차수가 0 인 정점 v에서 시작해 v를 출력하고 그래프에서 제거 과정을 반복
- 역방향 정렬
    - 진출 차수가 0인 정점 v를 출력하고 c를 그래프에서 제거하는 과정을 반복

순방향 위상 정렬

`topological_sort.py`

역방향 위상 정렬

`topological_sort_reverse.py`

<aside>
💡 정렬하기

</aside>

나누어 풀어보기

n - 비트 이진수 곱하기

가우스의 아이디어

- 복소수를 곱셈할 때 곱 횟수를 줄이는 방법
- 책 참고 p.93

가우스 아이디어 기반 곱셈

- 책 참고 p.95

```python
a = int(input(), 2) # a 2진수를 입력 받음
b = int(input(), 2) # b 2진수를 입력 받음
n = 8 #비트 수 

def product(a,b ,n) :
    if n == 1 :
        return a*b

    k = n //2
    ah = a >> k
    al = a - (ah << k)
    bh = b >> k
    bl = b - (bh << k)

    m1 = product(ah, bh, k)
    m2 = product(ah + al, bh + bl, k)
    m3 = product(al, bl, k)

    return (m1 << n) + ((m2 - m1 - m3) << k) + m3

print(bin((product(a,b,n))))
```

gauss_class.py

