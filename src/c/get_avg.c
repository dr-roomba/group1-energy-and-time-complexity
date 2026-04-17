#include <stdio.h>
#include <string.h>


int main (int argc, char * argv[]) {

    char testName[20];
    char oldName[20] = "";
    double energy = 0, totEnergy = 0;
    double time = 0, totTime = 0;
    int num = 0;

    puts("Size,Energy,Time");
    while (!feof(stdin)) {

        int numRead = fscanf(stdin, "%s %lf %lf %lf", testName, &energy, &energy, &time);

        if (numRead < 4) {
            totEnergy /= num;
            totTime /= num;
            int idx = 0;
            while (oldName[idx] != '_') {
                idx++;
            }
            idx++;
            printf("%s,%lf,%lf\n", &oldName[idx], totEnergy, totTime);

            return 0;
        }

        if (strcmp(oldName,testName) == 0) {
            totEnergy += energy;
            totTime += time;
            num++;
            continue;
        }

        if (oldName[0] != '\0') {
            totEnergy /= num;
            totTime /= num;
            int idx = 0;
            while (oldName[idx] != '_') {
                idx++;
            }
            idx++;
            printf("%s,%lf,%lf\n", &oldName[idx], totEnergy, totTime);
        }

        strcpy(oldName, testName);
        totEnergy = energy;
        totTime = time;
        num = 1;

    }

}