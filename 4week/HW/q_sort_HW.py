def qsort(a, low, high):
    if low < high :
        pivot = partion(a, low ,high)
        qsort(a, low, pivot - 1) #왼쪽 재귀호출
        qsort(a, pivot + 1, high) #오른쪽 재귀호출
    return a
def partion(a, low, high):
    pivot = a[low]    #배열의 Low 를 기전점으로 설정함
    l = low + 1
    r = high

    while True :
        while l <= r and a[l] <= pivot :
            l += 1
        while l <= r and pivot <= a[r]:
            r -= 1
        if r < l :
            break
        else :
            a[l], a[r] = a[r], a[l]
    a[low], a[r] = a[r], a[low]   #기준점과 교차하면 교환함
    return r

input_list =[50, 80, 75, 30, 95, 45, 10, 15, 70, 85, 30, 20, 50, 60, 20]
print("정렬 전 :\t",input_list)
qsort(input_list,0,len(input_list) - 1)
print("정렬 후 :\t",input_list)


