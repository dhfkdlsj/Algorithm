T = int(input())
S = list(map(int,input().split()))
count = 0
decimal = 0

for i in S:
  decimal = 0
  if i == 1:
    continue
  for j in range(2,i//2+1):
    if i%j == 0:
      decimal = 1
  if decimal == 0:
    count += 1

print(count)