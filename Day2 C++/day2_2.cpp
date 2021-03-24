#include <iostream>
#include <fstream>
using namespace std;

int main(){
    ifstream in("password.txt");
    int min, max;
    char toCheck;
    string tmp = "";
    string nbr = "";
    string password = "";
    int contatore = 0;
    
    for(int i=0; i<1000; i++){
        getline(in, tmp);
        
        bool run = true;
        int x = 0;

        while(run){
            if(tmp[x]=='-')
                break;
            else{
                nbr+=tmp[x];
                x++;
            }
        }
        x++;
        min = stoi(nbr);
        nbr = "";

        while(run){
            if(tmp[x]==' ')
                break;
            else{
                nbr+=tmp[x];
                x++;
            }
        }
        x++;
        max = stoi(nbr);
        nbr = "";

        toCheck = tmp[x];
        x+=3;

        while(run){
            if(tmp[x]=='\0')
                break;
            else{
                password+=tmp[x];
                x++;
            }
        }
        cout << password << endl;
        cout << password[min] << endl;
        cout << password[max] << endl;

        if(toCheck==password[min-1]){
            if(toCheck!=password[max-1]){
                contatore++;
            }
        } else if(toCheck==password[max-1]){
            contatore++;
        }
        
        password = "";
    }
    cout << contatore << endl;
    return 0;
}