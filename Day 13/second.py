#THIS SOLUTION DOESN'T WORK

input = open("input.txt", "r").read()
input = input.split('\n')
input = input[1].split(',')
busIDs = []
counter = 1
output = 0


for bus in input:
    if bus!='x':
        busIDs.append(int(bus))
    else:
        busIDs.append(bus)

i = 0

while i < len(busIDs):
    bus = busIDs[i]
    if bus == 'x':
        i += 1
        continue
    while (output + i) % bus != 0:
        output += counter
    i += 1
    
print(output)

