import sys
input = sys.stdin.readline

N,M = map(int,input().split())
poket = dict()
answer = ''

for i in range(1,N+1):
  poket[input()] = i
poket1 = {v:k for k,v in poket.items()}

for i in range(M):
  problem = input()
  if ord(problem[0]) < 65:
    problem = int(problem)
    answer += poket1[problem]
  else:
    answer += str(poket[problem])+'\n'

print(answer)