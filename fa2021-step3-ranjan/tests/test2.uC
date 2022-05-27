
int i;
int j;
int max;
int val;
string is = "i: ";
string js = "j: ";
string newline = "\n";

int main() {

	val = 0;

	read(max);

	i = 0;
	while (i < max) {
		print(is);
		print(i);
		print(newline);
		j = i;
		while (j < max) {
			print(js);
			print(j);
			print(newline);
			val = val + 1;
			j = j + 1;
		}
		i = i + 1;
	}
	
	print(val);
	
	return 0;
}