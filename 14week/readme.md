<aside>
💡 되돌아가며 풀어보기

</aside>

### 배낭 문제

- DP를 이용한 배낭문제 O(nK)시간
- K = 2^n 이라면 DP 알고리즘은 모든 조합을 하나 씩 차례로 검사하는 방법보다 성능이 떨어짐

분기 한정 알고리즘으로 해를 찾으려면 새 노드를 만들 때 노드의 한정 값을 계산해야한다.

최대 가치를 찾는 문제므로 높은 한정 값을 가진 노드들을 우선하여 탐색한다.

즉, BF(Best - First) 탐색을 먼저 한다.

배낭 문제를 푸는 알고리즘

- 단위 무게당 가치 기준으로 물건을 감소 순으로 정렬한다.
- 상태 공간 트리의 루트 bound를 계산한다.
- 물건을 포함하는 자식 노드와 포기한 자식 노드를 만들고 각각 bound를 계산한다.
- 상태 공간 트리의 이파리 중 가장 작은은 bound가 큰 노드를 선택한다. 마일 남은 이파리들이 현재 까지 찾은 가장 큰 가치보다 작은 bound 알고리즘을 종료한다
- 3번으로 가서 반복한다.

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/4e6fe536-1497-4feb-83c3-30b51c65762e/64a9c81e-d818-4676-9969-3769840593c4/Untitled.png)

<aside>
💡 근사하게 해결하기

</aside>

NP -  완전 문제

- 다항식 시간에 해결할 수 있는 알고리즘이 아직 발견 안된 문데들
- 

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/4e6fe536-1497-4feb-83c3-30b51c65762e/569c822f-c35b-42f3-8beb-4a46eebd1cb4/Untitled.png)

MST 예제를 이용해서 TSP 근사 해 찾기

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/4e6fe536-1497-4feb-83c3-30b51c65762e/5e673d67-9d0f-420e-bb36-1e6edd5d5113/Untitled.png)

- 0 1 3 2 3 4 3  6 5 3 1 0
    - 이동경로에서 중복 방문한 경로를 지운다.
    - 그러면
- 0 1 3 2 4 5 6 0
    - 로 바뀐다. (TSP) 경로

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/4e6fe536-1497-4feb-83c3-30b51c65762e/4eac327a-0232-401a-b8ec-29b37d0ae588/Untitled.png)

트리 간선을 다라 점의 방문 순서를 얻는 시간 O( N)

반복되는 점 제거 시간  O(n)

<aside>
💡 집합 커버

</aside>

학교 건설

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/4e6fe536-1497-4feb-83c3-30b51c65762e/5ec7d734-25ff-4b11-beb9-bd7a3208421c/Untitled.png)

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/4e6fe536-1497-4feb-83c3-30b51c65762e/8ed8b331-ccd3-4f59-a3d8-ecf0062232be/Untitled.png)

### 그리디 커버 알고리즘

1. C =[] 배열 생성
2. while 의 U 가 empty가 아니면
3. U의 원소들을 가장 많이 포함하는 집합 si를 F에서 선택
4. U = U - Si
5. Si 의 원소를 다른 집합에서 제거
6. Si를 F에서 제거하고 Si를 C에 추가

수행 시간

while 루프가 최대 수행되는 수는 n번

O(n^2) 이 걸린다.

응용

도시 계획

경비시스템

CCTV 카메라 베치

컴퓨터 바이러스 찾기

대기업 구매 업체 선정