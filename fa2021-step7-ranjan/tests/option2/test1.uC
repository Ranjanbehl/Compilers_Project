int main() {
    /* Test implicit cast in assignment */
    int x;
    float y;
    float z;

    y = 3.5;
    z = 2.6;

    x = y + z; 
    print(x); /* should print 6 */

    return 0;
}