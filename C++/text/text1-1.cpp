//記憶體存取

#include <iostream>
#include <cstdlib>

using namespace std;

int main(){
	int a;
	a = *((int *)0x72fe44);
	cout << a << endl;
	system("PAUSE");
	return 0;
}