import sys
input = sys.stdin.readline

N, K = map(int,input().split())
S = [int(input()) for _ in range(N)]

x = sum(S)//K
y = 1

while(y<=x):
  half = (x+y)//2
  count = 0
  for i in S:
    count += i // half
  if count >= K:
    y = half+1
  else:
    x = half-1

print(x)