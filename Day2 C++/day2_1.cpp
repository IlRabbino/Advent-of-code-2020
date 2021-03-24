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
        cout << "La password in questione è: " << password << endl;

        int count = 0;
        for(int j=0; j<password.length(); j++){
            if(toCheck==password[j])
                count++;
        }

        if(count>=min && count<=max){
            cout << tmp << "Il minimo e " << min << " il massimo e " << max <<endl;
            contatore++;
        }
        password = "";
    }
    cout << contatore << endl;
    return 0;
}