int fact(int n);

int main() {
	float res;

	res = fact(5);

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