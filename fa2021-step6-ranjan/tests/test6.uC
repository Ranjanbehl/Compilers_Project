string querysize = "Enter size: ";
string prompt = "Enter number: ";
string sorting = "Sorting ...";

void swap(float * x, float * y);
float * allocarray(int size);
void readarray(float * arr, int size);
void sortarray(float * arr, int size);
void printarray(float * arr, int size);

int main() {
	float * f;
	int size;

	print(querysize);
	read(size);

	f = allocarray(size);
	
	readarray(f, size);
	
	sortarray(f, size);

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

void sortarray(float * f, int size) {
	int i;
	int j;
	float cur_min;
	int min_index;

	i = 0;
	while (i < size) {
		j = i;
		cur_min = f[i];
		min_index = i;
		while (j < size) {
			if (f[j] < cur_min) {
				cur_min = f[j];
				min_index = j;
			}
			j = j + 1;
		}
		swap(&f[i], &f[min_index]);
		i = i + 1;
	}

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