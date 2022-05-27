int a;
int b;
string s = "Enter a number ";
string found = "Found!\n";

int main() {

	print(s);
	read(a);

	b = 2 * a;

	while (b > 0) {
		print(b);
		if (b == a) {
			print(found);
		}
		b = b - 1;
	}

	return 0;
}