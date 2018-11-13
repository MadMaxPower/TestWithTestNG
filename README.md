"# TestWithTestNG" 

Команда для запуская тестов  
**mvn clean test -DsuiteXmlFile=testng.xml**

bugs:
1)Если задать цвет ручке, например красный, или вовсе не задавать, она будет писать всегда синим  
2)Если создать объект с 1 или 2 параметрами, то метод DoSomeElse() возвратит синий всегда, при любых значениях
3)Если ввести шрифт 0, а inkContainer > sizeWord, то write его напишет   
4)Если ввести шрифт 0, а inkContainer < sizeWord, то write его напишет
5)Если ввести шрифт < 0, а inkContainer > sizeWord, то write его напишет