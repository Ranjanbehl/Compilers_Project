/* Test basic DCE */
int main() {
    int x;
    int y;

    x = 4;
    y = 7;

    x = x * y;

    y = x + 9; /* All of this code should be dead */
	
	return 0;	
}