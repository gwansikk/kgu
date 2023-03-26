#include <stdio.h>

void selection_sort(int arr[], int n)
{
    if (n <= 1) // 배열의 크기가 1 이하면 정렬할 필요가 없으므로 종료
        return;

    int max = 0; // 최대값의 인덱스를 저장할 변수

    for (int i = 1; i < n; i++) // 배열의 모든 요소를 탐색
        if (arr[i] > arr[max])  // 현재 요소가 최대값보다 크면
            max = i;            // 최대값의 인덱스를 현재 인덱스로 갱신

    // SWAP
    int temp = arr[n - 1];
    arr[n - 1] = arr[max];
    arr[max] = temp;

    // 재귀적으로 함수를 호출하여 배열의 마지막 요소를 제외한 나머지 요소를 정렬
    selection_sort(arr, n - 1);
}

int main()
{
    int arr[10] = {3, 2, 4, 6, 8, 1, 9, 4, 5, 4};

    for (int i = 0; i < 10; i++)
        printf("%d ", arr[i]);
    printf("\n");

    selection_sort(arr, 10);

    for (int i = 0; i < 10; i++)
        printf("%d ", arr[i]);
    printf("\n");
}
