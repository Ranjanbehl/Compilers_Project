string welcome = "Compute GCD(x, y) using Euclid's algorithm \n";
string xprompt = "Enter x: ";
string yprompt = "Enter y: ";
string result = "GCD(x, y) = ";
int x;
int y;
int mod;
int tmp;

string prompt = "Enter a number: ";

int main() {

	print(welcome);
	print(xprompt);
	read(x);
	print(yprompt);
	read(y);

	while (x != 0) {
		/* make x the bigger one */
		if (x <= y) {
			tmp = x;
			x = y;
			y = tmp;
		}

		/* x = x % y */
		while (x >= y) {
			x = x - y;
		}
		print(x);
		print(y);
	}

	print(result);
	print(y);
	
	return 0;
}