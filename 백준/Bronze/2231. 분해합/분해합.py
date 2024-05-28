N = input()
count = 0

for i in range(1,int(N)+1):
  sum = 0
  for j in range(len(str(i))):
    sum += int(str(i)[j])
  sum += i
  if sum == int(N):
    count = 1
    print(i)
    break
if count == 0:
  print(0)