float curVal;
float x;
int degree;

void swap(int * x, int * y);

int main() {
	int * x;

	x = malloc(2 * 4);

	x[0] = 1;
	x[1] = 2;

	swap(&x[0], &x[1]);

	print(x[0]);
	print(x[1]);

	free(x);

	return 0;
}

void swap(int * x, int * y) {
	int tmp;

	tmp = * x;
	* x = * y;
	* y = tmp;

	return;
}