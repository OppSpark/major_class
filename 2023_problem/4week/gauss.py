

#연습용 동작 X
a = int(input(), 2)
b = int(input(), 2)

n = 8


def product(a, b, n):
    if n == 1 :
        return a*b
    ah = a >> n/2
    al = a << n/2
    bh = b >> n/2
    bl = b << n/2

    m1 = product(ah, bh, n / 2)
    m2 = product(ah + al, bh + bl, n / 2)
    m3 = product(al, bl, n / 2)
    n = n/2

    return (2 ** n) + (2 ** n / 2) * (m2 - m1 - m3) + m3




print(bin(product(a,b,n)))