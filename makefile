VNM.class: VNM.jj TestVNM.java Token.java 
	javacc VNM.jj
	javac  *.java
Token.java: VNM.jj
	javacc VNM.jj
