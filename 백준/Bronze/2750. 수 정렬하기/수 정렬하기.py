t = int(input())
S = []
for i in range(t):
  S.append(int(input()))

S.sort()

for i in range(t):
  print(S[i])