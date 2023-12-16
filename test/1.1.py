#시간 복잡도는 N
#인덱스 s ~ e 범위 내 배열 합산
def sum(v,s,e):
    if s == e:
        return v[s]
    m = s + (e - s) // 2
    sumL = sum(v, s, m)
    sumR = sum(v, m+1, e)
    return sumL + sumR
v = [3,5,6,9,2,4,1,8]
print(sum(v,0,len(v)-1))