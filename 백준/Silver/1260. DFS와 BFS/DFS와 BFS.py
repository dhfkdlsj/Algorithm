from collections import deque

N,M,V = map(int,input().split())
S= [[]for _ in range(N+1)]
b = [False]*(N+1)
q = deque()

def dfs(v):
    b[v] = True
    print(v,end=" ")
    for i in S[v]:
        if(not b[i]):
            dfs(i)

def bfs(v):
    b[v] = True
    q.append(v)
    while(q):
        x = q.popleft()
        print(x,end=" ")
        for i in S[x]:
            if(not b[i]):
                b[i] = True
                q.append(i)      


for i in range(M):
    x,y = map(int,input().split())
    S[x].append(y)
    S[y].append(x)
    
for i in range(N+1):
    S[i].sort()

dfs(V)
print()
b = [False]*(N+1)
bfs(V)