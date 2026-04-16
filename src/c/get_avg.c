#include <stdio.h>
#include <string.h>


int main (int argc, char * argv[]) {

    // if (argc != 2) {
    //     puts("usage: <filename>");
    //     return 1;
    // }

    // FILE * fp = fopen(argv[1], "r");
    // char * line = NULL;
    // size_t size = 0;

    char testName[15];
    char oldName[15] = "";
    double energy, totEnergy = 0;
    double time, totTime = 0;
    char discard[10];

    puts("Size,Energy,Time");
    while (!feof(stdin)) {
        // puts(line);

        // char * testName = strtok(line, ';');
        // char * energy = strtok(NULL, ',');
        // energy = strtok(NULL, ',');

        // fscanf(fp, "%s %.18lf %.18lf %lf", testName, &energy, &energy, &time);

        int num = 0;
        // fscanf(stdin, "%s %lf %lf %lf", testName, &energy, &energy, &time);
        do {
            fscanf(stdin, "%s %lf %lf %lf", testName, &energy, &energy, &time);
            totEnergy += energy;
            totTime += time;
            num++;

        } while (!feof(stdin) && strcmp(oldName, testName) == 0);
        strcpy(oldName, testName);

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
            totEnergy = 0;
            totTime = 0;
            num = 0;

        }

    }

    // fclose(fp);
    // free(line);

}