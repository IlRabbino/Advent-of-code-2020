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
    let final = istructionSet.length;

    istructionSet.forEach(item => {
        if(item.substring(0,3)=="nop"){
            item = item.replace("nop", "jmp");
               
            //CONTROLLARE SE TERMINA TUTTE LE ISTRUZIONE E IN CASO INTERROMPERE IL FOREACH E RESTITUTIRE IL VALORE DI ACCUMULATOR

            item = item.replace("jmp", "nop");
        }

        else if(item.substring(0,3)=="jmp"){
            item = item.replace("jmp", "nop");

            //CONTROLLARE SE TERMINA TUTTE LE ISTRUZIONE E IN CASO INTERROMPERE IL FOREACH E RESTITUTIRE IL VALORE DI ACCUMULATOR

            item = item.replace("nop", "jmp");
        }
    });

    
}