l, a, b, c, d = (int(input()) for _ in range(5))
print(l - max((a + c - 1) // c, (b + d - 1) // d))
