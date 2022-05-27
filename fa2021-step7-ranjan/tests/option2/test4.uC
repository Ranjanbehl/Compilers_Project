/* Now that we have casts, we can implement mod more efficiently, though wrong */

/* return a % b */
/* may not work because of float precision issues :-) */
int mod(int a, int b) {
    float q;

    q = (float) a / (float) b;

    print(q);

    return a - (((int) q) * b);
}

int main() {
    int x;
    int y;

    read(x);
    read(y);

    print(mod(x, y));

    return 0;
}