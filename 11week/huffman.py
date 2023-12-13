# 허프만 코딩을 만드는 코드
from heapq import heappush, heappop, heapify


def huffman_tree(a):
    h = [[freq, [char, '']] for char, freq in a]  # 허프만 트리 초기화
    # print(h)
    heapify(h)

    while len(h) > 1:
        # 최소 빈도수를 가진 노드 두 개를 pop
        left = heappop(h)
        right = heappop(h)
    #    print(f'left:{left}, right:{right}')
        for code in left[1:]:
            code[1] = '0' + code[1]  # 왼쪽 자식은 0을 맨 앞에 추가
        for code in right[1:]:
            code[1] = '1' + code[1]  # 오른쪽 자식은 1을 맨 앞에 추가
        t = [left[0]+right[0]] + left[1:] + right[1:]
    #    print(t)
        heappush(h, t)
    # print(h[0])
    # print(t)
    return h


input_freq = [['b', 20], ['c', 30], ['d', 35], ['e', 40], ['a', 60], ['f', 90]]
h_code = huffman_tree(input_freq)
print(h_code)
result = sorted(heappop(h_code)[1:])
for ch, code in result:
    print(ch, ':', code)
# print(h_code)
