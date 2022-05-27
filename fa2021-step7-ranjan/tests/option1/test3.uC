int main() {
    /* Test simple linked list */

    void ** cell1; /* a cons pair */
	void ** cell2; /* a cons pair */
	void ** curr;
	
	int * d; /* used to access first cells -- a pointer to an int*/
	
	cell1 = malloc(8); /* allocate a cons pair: two element void * array */
	cell1[0] = malloc(4); /* allocate an int for the data */
	
	cell2 = malloc(8); /* allocate a cons pair: two eleemnt void * array */
	cell2[0] = malloc(4); /* allocate an int for the data */

	d = (int *) cell1[0];
	* d = 8;
	
	cell1[1] = (void *) cell2; /* cell1's next pointer points to cell2 */
	
	d = (int *) cell2[0];
	* d = 10;
	
	cell2[1] = 0; /* cell2's next pointer points to null */
	
	/* loop through linked list */
	curr = cell1;
	while (curr != 0) {
		d = (int *) curr[0];
		print(* d);
		
		curr = (void **) curr[1];
	}
}