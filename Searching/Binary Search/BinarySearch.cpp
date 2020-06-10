#include<bits/stdc++.h>
using namespace std;
int BinarySearchRecursive(int a[],int low,int high,int key){
    if(high<low) return -1;
    int mid = low + (high-low)/2;
    if(a[mid] == key) return mid;
    else if(key<a[mid]) return BinarySearchRecursive(a, low, mid-1, key);
    else return BinarySearchRecursive(a, mid+1, high, key);
}
int BinarySearchIterative(int a[],int low,int high, int key){
    while(low<=high){
        int mid = low + (high-low)/2;
        if(a[mid] == key) return mid;
        else if(key<a[mid]) high = mid-1;
        else low = mid+1;
    }
    return -1;
}
int main(){
    int n = 7;
    int arr[] = {2, 8, 11, 23, 31, 34, 65};
    /* low is first index, high is last index of array, key is element to be found*/
    int low = 0, high = n-1, key, process, i;
    cin>>key>>process;
    /*choose Recursion(0) or Iteration(1) process*/
    if(process == 0) i = BinarySearchRecursive(arr,low,high,key);
    else i = BinarySearchIterative(arr,low,high,key);    
    if(i==-1) cout<<"NOT_FOUND";
    else cout<<i;
}