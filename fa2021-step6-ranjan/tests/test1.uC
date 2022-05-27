void swap(int * x, int * y);

int main() {

	int a;
	int b;

	read(a);
	read(b);

	print(a);
	print(b);

	swap (&a, &b);

	print(a);
	print(b);

	return 0;
}

void swap(int * x, int * y) {
	int tmp;

	tmp = * x;
	* x = * y;
	* y = tmp;

	return;
}