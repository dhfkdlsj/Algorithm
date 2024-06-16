import sys
input = sys.stdin.readline

N = int(input())
S = [list(map(int,input().split())) for _ in range(N)]

for i in S:
  count = 1
  for j in S:
    if i[0] < j[0] and i[1] < j[1]:
      count += 1
  print(count, end= " ")