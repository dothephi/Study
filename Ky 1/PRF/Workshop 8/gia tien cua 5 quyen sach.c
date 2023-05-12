#include<stdio.h>

int main(){
	double a[5];
	int i;
	double sum=0;
	printf("Enter price of the book: \n");
	for(i=0; i<5; i++)
{	
	scanf("%lf", &a[i]);
}
	for(i=0; i<5; i++)
{
	if(a[i] >= 10 && a[i] <= 15)
	{
		a[i] = a[i] - ((a[i]*10)/100);
	}
	sum += a[i];
}
	printf("Output : %.1lf",sum);
	getchar();
	return 0;
}