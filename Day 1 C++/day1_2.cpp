#include <iostream>
#include <cstdlib>
#include <fstream>
using namespace std;

int main(){
    ifstream in("numeri.txt");

    string str = "";
    string tmp = "";
    string tmp2 = "";
    int x = 0;
    int y = 0;
    int z = 0;

    for(int i=0; i<200; i++){
        getline(in, str);
        x = stoi(str);
        ifstream check("numeri.txt");
        for(int j = 0; j<200; j++){
            
            getline(check, tmp);
            y = stoi(tmp);
            ifstream check1("numeri.txt");
            for(int k=0; k<200; k++){
                getline(check1, tmp2);
                z = stoi(tmp2);
                if((x+y+z)==2020){
                    cout << x*y*z << endl;
                    return 0;
                }
            }
            check1.close();
        }
        check.close();
    }

    in.close();
}