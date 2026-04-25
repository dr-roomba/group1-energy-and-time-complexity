

#include <stdio.h>
#include <sys/time.h>
#include <math.h>
#include <string.h>
#include "rapl.h"

#define RUNTIME 1

int main (int argc, char **argv) 
{ char command[500]="",language[500]="", test[500]="", path[500]="";
  int  ntimes = 10;
  int  core = 0;
  int  i=0;

#ifdef RUNTIME

  double time_spent;
  struct timeval tvb,tva;
#endif
  
  FILE * fp;

  //Run command
  strcat(command,argv[1]);
  //Language name
  strcpy(path,"../");


  strcpy(language,argv[2]);
  strcat(language,".csv");
  strcat(path,language);
  //Test name
  strcpy(test,argv[3]);


 

  fp = fopen(path,"a");

  rapl_init(core);



  double avgEnergy = 0;
  double avgTime = 0;
  double energy;
  
  // run command ntimes and calculate average.
  for (i = 0 ; i < ntimes ; i++)
    {  
 
      fprintf(stdout, "Round: %d\n", i);

 	
	      
		#ifdef RUNTIME

				gettimeofday(&tvb,0);
		#endif
	
	rapl_before(fp,core);
	
        system(command);

	energy = rapl_after(fp,core);

		#ifdef RUNTIME

			gettimeofday(&tva,0);
			time_spent = (tva.tv_sec-tvb.tv_sec)*1000000 + tva.tv_usec-tvb.tv_usec;
			time_spent = time_spent / 1000;
      avgTime += time_spent;
    #endif
  avgEnergy += energy;
			

		#ifdef RUNTIME	

		#endif	
    }
    avgEnergy /= ntimes;
    avgTime /= ntimes;
    // save testname, average energy, average time
    fprintf(fp,"%s,%.18lf,%G\n",test, avgEnergy, avgTime);

    

  fclose(fp);
  fflush(stdout);

  return 0;
}



