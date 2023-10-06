#include <stdio.h>

int findMinIndex(int A[], int start, int end)
{
    if (A[start] <= A[end])
    { // 배열이 회전되지 않은 경우
        return start;
    }

    int mid = (start + end) / 2;
    if (A[mid] < A[end])
    { // 중간값이 오른쪽 정렬된 배열에 속한 경우
        return findMinIndex(A, start, mid);
    }
    else
    { // 중간값이 왼쪽 정렬된 배열에 속한 경우
        return findMinIndex(A, mid + 1, end);
    }
}

int main()
{
    int A[] = {5, 8, 9, 2, 3, 4};
    int n = sizeof(A) / sizeof(int);
    int minIndex = findMinIndex(A, 0, n - 1);
    printf("회전 연산 수: %d\n", minIndex);
    return 0;
}
