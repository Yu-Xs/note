//windows.h text

#include <iostream>
#include <cstdio>
#include <cstdlib>
#include <cstring>
#include <windows.h>
#include <strsafe.h>

using namespace std;

void ErrorExit(LPTSTR lpszFunction) 
{ 
    // Retrieve the system error message for the last-error code

    LPVOID lpMsgBuf;
    LPVOID lpDisplayBuf;
    DWORD dw = GetLastError(); 

    FormatMessage(
        FORMAT_MESSAGE_ALLOCATE_BUFFER | 
        FORMAT_MESSAGE_FROM_SYSTEM |
        FORMAT_MESSAGE_IGNORE_INSERTS,
        NULL,
        dw,
        MAKELANGID(LANG_NEUTRAL, SUBLANG_DEFAULT),
        (LPTSTR) &lpMsgBuf,
        0, NULL );

    // Display the error message and exit the process

    lpDisplayBuf = (LPVOID)LocalAlloc(LMEM_ZEROINIT, 
        (lstrlen((LPCTSTR)lpMsgBuf) + lstrlen((LPCTSTR)lpszFunction) + 40) * sizeof(TCHAR)); 
    StringCchPrintf((LPTSTR)lpDisplayBuf, 
        LocalSize(lpDisplayBuf) / sizeof(TCHAR),
        TEXT("%s failed with error %d: %s"), 
        lpszFunction, dw, lpMsgBuf); 
    MessageBox(NULL, (LPCTSTR)lpDisplayBuf, TEXT("Error"), MB_OK); 

    LocalFree(lpMsgBuf);
    LocalFree(lpDisplayBuf);
    ExitProcess(dw); 
}

int main(){
	HANDLE hProcess;
	DWORD PID;
	cin >> PID;
	hProcess = OpenProcess( PROCESS_ALL_ACCESS, false, PID);
	cout << hProcess << endl;
	int a;
	DWORD dwOldProt;
	cout << VirtualProtectEx( hProcess, (LPVOID)0x72fe44, 4, PAGE_EXECUTE_READWRITE, &dwOldProt) << endl;
	ErrorExit(TEXT("GetProcessid"));
	ReadProcessMemory( hProcess, (LPCVOID)0x72fe44, &a, sizeof(a), (SIZE_T)0);
	cout << a;
	system("PAUSE");
	return 0;

}