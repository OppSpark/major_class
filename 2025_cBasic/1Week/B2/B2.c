#include<stdio.h>

int main(){

    int age, year;

    scanf("%d", &age);

    year = age * 365;

    printf("The age of %d years is %d days.", age, year);

    return 0;
}