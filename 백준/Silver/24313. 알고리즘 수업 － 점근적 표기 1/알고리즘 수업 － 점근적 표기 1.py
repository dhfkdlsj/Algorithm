n,m = map(int,input().split())
c = int(input())
n0 = int(input())

if (n * n0) + m <= c * n0:
  if (n*100)+m <= c*100:
    print(1)
  else:
    print(0)
else:
  print(0)
