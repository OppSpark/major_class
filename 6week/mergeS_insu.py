def merge(v, s1, e1, s2, e2):
    i = s1
    j = s2
    k = 0
    x = [0] * (e2 - s1 + 1)

    while i <= e1 and j <= e2:
        if v[i] <v[j] :
            x[k] = v[i]
            i += 1
            k += 1
        else :
            x[k] = v[j]
            j += 1
            k += 1
    while i <= e1 :
        x[k] = v[i]
        i += 1
        k += 1
    while j <= e2:
        x[k] = v[j]
        j += 1
        k += 1

    v[s1:e2 + 1] = x

def mergeSort(v, s, e):
    if s >= e: return
    m = s + (e - s) // 2
    mergeSort(v, s, m)
    mergeSort(v, m + 1, e)
    merge(v, s, m, m + 1, e)

v=[31,8,24,3,45,7,23,11]
mergeSort(v, 0, len(v)-1)
print(v)



