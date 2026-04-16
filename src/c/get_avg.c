#include <stdio.h>
#include <string.h>


int main (int argc, char * argv[]) {

    char testName[20];
    char oldName[20] = "";
    double energy, totEnergy = 0;
    double time, totTime = 0;
    int num = 0;

    puts("Size,Energy,Time");
    while (!feof(stdin)) {

        totEnergy = energy;
        totTime = time;
        num = 1;

        do {
            fscanf(stdin, "%s %lf %lf %lf", testName, &energy, &energy, &time);
            totEnergy += energy;
            totTime += time;
            num++;
            printf("%s %lf %lf\n", testName, energy, time);

        } while (!feof(stdin) && strcmp(oldName, testName) == 0);
        // strcpy(oldName, testName);

        if (num > 0) {

            totEnergy /= num;
            totTime /= num;
            // printf("Name:%s Energy:%lf Time:%lf\n", oldName, totEnergy, totTime);
            int idx = 0;
            while (oldName[idx] != '_') {
                idx++;
            }
            idx++;
            printf("%s,%lf,%lf\n", &oldName[idx], totEnergy, totTime);

        }
        strcpy(oldName, testName);

    }

    // fclose(fp);
    // free(line);

}