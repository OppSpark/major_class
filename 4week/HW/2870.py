n = int(input()) #줄 수를 입력 받는다.
arr = []

for _ in range(n): #N만큼 반복
    is_number = ''  #초기화
    in_result = input()  #값을 입력 받음 N번만큼 반복함

    for i in in_result :
        if i.isdigit(): # 입력 받은 문자열을 하나씩 비교 후 숫자일 경우 True
            # isdigit() 는 i의 값이 string 인지 int 인지 비교후 int면 True
            is_number += i #is_number 추출한 값에 추가
        else :  #문자인 경우
            if is_number != '' :  #in_result 값이 비었는지 검사
                arr.append(int(is_number))  #추출한 값은 배열에 입력
                is_number = '' #초기화
    if is_number != '':  #마지막 값 까지 비교
        arr.append(int(is_number))

#퀵소트
def qsort(arr, low, high):
    if low < high :
        pivot = partion(arr, low ,high)
        qsort(arr, low, pivot - 1)
        qsort(arr, pivot + 1, high)
    return arr
def partion(arr, low, high):
    pivot = arr[low]
    l = low + 1
    r = high
    while True :
        while l <= r and arr[l] <= pivot :
            l += 1
        while l <= r and pivot <= arr[r]:
            r -= 1
        if r < l :
            break
        else :
            arr[l], arr[r] = arr[r], arr[l]
    arr[low], arr[r] = arr[r], arr[low]
    return r


qsort(arr,0,len(arr) - 1)   #퀵소트 실행

for i in arr:
    print(i) #값 출력