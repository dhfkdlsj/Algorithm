T = int(input())

for test_case in range(T):
  count = 0
  summ = 0
  S = list(map(str,input()))
  for i in S:
    if i == 'O':
      count += 1
      summ += count
    elif i == 'X':
      count = 0
  print(summ)