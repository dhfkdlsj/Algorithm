def rec(x):
    return recursion(x, 0, len(x) - 1, 1)

def recursion(x, y, z, count):
    if y >= z:
        return 1, count
    elif x[y] != x[z]:
        return 0, count
    else:
        count += 1
        return recursion(x, y + 1, z - 1, count)

n = int(input())
answer = ''
for i in range(n):
    x = list(input().strip())
    result, count = rec(x)
    answer += str(result) + ' ' + str(count) + '\n'

print(answer)
