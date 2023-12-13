def get_input():
    while True:
        try:
            N = int(input())
            yield N
        except :
            return
def solve(n):
    if n == 1:
        return "-"
    else:
        left = solve(n // 3)
        center = " " * (n // 3)
        return left + center + left

for N in get_input():
    rst = solve(3 ** N)
    print(rst)

