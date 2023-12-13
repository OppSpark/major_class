U = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9}
S = [{0, 1, 2, 7},        # s0
     {0, 1, 2, 3, 7},     # s1
     {0, 1, 2, 3},        # s2
     {1, 2, 3, 4, 6, 7},  # s3
     {3, 4, 5, 6},        # s4
     {4, 5, 6, 8, 9},     # s5
     {3, 4, 5, 6},        # s6
     {0, 1, 3, 7},        # s7
     {5, 8},              # s8
     {5, 9}]              # s9
set_cover = []            #[1] C = []  

while len(U) > 0:
    max_cover_set = S.index(max(S, key=lambda x: len(U & x)))
    U = U - S[max_cover_set]
    for i in range(len(S)):
        if i != max_cover_set:
            S[i] = S[i] - S[max_cover_set]
    set_cover.append(max_cover_set)
    S[max_cover_set] = set()

print("집합 커버를 위한 부분 집합 리스트 : ",set_cover)