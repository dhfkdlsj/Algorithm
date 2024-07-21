import sys
input = sys.stdin.readline

answer = ''

while(True):
  n,m = map(int,input().split())
  if(n==0 and m == 0):
    print(answer)
    break;
  if(n>m):
    answer += 'Yes' + '\n'
  else:
    answer += 'No' + '\n'
