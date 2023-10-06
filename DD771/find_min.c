#include <stdio.h>

int find_min_array(int arr[], int n)
{
    if (n == 1)        // 만약 배열의 크기가 1이면
        return arr[0]; // 배열의 첫 번째 값을 반환

    // 재귀적으로 함수를 호출하여 배열의 최솟값을 찾음
    int min = find_min_array(arr, n - 1);

    // 현재 배열의 마지막 값과 이전까지 찾은 최솟값을 비교하여 더 작은 값을 반환
    return (arr[n - 1] < min) ? arr[n - 1] : min;
}

int main()
{
    int arr[10] = {3, 2, 4, 6, 8, 1, 9, 4, 5, 4};

    printf("최솟값: %d\n", find_min_array(arr, 10));
}
