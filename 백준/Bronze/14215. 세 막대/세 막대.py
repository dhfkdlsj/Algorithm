S = list(map(int,input().split()))

S.sort()

if S[0]+S[1]<=S[2]:
  S[2] = S[0]+S[1]-1

print(sum(S))