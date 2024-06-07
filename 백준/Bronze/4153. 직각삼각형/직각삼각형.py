while True:
  S = []
  a, b, c = map(int,input().split())
  if a == 0 and b == 0 and c == 0:
    break
  else:
    S.append(a)
    S.append(b)
    S.append(c)
    S.sort()

    if S[0]**2 + S[1]**2 == S[2]**2:
      print('right')
    else:
      print('wrong')