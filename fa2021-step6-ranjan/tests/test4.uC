int main() {
	int * x;
	int size;
	int i;

	size = 10;

	x = malloc(size * 4);

	i = 0;
	while (i < size) {
		x[i] = i;
		i = i + 1;
	}

	i = 0;
	while (i < size) {
		x[i] = x[i] * x[i];
		i = i + 1;
	}

	i = 0;
	while (i < size) {
		print(x[i]);
		i = i + 1;
	}

	free(x);

	return 0;
}