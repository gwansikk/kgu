#include <stdio.h>
#include <stdlib.h>
#include <string.h>


typedef struct addr {
   char *city;
   char *street;
   char *detail;
} address;

typedef struct tag {
   char *name;
   int age;
   address *addr;
} person;

void getString(char **ptr) {
    char temp[20];

    scanf(" %s", temp);

    *ptr = (char *)malloc((strlen(temp) + 1) * sizeof(char));

    strcpy(*ptr, temp);
}

void read_person(person* ptr) {
    getString(&ptr->name);
    scanf("%d", &ptr->age);

    ptr->addr = malloc(sizeof(address));
    
    getString(&ptr->addr->city);
    getString(&ptr->addr->street);
    getString(&ptr->addr->detail);
}

void print_person(person* ptr) {
    printf("이름: %s (%d세) 주소: %s %s %s\n", ptr->name, ptr->age, ptr->addr->city, ptr->addr->street, ptr->addr->detail);
}

int main() {
   person* p[20];
   p[0] = malloc(sizeof(person));
   read_person(p[0]); 
   print_person(p[0]);
   return 0;
}

/* 입력 및 출력
홍길동 20 수원 광교산로 27
이름: 홍길동 (20세) 주소: 수원 광교산로 27
*/