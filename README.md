# KNIME Coding Challenge

The Java program should support the following command line arguments:
```
java org.ali.Main \
--input <ascii-file-containing-strings-separated-by-linebreak.txt> \
--inputtype <string|int|double> \
--operations <operation1[,operation2[...]]> \
--threads <n> \
[--output <output.txt>]
```

The program can be build and executed using maven as follows:
```
mvn clean package
mvn exec:java -Dexec.args="--input example2_strings.txt --inputtype string --operations rev --threads 4 --output output.txt"
```

