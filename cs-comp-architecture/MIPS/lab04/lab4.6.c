/* lab4.6.c : Ackerman's recursion
 *Ackermann's function is recursive function defined as such:
 * int A(int x, y){
	   if (x = 0) return y +1;
	   if (y = 0) return A(x-1, 1)
	   return A(x-1, A(x, y-1))
   }//ackermann's function recursive algorithm
 *
 */
#include <stdio.h>

int A(int x, int y)
{
        if (!x) return y + 1;
        if (!y) return A(x - 1, 1);
        return A(x - 1, A(x, y - 1));
}

int main()
{
	int x, y;

	//input numbers
	printf("Please input the x value for Ackermann's function: ");
    scanf("%d", &x);
    printf("Please input y value for the function: ");
    scanf("%d", &y);

    //print output
    printf("A(%d, %d) = %d\n", x, y, A(x, y));

    return 0;
}
