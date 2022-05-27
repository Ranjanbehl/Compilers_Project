float curVal;
float x;
int degree;

float addX(float curVal, float x);

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

	degree = degree + 1;

	while (cur < degree) {
	  cur = cur + 1;
	  curVal = addX(curVal, x);
	}

	print(curVal);

	return 0;
}

float addX(float curVal, float x) {
	float coeff;
	
	print(prompt);

	read(coeff);

	return (x * curVal) + coeff;

}