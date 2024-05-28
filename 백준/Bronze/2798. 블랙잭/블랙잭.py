N, M = map(int,input().split())
S = list(map(int,input().split()))
sum = 0

for i in range(len(S)):
  for j in range(i+1,len(S)):
    for k in range(j+1,len(S)):
      if (S[i]+S[j]+S[k]) > sum and (S[i]+S[j]+S[k]) <= M:
        sum = (S[i]+S[j]+S[k])

print(sum)