int foo(int x, int y);

int bar(int x, int y);

int main() {

	int a;
	int b;
	int c;
	int d;

	read(a);
	read(b);

	c = foo(a, b);
	d = bar(a, b);

	print(c);
	print(d);

	return 0;
}

int foo(int x, int y) {
	return x + y;
}

int bar(int x, int y) {
	return x - y;
}