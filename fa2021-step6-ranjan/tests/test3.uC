int main() {
	float * f;

	f = malloc(2 * 4);

	f[0] = 1.0;
	f[1] = f[0] * 3.0;

	print(f[1]);

	return 0;
}