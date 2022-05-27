string factstr = "Enter a number: ";
string outpref = "Factorial of ";
string outsuff = " is ";
int x;

int fact(int n);

int main() {
	int res;

	print(factstr);
	read(x);

	res = fact(x + 2);

	print(outpref);
	print(x + 2);
	print(outsuff);
	print(res);

	return 0;
}

int fact(int n) {
	if (n <= 1) {
		return 1;
	} else {
		return n * fact (n - 1);
	}
}