def ft1(v ,s, e, key):
    if s > e : return -1
    m = s +(e - s) // 2
    if key < v[m] :
        return ft1(v,s, m - 1,key)
    elif key > v[m] :
        return ft1(v, m+1, e,key)
    else:
        return m

def ft2(v, key):
    s,e = 0, len(v) -1
    while s <= e:
        m = s + (e - 1) // 2
        if v[m] <key :
            s = m + 1
        elif v[m] > key:
            e = m -1
        else :
            return m
    return -1


v = [3,7,8,11,23,24,31,45,9,14,78,3111]
v.sort()

print(ft1(v,0,len(v) -1 ,31))
print(ft2(v, 9))

