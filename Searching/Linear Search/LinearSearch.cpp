#include<bits/stdc++.h>
using namespace std;
int LinearSearchRecursive(int a[],int low,int high,int key){
    if(high>low) return -1;
    if(a[low] == key) return low;
    return LinearSearchRecursive(a,low+1,high,key);
}
int LinearSearchIterative(int a[],int low,int high, int key){
    for(int i=low;i<=high;i++){
        if(a[i] == key) return i;
    }
    return -1;
}
int main(){
    int arr[] = {2, 31, 65, 8, 23, 11, 34};
    /* low is first index, high is last index of array, key is element to be found*/
    int low = 0, high = 7, key, process, i;
    cin>>key>>process;
    /*choose Recursion(0) or Iteration(1) process*/
    if(process == 0) i = LinearSearchRecursive(arr,low,high,key);
    else i = LinearSearchIterative(arr,low,high,key);    
    if(i==-1) cout<<"NOT_FOUND";
    else cout<<i;
}