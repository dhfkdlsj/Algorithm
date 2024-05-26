a,b = map(int,input().split())
c,d = map(int,input().split())
e,f = map(int,input().split())

if a == c:
  print(e,end=' ')
elif a == e:
  print(c,end=' ')
else:
  print(a,end=' ')

if b == d:
  print(f,end=' ')
elif b == f:
  print(d,end=' ')
else:
  print(b,end=' ')