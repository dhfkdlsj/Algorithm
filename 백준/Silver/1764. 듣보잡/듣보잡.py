import sys
input = sys.stdin.readline

N,M = map(int,input().split())
temp = dict()
count = 0
answer =[]

for i in range(1,N+1):
  temp[input()] = 1
for i in range(M):
  s = input()
  if temp.get(s) == 1:
    count += 1
    answer.append(s)
answer.sort()

print(count)
for i in answer:
  print(i,end='')