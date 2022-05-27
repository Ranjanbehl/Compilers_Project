/* There should be no dead code here, but this will help test liveness */
int main() {
    int x;
    int y;
    int z;

    read(x);

    if (x < 0) {
        return -1;
    }

    y = 0;

    z = 10;

    while (y != x) {

        z = y * 2;

        y = y + 1;
    }

    print (z);

    return 0;
}