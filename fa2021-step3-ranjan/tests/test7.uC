string welcome = "This is a terrible implementation of (x % y) \n";
string xprompt = "Enter x: ";
string yprompt = "Enter y: ";
string result = "(x % y) = ";
int x;
int y;

int main() {

	print(welcome);
	print(xprompt);
	read(x);
	print(yprompt);
	read(y);

	while (x > y) {
		x = x - y;
	}

	print(result);
	print(x);
	
	return 0;
}