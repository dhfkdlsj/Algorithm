import sys
input = sys.stdin.readline

N = int(input())
S = [int(input()) for _ in range(N)]

S.sort()

if N == 0:
  print(0)
else:
  if N * 0.15 >= int(N * 0.15) + 0.5:
    x = int(N * 0.15) + 1
  else:
    x = int(N * 0.15)

  S = S[x:len(S) - x]
  y = sum(S) / (N - x - x)

  if y >= int(y) + 0.5:
    print(int(y) + 1)
  else:
    print(int(y))
