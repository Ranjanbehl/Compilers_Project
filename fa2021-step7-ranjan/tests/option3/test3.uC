/* Test DCE with control flow */
int main() {
    int x;
    int y;
    int z;

    read(x);
    y = 7;

    z = x + y; /* this code is _not_ dead */

    if (x < y) {
        z = 10;
    } else {
        y = 20; /* this code should be dead */
    }

    print (z);
	
	return 0;	
}