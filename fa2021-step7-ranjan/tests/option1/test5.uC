void ** cons(void * first, void * second);
void * car(void ** cell);
void * cdr(void ** cell);

int main() {
    /* Test cons interface */

    void ** head;
	void ** curr;

	int * data;

	int i;

	data = malloc(4 * 5);

	i = 1;
	while (i < 6) {
		data[i - 1] = 2 * i;
		i = i + 1;
	}
	
	head = cons((void *) &data[0], cons((void *) &data[1], cons((void *) &data[2], cons((void *) &data[3], cons((void *) &data[4], 0)))));

	/* loop through linked list */
	curr = head;
	while (curr != 0) {
		print( * ((int *) car(curr)));
		
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