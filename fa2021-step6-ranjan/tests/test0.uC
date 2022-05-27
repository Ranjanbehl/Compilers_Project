string true = "True\n";
string false = "False\n";
float a;
float b;

int main() {

	int a;
	int b;
	int * ptr;
	int * * ptr2;

	a = 7;

	ptr = &a;

	* ptr = 8;

	print(a); /* should print 8 */

	b = * ptr + 2;

	print (b); /* should print 10 */

	ptr2 = & ptr;

	* * ptr2 = 9;

	print(a); /* should print 9 */

	* ptr2 = &b;

	print(* ptr); /* should print 10 */


	
	return 0;
}