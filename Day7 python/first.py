def thereIsBag(bags, baggy):
    queue = []
    container = []
    queue.append(baggy)

    while len(queue) != 0:
        tmp = queue.pop(0)

        for bag in bags:
            if bag not in container:
                if tmp in bags[bag]:
                    queue.append(bag)
                    container.append(bag)
    
    return container
 
 
 
input = open("input.txt", "r").read()
rules = input.split("\n")
bags = {}


for rule in rules:
    outer, inner = rule.split("contain")
    outer = outer.replace(" bags", "")
    bags[outer] = inner

myResult = list(dict.fromkeys(thereIsBag(bags, "shiny gold")))
print(len(myResult))





