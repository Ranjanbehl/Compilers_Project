string querysize = "Enter size: ";
string prompt = "Enter number: ";
string sorting = "Sorting ...";

void swap(float * x, float * y);
float * allocarray(int size);

void readarray(float * arr, int size);
void printarray(float * arr, int size);

void quicksort(float * arr, int lo, int hi);
int partition(float * arr, int lo, int hi);

int main() {
	float * f;
	int size;

	print(querysize);
	read(size);

	f = allocarray(size);
	
	readarray(f, size);
	
	quicksort(f, 0, size - 1);

	printarray(f, size);

	free(f);

	return 0;
}

float * allocarray(int size) {
	int i;
	float * retval;

	retval = malloc(4 * size);

	i = 0;
	while (i < size) {
		retval[i] = 0.0;
		i = i + 1;
	}

	return retval;
}

void readarray(float * f, int size) {
	int i;
	float x;
	i = 0;

	while (i < size) {
		print(prompt);
		read(x);
		f[i] = x;
		i = i + 1;
	}
	return;
}

void quicksort(float * f, int lo, int hi) {
	int p;
	if (lo < hi) {
		p = partition(f, lo, hi);
		quicksort(f, lo, p - 1);
		quicksort(f, p + 1, hi);
	}
}

int partition(float * f, int lo, int hi) {
	float pivot;
	int i;
	int j;

	pivot = f[hi];
	i = lo;
	j = lo;
	while (j < hi) {
		if (f[j] < pivot) {
			swap(&f[i], &f[j]);
			i = i + 1;
		}
		j = j + 1;
	}
	swap(&f[i], &f[hi]);
	return i;
}

void printarray(float * f, int size) {
	int i;

	i = 0;
	while (i < size) {
		print(f[i]);
		i = i + 1;
	}
}

void swap(float * x, float * y) {
	float tmp;

	tmp = * x;
	* x = * y;
	* y = tmp;

	return;
}