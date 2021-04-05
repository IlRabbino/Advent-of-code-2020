input = open("input.txt", "r").read()
istructions = input.split('\n')
change = ["nord", "east", "sud", "ovest"]
direction = {"nord": 0,
             "east": 0,
             "sud": 0,
             "ovest": 0
}   

selected = "east"

for istruction in istructions:
    if istruction[0]=='F':
        direction[selected] += int(istruction[1:])
        
    if istruction[0]=='N':
        direction["nord"] += int(istruction[1:])

    if istruction[0]=='S':
        direction["sud"] += int(istruction[1:])

    if istruction[0]=='E':
        direction["east"] += int(istruction[1:])

    if istruction[0]=='W':
        direction["ovest"] += int(istruction[1:])

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

print(abs(direction["east"]-direction["ovest"]) + abs(direction["nord"]-direction["sud"]))