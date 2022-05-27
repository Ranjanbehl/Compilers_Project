int a;
int b;
int c;
int d;
string prompt = "enter a number ";
string output1 = "a less than b";
string output2 = " and less than c \n";
string output3 = " but not less than c \n";
string output4 = "a greater than or equal to b";

int main() {

	print(prompt);
	read(a);
	print(prompt);
	read(b);
	print(prompt);
	read(c);

	if (a < b) {
		print(output1);
		if (a < c) {
			print (output2);
		} else {
			print(output3);
		}
	} else {
		print(output4);
		if (a < c) {
			print (output2);
		}  else {
			print(output3);
		}
	}
	
	return 0;
}