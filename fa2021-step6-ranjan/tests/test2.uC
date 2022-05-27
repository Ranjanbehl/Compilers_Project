int main() {
	int * ptr;

	ptr = malloc(4);

	* ptr = 7;

	print (* ptr);

	free(ptr);

	return 0;
}