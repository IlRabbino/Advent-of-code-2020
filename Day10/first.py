input = open("input.txt", "r").read().split('\n')
adapter = []
i=0
j3 = 0
j1 = 0

for item in input:
    adapter.append(int(item))
adapter.sort()

if adapter[i] == 1:
    j1 += 1
else:
    j3 += 1

while i<len(adapter)-1:
    if adapter[i+1]-adapter[i] == 1:
        j1 += 1
    else:
        j3 += 1
    i += 1

j3 += 1

print(j1*j3)