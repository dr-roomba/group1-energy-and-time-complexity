# **Sorting Algorithms Energy & Time Complexity Benchmark**

This project benchmarks the execution time and energy consumption of various sorting algorithms (Bubble Sort, Quick Sort, Merge Sort, and Counting Sort) implemented in Java. It uses a custom C wrapper leveraging Intel's RAPL (Running Average Power Limit) interface to measure the CPU energy consumed during the execution of each algorithm.

## **Prerequisites**

To run these benchmarks, your system must meet the following requirements:

* **Operating System**: Linux (required for access to /dev/cpu/\*/msr).  
* **Hardware**: An Intel CPU that supports RAPL (Sandy Bridge architecture or newer).  
* **Dependencies**:  
  * Java Development Kit (JDK 8 or newer)  
  * GCC (GNU Compiler Collection)  
  * Make  
  * Root/Sudo privileges (required to read MSRs).


## **Project Structure**

* src/main/java/ \- Contains the Java implementations of the sorting algorithms, test files, and data generators.  
* src/c/RAPL/ \- Contains the C code (main.c, rapl.c) to interface with Intel RAPL, and the shell scripts (\*.sh) to automate the benchmarking process.

## **Setup Instructions**

### **1\. Enable the MSR Kernel Module**

The C wrapper reads from Model-Specific Registers (MSRs) to get energy readings. You must load the msr module into your kernel:  
sudo modprobe msr

### **2\. Compile the Java Code**

The benchmark scripts expect the compiled Java .class files to be located in a bin directory at the root of the project.

From the root of the project:  
mkdir \-p bin  
javac \-d bin src/main/java/\*.java

### **3\. Generate Test Arrays**

Before running the benchmarks, you need to generate the datasets (arrays of various distributions and sizes) that the sorting algorithms will process.

Navigate to the java source directory  
cd src/main/java/

Create the arrays directory (required by GenerateArrays.java and startbench.sh)  
mkdir \-p arrays

Uncomment the distributions you want to generate inside GenerateArrays.java's main method, then run GenerateArrays.

*(Note: Be sure to uncomment the relevant array generation blocks inside GenerateArrays.java before running the generator, depending on which distributions you want to test).*

### **4\. Compile the RAPL C Wrapper**

Navigate to the RAPL directory and use the provided Makefile to compile the C program.

From the root of the project:  
cd src/c/RAPL/  
make

## **Running the Benchmarks**

Once everything is compiled and the test arrays are generated, you can run the benchmarking suite. Because reading MSRs requires root access, the scripts will invoke sudo.

Navigate to the RAPL script directory  
cd src/c/RAPL/

Execute the main benchmarking script  
sudo ./startbench.sh

### **Individual Benchmarks**

If you prefer to run benchmarks for a specific sorting algorithm instead of the entire suite, you can run the individual scripts directly:  
sudo ./bubblesort.sh  
sudo ./quicksort.sh  
sudo ./mergesort.sh  
sudo ./countingsort.sh

## **Understanding the Output**

As the benchmarks run, the C wrapper executes the Java programs multiple times (default is 10 rounds) to get an average reading.  
The results are saved as .csv files in the src/c/ directory (one level up from the RAPL directory). For example, running bubblesort.sh will generate src/c/bubblesort.csv.  
**CSV Output Format:**  
\<TestName\>,\<AverageEnergy\_Joules\>,\<AverageTime\_Milliseconds\>

* **TestName**: The distribution type and array size (e.g., rand\_25000).  
* **AverageEnergy**: The CPU Core (PP0) energy consumed in Joules.  
* **AverageTime**: The execution time in milliseconds.