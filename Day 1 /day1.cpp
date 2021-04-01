#include <iostream>
#include <fstream>
using namespace std;


int getDiff(int x, ifstream &in){
    int y, result;
    string str = "";
    for(int i=0; i<200; i++){
        getline(in, str);
        y= stoi(str);
        if((x+y)==2020){
            result = y;
            return result;
        }
    }
}

int main(){
    ifstream in("numeri.txt");

    string str = "";
    string tmp = "";
    int x = 0;
    int y = 0;

    for(int i=0; i<200; i++){
        getline(in, str);
        x = stoi(str);
        ifstream check("numeri.txt");
        for(int j = 0; j<200; j++){
            
            getline(check, tmp);
            int y = stoi(tmp);
            if((x+y)==2020){
                cout << x*y << endl;
                break;
            }
        }
        check.close();
    }

    in.close();
}
