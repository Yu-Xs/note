//記憶體存取

#include <iostream>
#include <cstdio>

using namespace std;

int main(){
	int a;
	a = 7;
	printf("%d\n",&a);
	cout << &a << endl;

	int *b;
	b = &a;
	cout << *b << endl;
	system("title XD");
	return 0;
}