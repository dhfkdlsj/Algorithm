a = int(input())
b = int(input())
c = int(input())
S =[0]*10

x = str(a*b*c)

for i in x:
  S[int(i)] += 1

print(*S,sep='\n')