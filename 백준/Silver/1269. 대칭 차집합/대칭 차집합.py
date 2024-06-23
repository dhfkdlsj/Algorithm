import sys
input = sys.stdin.readline

N,M = map(int,input().split())
S = set(map(int,input().split()))
A = set(map(int,input().split()))

print(len(S-A)+len(A-S))