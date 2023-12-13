
a = [['문학회', 9.0, 11.0], ['지역봉사회', 9.0, 12.5], ['서예회', 13.0, 14.5],
     ['바둑회', 14.0, 17.0], ['미술회', 11.0, 14.0], ['사진회', 9.0, 11.0],
     ['음악회', 15.0, 16.5], ['창조회', 15.0, 16.5], ['독서회', 11.0, 12.5],
     ['토론회', 13.0, 14.5]]

# 학회 수
n = len(a)

# 그래프 초기화
g = [[0] * n for _ in range(n)]

# 그래프 만들기
for i in range(n):
    for j in range(i + 1, n):
        if (a[i][1] <= a[j][1] < a[i][2]) or (a[j][1] <= a[i][1] < a[j][2]):
            # i번 학회와 j번 학회의 시간이 중첩되면 간선을 연결
            g[i][j] = g[j][i] = 1

# 색깔 초기화
color = [-1] * n

# 최소 사용하는 미팅룸 수를 저장할 변수
min_meeting_rooms = float('inf')

def valid(i):
    for j in range(n):
        if g[i][j] and color[i] == color[j] and (color[i] != -1):
            return False
    return True

def coloring(i, used_meeting_rooms):
    global min_meeting_rooms
    
    if i == n:
        # 모든 학회에 대해 색칠이 완료된 경우
        print('색칠 결과:', color)
        # 사용된 미팅룸 수 업데이트
        min_meeting_rooms = min(min_meeting_rooms, used_meeting_rooms)
        return True

    for c in range(used_meeting_rooms + 1):
        color[i] = c
        if valid(i):  
            next_meeting_rooms = used_meeting_rooms + (c == used_meeting_rooms)
            if coloring(i + 1, next_meeting_rooms): 
                return True
    return False

# 초기에 사용된 미팅룸 수는 0
coloring(0, 0)

# 최소 사용하는 미팅룸 수 출력
print('최소 사용하는 미팅룸 수:', min_meeting_rooms)
