//
//  main.cpp
//  HeapSort
//
//  Created by Yaroslav Kohun on 11/27/17.
//  Copyright © 2017 Yaroslav Kohun. All rights reserved.
//

#include<iostream>
#include<stdio.h>
using namespace std;
void printElements(int *array, int n);
int swap(int &x, int &y);
void heapify(int a[], int lower, int upper);
int heapsort(int a[], int numelts);
int cnt = 0;
int countCopm = 0;
int countSwaps = 0;

int main()
{
   /* int b[] = {
        4, 6, 1, 2, 5, 3
    };
    */
    int n = 6;
    int main_count = 0;
    
    std::cout << "Enter number of elements to be sorted : ";
    cin >> n;
    
    int b[n];
    for (int i = 0; i < n; i++) {
        std::cout << "Enter the element: ";
        cin >> b[i];
    }
    
    
    
    
    cout << "*******HEAP SORT**************" << endl << endl;
    cout << "Original Array: " << endl;
    printElements(b, n);
    cout << endl;
    cout << "Sorted Array: " << endl;
    main_count = heapsort(b, n); //call to heap sort
    printElements(b, n);
    cout << endl;
    cout << "Number of comparisons: " << countCopm<<endl;
    cout << "Number of swaps: " << countSwaps<<endl;
    cout << endl << endl;
    
    system("pause");
    return 0;
}
void printElements(int *array, int n) //print array elements
{
    int i = 0;
    for (i = 0; i<n; i++)
        cout << array[i] << " ";
    cout << endl;
}
int swap(int &x, int &y)
{
    countSwaps++;
    //int count = 0;
    int temp;
    //int count = 0;
    temp = x;
    x = y;
    y = temp;
    return cnt;
}
void heapify(int a[], int lower, int upper)
{
    int parent = lower, child;
    
    while (parent <= (upper + 1) / 2 - 1) {
        child = 2 * parent + 1;
        if (child < upper && a[child] < a[child + 1]) {
            child++;
            countCopm++;

        }else countCopm++;
        if (a[child] > a[parent]) {
            swap(a[parent], a[child]);
            parent = child;
            countCopm++;

        }
        else{
            countCopm++;
            return;
        }
    }
    return;
}
int heapsort(int a[], int numelts)
{
    int count = 0;
    
    for (int i = numelts / 2 -1; i >= 0; i--) {
        heapify(a, i, numelts - 1);
        count++;
    }
    
    for (int i = numelts -1; i > 0; i--) {
        swap(a[0], a[i]);
        count++;
        heapify(a, 0, i - 1);
    }
    return count;
}
