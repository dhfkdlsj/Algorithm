import sys
input = sys.stdin.readline

answer = ''

for _ in range(3):
  n = int(input())
  sum = 0
  for _ in  range(n):
    x = int(input())
    sum += x
  if(sum>0):
    answer += '+' + '\n'
  elif(sum<0):
    answer += '-' + '\n'
  else:
    answer += '0' + '\n'

print(answer)