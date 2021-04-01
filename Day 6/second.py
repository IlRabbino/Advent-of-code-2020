def answer(answers):
    total = []
    howMany = len(answers)
    allChar = []
    for answer in answers:        
        for char in answer:
            allChar.append(char)
    for char in allChar:
            if allChar.count(char)==howMany:
                if char not in total:
                    total.append(char)
    print(total)
    return len(total)

str = open("input.txt", "r").read()
groups = str.split("\n\n")

tot = 0

for group in groups:
    answers = group.split('\n')
    tot += answer(answers)

print(tot)
