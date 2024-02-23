BIN_SIZE = 10
item = [7, 5, 6, 4, 2, 3, 7, 5]
n = len(item)
bins = [[] for i in range(n)]  # n개의 통
remnant = [BIN_SIZE for _ in range(n)]  # 각 통의 남는 부분
bin_count = 1  # 통의 수

for i in range(n): # 물건 i를 통에 담기
    j = 0
    packed = False
    while j < bin_count:
        if item[i] <= remnant[j]:
            bins[j].append([i, item[i]]) # 통에 넣고
            remnant[j] -= item[i]        # 통에 남은 공간 업데이트
            packed = True
            break
        j += 1                           
    if not packed:                         # 기존 통에 넣지 못한경우
        bins[j].append([i, item[i]])       # 새 통에 넣곡
        remnant[j] -= item[i]              # 새 통 남은 공간 업데이트
        bin_count += 1                     # 통 수 증가

print("최초 적합 : 총 사용된 통의 수 = ", bin_count)
print()
for i in range(bin_count):
    print("통 : %d " % i)

    for j in range(len(bins[i])):
        print("  물건 = %d, size = %d " % (bins[i][j][0], bins[i][j][1]))
    print()
