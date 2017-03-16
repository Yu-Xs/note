// Online Judge System For Tnfsh b030

#include <iostream>
#include <cstdio>
#include <cmath>

using namespace std;

int DP(int p[],int n, int tot, int L, int R);

int main(){
	int n;
	while(~scanf("%d",&n)){
		int p[51];
		int totle = 0;
		for(int i=1; i<=n; i++){
			scanf("%d",&p[i]);
			totle += p[i];
		}

		int ans = DP( p, n, totle, 1, 1);

		printf("%d\n",ans);
	}
}

int DP(int p[], int n, int tot, int L, int R){
	if(L<n){
		int DP_tot = 0;
		for(int i = R; i<=L; i++){
			DP_tot += p[i];
		}
		cout << abs(tot - 2*DP_tot) << endl;
		return min(abs(tot - 2*DP_tot),min(DP( p, n, tot, L+1, R),DP( p, n, tot, L+1, R+1)));
	}else{
		int DP_tot = 0;
		for(int i = R; i<=L; i++){
			DP_tot += p[i];
		}
		cout << abs(tot - 2*DP_tot) << endl;
		return abs(tot - 2*DP_tot);
	}
}