int main() {
    /* Test difference between explicit and implicit casts */
    int x;
    float y;

    y = 2.3;

    x = (2 * y) * 2;
    print(x); /* should print 9 */

    x = ((int) (2 * y)) * 2;
    print(x); /* should print 8 */

    return 0;
}