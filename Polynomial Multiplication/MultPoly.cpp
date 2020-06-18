#include<bits/stdc++.h>
using namespace std;

// Naive approach
vector<int> MultPolyNaive(vector<int>a, vector<int>b, int n){
    vector<int>product(2*n-1);
    for(int i=0;i<2*n-1;i++){
        product[i] = 0;
    }
    for(int i=0;i<n;i++){
        for(int j=0;j<n;j++){
            product[i+j] += a[i]*b[j];
        }
    }    
    return product;
}

// Divide and conquer approach, n should be power of 2, a_l is lower coefficient in array a and b_l is lower coefficient in array b in which we are interested
vector<int> MultPoly(vector<int>a, vector<int>b, int n, int a_l, int b_l){
    vector<int>result(2*n-1);
    // base case
    if(n==1){
        result[0] = a[a_l]*b[b_l];
        return result;
    }
    int index=0;
    // results for lower half
    vector<int>result_lower = MultPoly(a, b, n/2, a_l, b_l);
    for(int i=0;i<n-1;i++) result[i] += result_lower[i];
    // results for upper half
    vector<int>result_upper = MultPoly(a, b, n/2, a_l+n/2, b_l+n/2);
    for(int i=n;i<2*n-1;i++){
        result[i] += result_upper[index];
        index++;
    }
    index=0;
    // results for middle elements
    vector<int>d0e1 = MultPoly(a, b, n/2, a_l, b_l+n/2);
    vector<int>d1e0 = MultPoly(a, b, n/2, a_l+n/2, b_l);
    for(int i=n/2;i<n+n/2-1;i++){
        result[i] += d0e1[index]+d1e0[index];
        index++;
    }
    return result;
}

vector<int> sum(vector<int>v, int n, int lb){
    vector<int>v1(v.begin()+lb+n/2,v.end());
    vector<int>v0(v.begin()+lb, v.begin()+lb+n/2);
    vector<int>sum(n/2);
    for(int i=0;i<n/2;i++){
        sum[i] += v0[i] + v1[i];
    }
    cout<<"\n";
    return sum;
}
// karatsuba approach
vector<int> karatsuba(vector<int>a, vector<int>b, int n, int a_l, int b_l){
    vector<int>result(2*n-1);
    // base case
    if(n==1){
        result[0] = a[a_l]*b[b_l];
        return result;
    }
    int index=0;
    // results for lower half
    vector<int>result_lower = MultPoly(a, b, n/2, a_l, b_l);
    for(int i=0;i<n-1;i++) result[i] += result_lower[i];
    // results for upper half
    vector<int>result_upper = MultPoly(a, b, n/2, a_l+n/2, b_l+n/2);
    for(int i=n;i<2*n-1;i++){
        result[i] += result_upper[index];
        index++;
    }
    index=0;
    // results for middle elements
    vector<int>sum_a = sum(a,n,a_l);
    vector<int>sum_b = sum(b,n,b_l);
    vector<int>Mult_ab = MultPoly(sum_a,sum_b,n/2,a_l,b_l);
    for(int i=n/2;i<n+n/2-1;i++){
        result[i] += Mult_ab[index] - result_lower[index] - result_upper[index];
        index++;
    }
    return result;
}

vector<int> MultPolyDnC(vector<int>a, vector<int>b, int n, int type_of_approach){
    if(type_of_approach==2) return karatsuba(a, b, n, 0, 0);
    else if(type_of_approach==1) return MultPoly(a, b, n, 0, 0);
}

bool ispower(int n){
    double m = log2((double)n);
    if((m-(int)m)==0.0) return true;
    return false;
}

int main(){
    int t;
    cin>>t;
    for(int test=0;test<t;test++){
        cout<<"Test: "<<test+1<<" - Enter 0 for naive, 1 for naive divide n conquer, 2 for karatsuba\n";
        int n=0,type_of_approach;
        cin>>type_of_approach;
        while(type_of_approach<0 || type_of_approach>2){
            cout<<"Enter 0, 1 or 2\n";
            cin>>type_of_approach;
        }
        while(n<=0){
            cout<<"Enter size of polynomial equation greater than 0\n";
            cin>>n;
            while(type_of_approach!=0 && !ispower(n)){
                cout<<"Enter size of polynomial equation in power of 2\n";
                cin>>n;
            }
        }
        vector<int>a;
        vector<int>b;
        for(int i=0;i<n;i++){
            int c;
            cin>>c;
            a.push_back(c);
        }
        for(int i=0;i<n;i++){
            int c;
            cin>>c;
            b.push_back(c);
        }
        vector<int>mult;
        if(type_of_approach==0) mult = MultPolyNaive(a,b,n);
        else    mult = MultPolyDnC(a,b,n,type_of_approach);
        cout<<"Result: ";
        for(int i=0;i<2*n-1;i++){
                cout<<mult[i]<<" ";
        }    
        cout<<"\n";
    }
}