mvn dependency:copy-dependencies
java -cp 'target/dependency/*' org.apache.derby.tools.ij -p ij.properties
