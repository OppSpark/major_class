def binary (a , left, right, k) :
    if right >= left :
        mid = (left + right) // 2
        if a[mid] == k :
            return True
        elif a[mid] > k :
            return binary(a, left, mid- 1, k)
        else:
            return binary(a, mid + 1, right , k)
    else :
        return False



list = [10, 17 ,28, 40, 51, 62, 77, 92, 149, 221, 441, 405, 657 , 1111]
list.sort()

n = len(list)

print(binary(list, 0, n -1, int(input("탐색할 값을 입력하세요 : " ))))

