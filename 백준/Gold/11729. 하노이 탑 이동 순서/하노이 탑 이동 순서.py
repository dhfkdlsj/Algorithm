import sys
input = sys.stdin.readline
output = sys.stdout.write

def hanoi(n,fromm,to,mid):
    global answer, count
    count+= 1
    if(n == 1):
        answer.append(f"{fromm} {to}\n")
        return
    hanoi(n-1, fromm, mid, to)
    answer.append(f"{fromm} {to}\n")
    hanoi(n - 1, mid, to, fromm)

n = int(input())
answer =[]
count = 0
hanoi(n,1,3,2)
output(f"{count}\n")
output(''.join(answer))