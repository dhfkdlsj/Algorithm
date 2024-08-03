import sys
input = sys.stdin.readline

def fac(K):
  result = 1
  for i in range(2, K + 1):
    result *= i
  return result


N,K = map(int,input().split())

print(fac(N)//(fac(K) * fac(N-K)))