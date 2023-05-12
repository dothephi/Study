#include<stdio.h>

int a; //a is side of the square //
int perimete;
int area;
	
int main(){
	
	printf("side of the rectangle is: ");
	scanf("%d",&a);
	
	int perimeter = a * 4;
	printf("perimeter = %d\n",perimeter);
	int area = a * a;
	printf("area = %d",area);
}