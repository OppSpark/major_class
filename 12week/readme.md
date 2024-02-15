https://www.notion.so/11-21-12week-27060347cb144a73bc4bff70fd96ee2f?pvs=4



<aside>
💡 서열 정렬

</aside>

서열 정렬

- 어느 DNA가 다른 DNA로 변형되는데 얼마나 많은 변이가 필요한가를 계산하는 문제
- 변이는 삽입, 삭제, 데체의 연산으로
- TTCAACA  →  ATTGCGC로 만드는데 필요한 최소 연산 횟수

문서 편집기를 사용하는 중 스트링 S를 수정하여 스트링 T로 변환 시킬 때도 삽입, 삭제, 대체 연산을 사용함

<aside>
💡 나누어 해결하기를 이용해서 풀이

</aside>

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/4e6fe536-1497-4feb-83c3-30b51c65762e/1527d274-dfb6-4b0b-947a-1482a8f2399f/Untitled.jpeg)

해결 방법이 아니다.

<aside>
💡 욕심 내어 해결하기(그리디)

</aside>

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/4e6fe536-1497-4feb-83c3-30b51c65762e/154c1265-7869-482c-9ddc-7703f4f67677/Untitled.jpeg)

7번의 연산을 진행함

<aside>
💡 작은 것부터 해결하기

</aside>

- 작은 문제(부분 문제) 들이 무엇인가?
- S와 T 스트링 각각에 대해 앞 부분 스트링을 고려한다.

![스크린샷 2023-11-21 09.31.17.png](https://prod-files-secure.s3.us-west-2.amazonaws.com/4e6fe536-1497-4feb-83c3-30b51c65762e/79fa69e3-1350-4f60-8aef-95649990799e/%E1%84%89%E1%85%B3%E1%84%8F%E1%85%B3%E1%84%85%E1%85%B5%E1%86%AB%E1%84%89%E1%85%A3%E1%86%BA_2023-11-21_09.31.17.png)

![스크린샷 2023-11-21 09.36.39.png](https://prod-files-secure.s3.us-west-2.amazonaws.com/4e6fe536-1497-4feb-83c3-30b51c65762e/d1628a50-65a2-4644-876c-fe734016f945/%E1%84%89%E1%85%B3%E1%84%8F%E1%85%B3%E1%84%85%E1%85%B5%E1%86%AB%E1%84%89%E1%85%A3%E1%86%BA_2023-11-21_09.36.39.png)

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/4e6fe536-1497-4feb-83c3-30b51c65762e/310614fb-bc6f-4dde-8edb-c737e7b3c530/Untitled.jpeg)

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/4e6fe536-1497-4feb-83c3-30b51c65762e/6cd6d89b-c83b-4824-bc3b-58942622706c/Untitled.jpeg)

```markdown
* 서열 정렬을 위한 알고리즘의 수행 시간은 O(mn)이다.
* m = S의 문자 수, n = T의 문자 수
* 각 부분 문제 E[i, j]의 해는 주변 3개의 해를 이용하여 계산하므로 O(1) 시간 소요
* 총 부분 문제 수: mn
```

<aside>
💡 합이 최대 K 되는 숫자

</aside>

<aside>
💡 세 스케줄링 문제

</aside>

각 동아리가 미팅에 필요한 시간만을 제시

- ex) 6개의 동아리에서 각각 30분, 40분, 50분, 60분, 95분, 100분 동안 미팅룸을 사용하기 원한다.

이때 1개의 미팅룸에 특정 시간동안 ㄱ능한 미팅룸이 비어있지 않도록 동아리 시간을 배정해얗마

<aside>
💡 욕심 내어 작은 것 부터 선택하기

</aside>

책 p.216

<aside>
💡 욕심내어 큰 것부터 선택하기

</aside>

책 p.217

<aside>
💡 나누어 해결하기

</aside>

책 p.217

<aside>
💡 작은 것부터 해결해서 그 결과를 이용해 점차 큰 부분 문제를 해결하기

</aside>

1. 물건을 1개 씩 늘려가며 부분 문제의 크기를 증가시킨다.
2. 트럭이 용량을 1부터 K까지 1씩 증가시켜 부분 문제의 크기를 증가시킨다.

알고리즘

- 물건을 차례로 하나씩 다음과같이 결정을 내린다.
    - 트럭 용량을 1씩 증가시키며 물건을 트럭에 싣는 것이 유리한지, 싣지 않는 것이 나은지 결정한다.
- return 마지막 물건에 대해 K일 때의 트럭이 실은 물건의 총량

<aside>
💡 배낭 문제

</aside>

배낭 무제

- n 개의 물건이 각각 무게와 가치를가지고 배낭의 용량 K가 주어질 때 어떤 물건을 배낭에 담아야 최대 가치를 얻을 까?

![스크린샷 2023-11-21 10.43.48.png](https://prod-files-secure.s3.us-west-2.amazonaws.com/4e6fe536-1497-4feb-83c3-30b51c65762e/9a2f511d-bc06-45d1-8b8b-a97cad3ec9ad/%E1%84%89%E1%85%B3%E1%84%8F%E1%85%B3%E1%84%85%E1%85%B5%E1%86%AB%E1%84%89%E1%85%A3%E1%86%BA_2023-11-21_10.43.48.png)

![스크린샷 2023-11-21 11.08.31.png](https://prod-files-secure.s3.us-west-2.amazonaws.com/4e6fe536-1497-4feb-83c3-30b51c65762e/a49f18f4-b255-47c4-b808-46ff14e2e4bb/%E1%84%89%E1%85%B3%E1%84%8F%E1%85%B3%E1%84%85%E1%85%B5%E1%86%AB%E1%84%89%E1%85%A3%E1%86%BA_2023-11-21_11.08.31.png)