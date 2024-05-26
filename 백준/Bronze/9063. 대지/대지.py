N = int(input())
x,y = 10000,10000
w,z = -10000,-10000

for i in range(N):
  a,b = map(int,input().split())
  if x > a:
    x = a
  if y > b:
    y = b
  if a > w:
    w = a
  if b > z:
    z = b

print((w-x)*(z-y))