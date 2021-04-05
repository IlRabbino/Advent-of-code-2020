input = open("input.txt", "r").read()
istructions = input.split('\n')
change = [ "nord", "east", "sud", "ovest" ]
ship = { "nord": 0, "east": 0, "sud": 0, "ovest": 0 }   

selected = "east"

for istruction in istructions:
    if istruction[0]=='F':
        ship[selected] += int(istruction[1:])
        
    if istruction[0]=='N':
        ship["nord"] += int(istruction[1:])

    if istruction[0]=='S':
        ship["sud"] += int(istruction[1:])

    if istruction[0]=='E':
        ship["east"] += int(istruction[1:])

    if istruction[0]=='W':
        ship["ovest"] += int(istruction[1:])

    if istruction[0]=='R':
        qnt = int(istruction[1:])/90
        tmp = int(change.index(selected) + qnt)
        if tmp<=3:
            selected = change[tmp]
        else:
            tmp = tmp - 3
            selected = change[tmp-1]

    if istruction[0]=='L':
        qnt = int(istruction[1:])/90
        tmp = int(change.index(selected) - qnt)
        if tmp>=0:
            selected = change[tmp]
        else:
            tmp = tmp + 3
            selected = change[tmp+1]

print(abs(ship["east"]-ship["ovest"]) + abs(ship["nord"]-ship["sud"]))