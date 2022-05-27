void ** cons(void * first, void * second);
void * car(void ** cell);
void * cdr(void ** cell);

int main() {
    /* Test cons interface */

    void ** head;
	void ** curr;
	
	head = cons(2, cons(4, cons(6, cons(8, cons(10, 0)))));

	/* loop through linked list */
	curr = head;
	while (curr != 0) {
		print((int) car(curr));
		
		curr = (void **) cdr(curr);
	}
}

void ** cons(void * first, void * second) {
	void ** cell;

	cell = malloc(8);

	cell[0] = first;
	cell[1] = second;

	return cell;
}

void * car(void ** cell) {
	return cell[0];
}

void * cdr(void ** cell) {
	return cell[1];
}