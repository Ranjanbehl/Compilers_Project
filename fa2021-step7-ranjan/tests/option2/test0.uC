int main() {
    /* Test implicit cast in binary expression */
    int x;
    float y;
    float z;

    x = 2;
    y = 3.5;

    z = x + y;
    print(z); /* should print 5.5 */

    return 0;
}