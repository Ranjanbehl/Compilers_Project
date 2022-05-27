int main() {
    /* Test explicit cast in expression */
    int x;
    float y;
    float z;

    y = 3.5;
    z = 2.6;

    x = (int) y + (int) z;
    print(x); /* should print 5 */

    return 0;
}