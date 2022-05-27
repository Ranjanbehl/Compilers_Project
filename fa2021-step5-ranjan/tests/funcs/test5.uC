float curVal;
float x;
int degree;

float poly(float curVal, float x, int degree);

string val = "Enter x value to evaluate: ";

string degreePrompt = "Enter a degree: ";

string prompt = "Enter coefficient: ";

int main() {
	int cur;
	curVal = 0.0;
	cur = 0;

	print(val);
	
	read(x);

	print(degreePrompt);

	read(degree);

	curVal = poly(curVal, x, degree);

	print(curVal);

	return 0;
}

float poly(float curVal, float x, int degree) {
	float coeff;
	
	if (degree > 0) {
		curVal = poly(curVal, x, degree - 1);
	}

	print(prompt);

	read(coeff);

	return (x * curVal) + coeff;

}