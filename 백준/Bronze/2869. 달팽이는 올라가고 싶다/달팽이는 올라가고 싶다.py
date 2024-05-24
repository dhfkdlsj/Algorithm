A, B, V = map(int,input().split())
a = A-B
b = V-B

if b/a > b//a:
  print(int((b//a)+1))
else:
  print(int(b/a))