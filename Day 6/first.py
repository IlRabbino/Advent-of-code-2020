def answer(answers):
    total = []
    for answer in answers:
        for char in answer:
            if char not in total:
                total.append(char)              
    return len(total)

str = open("input.txt", "r").read()
groups = str.split("\n\n")

tot = 0

for group in groups:
    answers = group.split('\n')
    tot += answer(answers)

print(tot)



