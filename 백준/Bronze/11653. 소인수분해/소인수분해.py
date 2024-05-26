N = int(input())
x = 2

while N != 1:
  if N % x == 0:
    N /= x
    print(x)
  else:
    x += 1