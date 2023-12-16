def partition(v, low, high):
    i, pivot = low -1, v[high]
    for j in range(low, high)
        if v[j] > pivot :
            continue
        i +=1
        t = v[i]; v[i] = v[j]; v[j] = t
    t = v[i+1],v[i+1] = v[high]; v[high] = t;
    return i + 1;