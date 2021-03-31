var fs = require("fs");

fs.readFile('input.txt', (err, text) => {
    if (err) {
        throw err;
    }

    text = text.toString();
    let input = text.split('\n');
    run(input);
})

function splitIntoArray(input) {
    let istructionSet = new Array();
    let tmp = new Array();
    for(istruction of input) {
        istructionSet.push(istruction);
    }

    return istructionSet;
}

function run(input) {
    let istructionSet = splitIntoArray(input);
    let accumulator = 0;
    let i = 0;
    let buffer = new Array();
    while(true) {
        if(buffer.includes(i)){
            console.log(accumulator);
            break
        }
        else    
            buffer.push(i);

        var tmp = istructionSet[i].split(" ");
        if(tmp[0]=="nop"){
            i++;
        } 
    
        else if(tmp[0]=="acc") {
            if(tmp[1][0]=='+') {
                accumulator += parseInt(tmp[1].substring(1));
                i++;
            } else {
                accumulator -= parseInt(tmp[1].substring(1));
                i ++;
            }
        } 
        
        else {
            if(tmp[1][0]=='+')
                i += parseInt(tmp[1].substring(1));
            else 
                i -= parseInt(tmp[1].substring(1));
        }
    }
}