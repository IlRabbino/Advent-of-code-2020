var fs = require("fs");

fs.readFile('input.txt', (err, text) => {
    if (err) {
        throw err;
    }

    text = text.toString();
    let input = text.split('\n');
    run(input);
})

const run = (input) => {
    let xmas = getArray(input);
    let find = false;
    var i, j, k;

    for(i=25; i<xmas.length; i++){
        for(j=i-25; j<i; j++){
            for(k=i-25; k<i; k++){
                if(k==j)
                    continue;
                else if(xmas[k]+xmas[j]==xmas[i])
                    find = true;
            }
        }
        if(find==false){
            console.log(xmas[i]);
            break;
        }
        else{
            find = false;
        }
    }
}

function getArray(input) {
    var arr = new Array();
    for(line of input)
        arr.push(parseInt(line));
    return arr;
}