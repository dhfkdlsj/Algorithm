a, b, c, d, e, f = map(int,input().split())

x = ((e * c) - (b * f)) / ((a * e) - (b * d))
y = ((a * f) - (d * c)) / ((a * e) - (b * d))

print(int(x), int(y), end='')