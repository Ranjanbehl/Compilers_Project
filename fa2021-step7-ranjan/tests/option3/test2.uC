/* Test DCE with control flow */
int main() {
    int x;
    int y;
    int z;

    read(x);
    y = 7;

    z = x + y; /* this code should be dead */

    if (x < y) {
        z = 10;
    } else {
        z = 12;
    }

    print (z);
	
	return 0;
}