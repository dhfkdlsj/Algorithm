T = int(input())

for test_case in range(T):
  H, W, N = map(int, input().split())

  if N % H == 0:
    YY = H
    XX = int(N / H)
  else:
    YY = N % H
    XX = int(N / H) + 1

  if XX < 10:
    print("{}{}{}".format(YY, 0, XX))
  else:
    print("{}{}".format(YY, XX))