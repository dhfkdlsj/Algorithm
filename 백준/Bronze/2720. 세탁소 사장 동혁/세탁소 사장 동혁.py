T = int(input())
A = [25,10,5,1]

for i in range(T):
    S = [0] * 4
    N = int(input())
    for j in range(4):
        S[j],N = divmod(N,A[j])
    for j in S:
        print(j,end=' ')
    print()