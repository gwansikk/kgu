#include <stdio.h>
#include <stdlib.h>
#include <math.h>

/// ADT 
// 자표 위에 놓여질 노드, X, Y의 값을 가지고 있음.
typedef struct __point {
    int x;
    int y;
} Point;

int test();
void input(Point *ptr);                             // 포인터 좌표 입력.
void output(const Point p);                         // 포인터 좌표 출력.
double distance(const Point p1, const Point p2);    // 두 포인터의 거리 계산.
int area(const Point p1, const Point p2);           // 두 포인터의 사각형 면적 계산.
int equals(const Point p1, const Point p2);         // 두 포인터의 좌표가 같은지 검사.
void move(Point *ptr, const Point vec);             // 해당 포인터를 vec 만큼 이동.


int main() {

    while (1) {
        test();
        printf("\n");
    }
    
    return 0;
}

int test() {
    Point p1, p2, vec;

    printf(">> "); input(&p1); // 포인터
    printf(">> "); input(&p2);
    
    if (equals(p1, p2)) {
        printf("두 점이 같습니다.");

        return 0;
    }

    printf("두 점의 거리: %.3f\n", distance(p1, p2));
    printf("두 점에 의한 네모의 면적: %d\n", area(p1, p2));

    printf("이동할 거리: "); input(&vec);
    printf("p1 이동: "); output(p1); printf(" -> "); move(&p1, vec); output(p1);
    printf("\np2 이동: "); output(p2); printf(" -> "); move(&p2, vec); output(p2);

    return 0;
}

void input(Point *ptr) {
    scanf(" %d %d", &ptr->x, &ptr->y);
}

void output(const Point p) {
    printf("(%d, %d)", p.x, p.y);
}

double distance(const Point p1, const Point p2) {
    return sqrt(pow(p1.x - p2.x, 2.0) + pow(p1.y - p2.y, 2.0));
}

int area(const Point p1, const Point p2) {
    if ((p1.x == p2.x) || (p1.y == p2.y))
        return 0;

    return (abs(p1.x - p2.x) * abs(p1.y - p2.y));
}

int equals(const Point p1, const Point p2) {
    if ((p1.x == p2.x) && (p1.y == p2.y))
        return 1;
    
    return 0;
}

void move(Point *ptr, const Point vec) {
    ptr->x += vec.x;
    ptr->y += vec.y;
}
