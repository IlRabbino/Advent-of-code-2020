var fs = require("fs");

fs.readFile('input.txt', (err, text) => {
    if (err) {
        throw err;
    }

    text = text.toString();
    let input = text.split('\n');
    let xmas = getArray(input);
    let x = findX(xmas);
    console.log(run(xmas, x));
})


function compareNumbers(a, b) {
    return a - b;
}


const run = (xmas, x) => {
    let find;
    var i, j;

    for(i=0; i<xmas.length; i++){
        var counter = i+1;
        while(counter<i+1000){
            var sum = xmas[i];
            for(j=i+1; j<counter; j++){
                sum += xmas[j];
            }
            if(sum==x){
                let tmp = xmas.slice(i, j);
                
                tmp.sort(compareNumbers);
                find = tmp[0] + tmp[tmp.length-1];
                console.log(tmp);
                return find;
            }
            counter++;
        }
    }
}

function findX(xmas){
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
            return xmas[i];
        }
            
        
        else{
            find = false;
        }
    }

    return 0;
}

function getArray(input) {
    var arr = new Array();
    for(line of input)
        arr.push(parseInt(line));
    return arr;
}