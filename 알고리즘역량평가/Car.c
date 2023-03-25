#include <stdio.h>

int main() {
    int k;
    int m;

    scanf("%d %d", &k, &m);

    int list[k];

    for (int i = 0; i < k; i++) {
        scanf("%d", &list[i]);
    }

    for (int i = 0; i < m; i++) {
        int count = 0;
        int startPoint;
        int endPoint;

        scanf("%d %d", &startPoint, &endPoint);

        for (int i = 0; i < k; i++)
        {
            if ((startPoint - endPoint <= list[i]) && (startPoint + endPoint) >= list[i]) 
                count++;
        }
        
        printf("%d\n", count);
    }
}