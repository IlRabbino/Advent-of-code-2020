input = open("input.txt", "r").read()
input = input.split('\n')
erliest_ts = int(input[0])
busIDs = input[1].split(',')
counter = {}
mini = 9999
theBus = ""
while 'x' in busIDs:
    busIDs.remove('x')

for bus in busIDs:
    tmp = 0
    n = int(bus)
    while tmp<=erliest_ts:
        tmp += n
    counter[bus] = tmp

for bus in counter:
    if counter[bus]-erliest_ts<=mini:
        mini = counter[bus]-erliest_ts
        theBus = int(bus)*mini
print(theBus)