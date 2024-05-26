M = int(input())
N = int(input())
S = []

for i in range(M,N+1):
  decimal = 0
  if i == 1:
    continue
  for j in range(2,i//2+1):
    if i%j == 0:
      decimal = 1
  if decimal == 0:
    S.append(i)

if not S:
  print(-1)
else:
  print(sum(S))
  print(min(S))