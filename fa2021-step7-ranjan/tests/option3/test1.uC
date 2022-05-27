/* Test basic DCE */
int main() {
    int x;
    int y;
    int z;

    x = 4;
    y = 7;

    z = x + y;

    x = z + 38; /* this code should be dead */

    y = 10 * x; /* this code should be dead */

    print (z);
	
	return 0;
}