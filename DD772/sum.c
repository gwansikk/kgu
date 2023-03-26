#include <stdio.h>

int sum_array(int arr[], int n)
{
    if (n == 0)   // 만약 배열의 크기가 0이면
        return 0; // 0을 반환

    // 배열의 마지막 요소와 배열의 크기를 1 감소시킨 배열을 재귀적으로 호출한 결과를 더한 값을 반환
    return arr[n - 1] + sum_array(arr, n - 1);
}

int main()
{
    int arr[10] = {3, 2, 4, 6, 8, 1, 9, 4, 5, 4};

    printf("총 합: %d\n", sum_array(arr, 10));
}
