N = int(input())
x = 1
count = 1

while True:
  if N <= x:
    break
  else:
    N -= x
    x += 1
    count += 1

if count % 2 == 0:
  a, b = 1, count
  if N == 1:
    print("{}/{}".format(a,b))
  else:
    for i in range(N-1):
      a += 1
      b -= 1
    print("{}/{}".format(a,b))
else:
  a, b = count, 1
  if N == 1:
    print("{}/{}".format(a,b))
  else:
    for i in range(N-1):
      a -= 1
      b += 1
    print("{}/{}".format(a, b))