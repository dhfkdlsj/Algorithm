N = int(input())
S = list(map(int,input().split()))
T,P = map(int,input().split())
count = 0

for i in S:
  if i == 0:
    continue
  elif i > T:
    if i / T == int(i/T):
      count += int(i/T)
    else:
      count += int(i/T)+1
  else:
    count += 1

print(count)
print('{} {}'.format(int(N/P),N%P))