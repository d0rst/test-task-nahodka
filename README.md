#### Cmd

```sh
Usage: <main class> [-a=<a>] [-b=<b>] [-c=<c>] [-conf=<conf>] [-f=<xmlin>]
  -a=<a>
  -b=<b>
  -c=<c>
      -conf=<conf>   Path and name of config file.dao.param = <SQLITE or
                       ORACLE_XE>
                     db.url= <url or path>
                     db.user= <user>
                     db.pass= <pass>
                     xml.outpath = <xml output path>
  -f=<xmlin>         Path and name of xml file
```

Example
> java -jar test-task-nahodka.jar -a=5 -b=5 -c=4

> java -jar test-task-nahodka.jar -f=table.xml

#### Config

```sh
dao.param = SQLITE
db.url=jdbc:sqlite:C:\\Users\\StebunovIV\\Desktop\\java_hw\\test-task-nahodka\\mult_table.db
xml.outpath = ..\\table.xml
```

