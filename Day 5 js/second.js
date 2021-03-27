var fs = require("fs");

fs.readFile('input.txt', (err, text) => {
    if (err) {
        throw err;
    }

    text = text.toString();
    let input = text.split('\n');
    run(input);
})

function run(input){

    let values = [];

    for(code of input){
        var row_code = code.substring(0, 7);
        var seat_code = code.substring(7, 10);
        let tmp_seat = findSeat(seat_code, 0, 8, 0);
        let tmp_row = findRow(row_code, 0, 128, 0);
        let tmp_seat_ID = calculateID(tmp_row, tmp_seat);

        values.push(tmp_seat_ID);    
    }

    console.log(Math.max(...values));
    console.log(Math.min(...values));
    findMySeat(Math.min(...values), Math.max(...values), values);
    //console.log(seat_ID);  
}

function findMySeat(min, max, array){

    let counter = min;
    var mySeat;

    for(var i=0; i<array.length; i++){
        if(array.includes(counter)){
            counter++;
        }
        else{
            console.log(counter);
            break;
        }
    }
}

function findRow(stringa, min, max, count){    

    const mid = Math.floor((min+max)/2);

    if(count===6){
        if((max-min)===1){
            if(stringa[count]==='B')
                return max;
            else 
                return min;
        }

        else{
            if(stringa[count]==='B')
                return max-1;
            else 
                return min;
        }
    }

    else if(stringa[count]==='B'){
        count++;
        min = mid;
        return findRow(stringa, min, max, count);
    }

    else if(stringa[count]==='F'){
        count++;
        max = mid;
        return findRow(stringa, min, max, count);
    }
}

function findSeat(stringa, min, max, count){    

    const mid = Math.floor((min+max)/2);

    if(count===2){
        if((max-min)===1){
            if(stringa[count]==='R')
                return max;
            else 
                return min;
        }

        else{
            if(stringa[count]==='R')
                return max-1;
            else 
                return min;
        }
    }

    else if(stringa[count]==='R'){
        count++;
        min = mid;
        return findSeat(stringa, min, max, count);
    }

    else if(stringa[count]==='L'){
        count++;
        max = mid;
        return findSeat(stringa, min, max, count);
    }
}

function calculateID(row_number, seat_number){
    return seat_number + (8*row_number);
}