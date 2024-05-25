p, q = map(int,input().split())
S = []

for i in range(1,int(p/2)+1):
  if p%i == 0:
    S.append(i)
S.append(p)

if len(S) < q:
  print(0)
else:
  print(S[q-1])