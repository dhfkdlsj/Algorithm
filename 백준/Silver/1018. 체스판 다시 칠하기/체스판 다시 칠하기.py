N,M = map(int,input().split())
S = [list(map(str,input())) for _ in range(N)]
minCount = 64
A = 'WBWBWBWB'
B = 'BWBWBWBW'

for i in range(N-7):
  for j in range(M-7):
    Z = []
    for x in range(0,8):
      Z.append(S[i:i+8][x][j:j+8])
    count = 0
    for x in range(len(Z)):
      if x % 2 == 0:
        for y in range(len(Z[x])):
          if Z[x][y] != A[y]:
            count += 1
      else:
        for y in range(len(Z[x])):
          if Z[x][y] != B[y]:
            count += 1
    if count < minCount:
      minCount = count

    count = 0
    for x in range(len(Z)):
      if x % 2 == 0:
        for y in range(len(Z[x])):
          if Z[x][y] != B[y]:
            count += 1
      else:
        for y in range(len(Z[x])):
          if Z[x][y] != A[y]:
            count += 1
    if count < minCount:
      minCount = count

print(minCount)