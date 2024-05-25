while True:
  n = int(input())
  S = []
  answer = ''
  if n == -1:
    break
  for i in range(1, int(n / 2) + 1):
    if n % i == 0:
      S.append(i)
      if answer == '':
        answer += str(i)
      else:
        answer += ' + '+str(i)
  if sum(S) == n:
    print("{} = {}".format(n,answer))
  else:
    print("{} is NOT perfect.".format(n))