string true = "True\n";
string false = "False\n";
float a;
float b;

int main() {

	int c;
	int d;

	a = 3.0;
	b = 2.0;

	c = 7;

	d = c * 2;

	if (a >= b) {
		print(d);
		print(true);
	} else {
		print(d);
		print(false);
	}
	
	return 0;
}

float foo(int x, float y) {

	int d;
	float f;
	float a;

	return (y + x);

}