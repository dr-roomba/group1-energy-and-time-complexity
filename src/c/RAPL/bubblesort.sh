#!/bin/bash
dist=rand

echo $dist
for i in 25000 50000 75000 100000 200000 300000 400000 500000; do
	sudo ./main "java -cp $CP BubbleSort ${dir}${dist}_$i" bubblesort ${dist}_$i
done

dist=sortd

echo $dist
for i in 25000 50000 75000 100000 200000 300000 400000 500000; do
	sudo ./main "java -cp $CP BubbleSort ${dir}${dist}_$i" bubblesort ${dist}_$i
done

dist=rev

echo $dist
for i in 25000 50000 75000 100000 200000 300000 400000 500000; do
	sudo ./main "java -cp $CP BubbleSort ${dir}${dist}_$i" bubblesort ${dist}_$i
done
