input = open("input.txt", "r").read()
istructions = input.split('\n')
change = { "nord": 0, "east": 0, "sud": 0, "ovest": 0 }
waypoint = { "nord": 1, "east": 10, "sud": 0, "ovest": 0 }   
ship = { "nord": 0, "east": 0, "sud": 0, "ovest": 0 }  

selected = "east"

for istruction in istructions:
    if istruction[0]=='F':
        ship["nord"] += int(istruction[1:])*waypoint["nord"]
        ship["east"] += int(istruction[1:])*waypoint["east"]
        ship["sud"] += int(istruction[1:])*waypoint["sud"]
        ship["ovest"] += int(istruction[1:])*waypoint["ovest"]
        
    if istruction[0]=='N':
        waypoint["nord"] += int(istruction[1:])

    if istruction[0]=='S':
        waypoint["sud"] += int(istruction[1:])

    if istruction[0]=='E':
        waypoint["east"] += int(istruction[1:])

    if istruction[0]=='W':
        waypoint["ovest"] += int(istruction[1:])

    if istruction[0]=='R':
        qnt = int(istruction[1:])
        if qnt==90:
            change["east"] = waypoint["nord"]
            change["sud"] = waypoint["east"]
            change["ovest"] = waypoint["sud"]
            change["nord"] = waypoint["ovest"]
        if qnt==180:
            change["sud"] = waypoint["nord"]
            change["ovest"] = waypoint["east"]
            change["nord"] = waypoint["sud"]
            change["east"] = waypoint["ovest"]
        if qnt==270:
            change["ovest"] = waypoint["nord"]
            change["nord"] = waypoint["east"]
            change["east"] = waypoint["sud"]
            change["sud"] = waypoint["ovest"]
        waypoint["nord"] = change["nord"]
        waypoint["sud"] = change["sud"]
        waypoint["east"] = change["east"]
        waypoint["ovest"] = change["ovest"]

    if istruction[0]=='L':
        qnt = int(istruction[1:])
        if qnt==90:
            change["ovest"] = waypoint["nord"]
            change["nord"] = waypoint["east"]
            change["east"] = waypoint["sud"]
            change["sud"] = waypoint["ovest"]
        if qnt==180:
            change["sud"] = waypoint["nord"]
            change["ovest"] = waypoint["east"]
            change["nord"] = waypoint["sud"]
            change["east"] = waypoint["ovest"]
        if qnt==270:
            change["east"] = waypoint["nord"]
            change["sud"] = waypoint["east"]
            change["ovest"] = waypoint["sud"]
            change["nord"] = waypoint["ovest"]
        waypoint["nord"] = change["nord"]
        waypoint["sud"] = change["sud"]
        waypoint["east"] = change["east"]
        waypoint["ovest"] = change["ovest"]

print(abs(ship["east"]-ship["ovest"]) + abs(ship["nord"]-ship["sud"]))