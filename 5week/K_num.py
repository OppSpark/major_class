import random
def selection(a, low, high, k) :
    pivot = partition(a, low, high)
    if k < pivot :
        return selection(a, low, pivot - 1, k)
    elif pivot == k :
        return a[k]
    else :
        return selection(a, low + 1, high , k)

def partition(a, low, high):
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



# 수정 필요함



input_list =[50, 80, 75, 30, 95, 45, 10, 15, 70, 85, 30, 20, 50, 60, 20]

print(selection(input_list, 0, len(input_list) - 1, 8))




